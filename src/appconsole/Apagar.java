package appconsole;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Genero;
import modelo.Video;
import util.Util;

public class Apagar {
    private ObjectContainer manager;

    public Apagar() {
        Util.conectar();
        manager = Util.getManager();
  

        Query q = manager.query();
        q.constrain(Video.class);
        q.descend("classificacao").constrain("Livre"); // Remover primeiro video com classificacao livre

        List<Video> lista = q.execute();

        if (lista.isEmpty()) {
            System.out.println("Não existe vídeos com classificação livre.");
        } else {
        	Video video = lista.get(0);
        	for (Genero g : new ArrayList<>(video.getListaGeneros())) {
        		if (g.getListaVideos().contains(video)) {
        			g.removerVideo(video);
        			manager.store(g);
        		}
	        }
        	
            manager.delete(lista.get(0));
            manager.commit();
            System.out.println("Vídeo '" + video.getTitulo() + "' Removido");
        }
 
        Util.desconectar();
    }


public static void main(String[] args) {
    	new Apagar();

	}
}