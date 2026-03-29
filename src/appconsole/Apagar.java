package appconsole;

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
        Util.conectar();

        manager = Util.getManager();
        Query q = manager.query();

        System.out.println("\n\nLista de vídeos");
        q.constrain(Video.class);
        List<Video> listaVideos = q.execute();
        for (Video video : listaVideos) {
            System.out.println(video);
            manager.delete(video);
            manager.commit();
        }
        
        System.out.println("Lista de gêneros");
        q = manager.query();
        q.constrain(Genero.class);
        List<Genero> listaGeneros = q.execute();
        for (Genero genero : listaGeneros) {
            System.out.println(genero);
            manager.delete(genero);
            manager.commit();
        }
        Util.desconectar();
    }
    
    public void apagarVideo(int id) {
        Query q = manager.query();
        q.constrain(Video.class);
        q.descend("id").constrain(id);

        List<Video> lista = q.execute();

        if (!lista.isEmpty()) {
            manager.delete(lista.get(0));
            manager.commit();
            System.out.println("Vídeo removido.");
        } else {
            System.out.println("Vídeo não encontrado.");
        }
    }
    
    public void apagarGenero(int id) {
    	Query q = manager.query();
    	q.constrain(Genero.class);
    	q.descend("id").constrain(id);
    	
    	List<Genero> lista = q.execute();
    	
    	if (!lista.isEmpty()) {
    		manager.delete(lista.get(0));
    		manager.commit();
    	} else {
    		System.out.println("Vídeo não encontrado.");
    	}
    }
    
    public static void main(String[] args) {
        new Apagar();
    }
}