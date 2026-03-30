package appconsole;

import java.util.ArrayList;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Genero;
import modelo.Video;
import util.Util;

public class Alterar {
    private ObjectContainer manager;

    public Alterar() {
        Util.conectar();
        manager = Util.getManager();
  

        Query q = manager.query();
        q.constrain(Genero.class);
        q.descend("nome").constrain("Ação"); // Remover primeiro video de gênero ação

        List<Genero> lista = q.execute();

        if (lista.isEmpty()) {
            System.out.println("Não existe gênero ação.");
        } else if(lista.get(0).getListaVideos().isEmpty()){
        	System.out.println("Naõ existe vídeos de gênero ação");
        } else {
        	Genero genero = lista.get(0);
        	Video v = genero.getListaVideos().get(0);
    		genero.removerVideo(v);
            System.out.println("Gênero '" + genero.getNome() + "' Removido do vídeo " + v.getTitulo());
            manager.store(v);
            manager.store(genero);
            manager.commit();        	
        }
 
        Util.desconectar();
    }


public static void main(String[] args) {
    	new Alterar();

	}
}