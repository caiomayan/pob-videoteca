package appconsole;

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
    }

    public void apagarTudo() {
        Query q = manager.query();

        System.out.println("\nApagando vídeos...");
        q.constrain(Video.class);
        List<Video> listaVideos = q.execute();
        for (Video video : listaVideos) {
            manager.delete(video);
        }

        System.out.println("Apagando gêneros...");
        q = manager.query();
        q.constrain(Genero.class);
        List<Genero> listaGeneros = q.execute();
        for (Genero genero : listaGeneros) {
            manager.delete(genero);
        }

        manager.commit(); 
    }

    public void apagarVideo(int id) {
        Query q = manager.query();
        q.constrain(Video.class);
        q.descend("id").constrain(id);

        List<Video> lista = q.execute();

        if (lista.isEmpty()) {
            System.out.println("Vídeo não encontrado.");
        } else {
        	Video video = lista.get(0);
        	if (video.getListaGeneros() != null) {
	        	for (Genero g : new ArrayList<>(video.getListaGeneros())) {
	        		if (g.getListaVideos().contains(video)) {
	        			g.removerVideo(video);
	        			manager.store(g);
	        		}
	        	}
        	}
            manager.delete(lista.get(0));
            manager.commit();
            System.out.println("Vídeo removido.");
        }
    }

    public void apagarGenero(int id) {
        Query q = manager.query();
        q.constrain(Genero.class);
        q.descend("id").constrain(id);

        List<Genero> lista = q.execute();

        if (lista.isEmpty()) {
            System.out.println("Gênero não encontrado.");
        } else {
        	Genero genero = lista.get(0);
        	if (genero.getListaVideos() != null) {
	        	for (Video v : new ArrayList<>(genero.getListaVideos())) {
	        		if (v.getListaGeneros().contains(genero)) {
		        		v.removerGenero(genero);
		        		manager.store(v);
	        		}
	        	}
        	}
            manager.delete(lista.get(0));
            manager.commit();
            System.out.println("Gênero removido.");
        }
    }

    public void fechar() {
        Util.desconectar();
    }

    public static void main(String[] args) {
        Apagar ap = new Apagar();
        
        ap.apagarVideo(70);
        ap.apagarGenero(57);

        ap.fechar();
    }
}