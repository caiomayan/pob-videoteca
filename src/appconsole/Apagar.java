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
    
    
    
    public static void main(String[] args) {
        new Apagar();
    }
}