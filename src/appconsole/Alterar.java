package appconsole;

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

        // Remover relacionamento entre a notícia do Jornal Nacional e o gênero Jornalismo

        Query q = manager.query();
        q.constrain(Video.class);
        q.descend("titulo").constrain("JN: Governador do Rio de Janeiro, Cláudio Castro, do PL, renuncia ao cargo");

        List<Video> videos = q.execute();

        if (videos.isEmpty()) {
            System.out.println("Não existe nenhum vídeo com o nome especificado.");
        } else if (videos.getFirst().getListaGeneros().isEmpty()) {
        	System.out.println("Esse vídeo não tem gêneros.");
        } else {
        	Genero genero = videos.getFirst().getListaGeneros().getFirst();
        	Video v = genero.getListaVideos().getFirst();
    		genero.removerVideo(v);
            System.out.println("Gênero '" + genero.getNome() + "' removido do vídeo:\n" + "'" + v.getTitulo()+ "'");
            manager.store(v);
            manager.store(genero);
            manager.commit();        	
        }
        Util.desconectar();
    }


public static void main(String[] args) { new Alterar(); }
}