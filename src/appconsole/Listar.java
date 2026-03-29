package appconsole;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;
import modelo.Genero;
import modelo.Video;
import util.Util;

import java.util.List;

public class Listar {
    private ObjectContainer manager;

    public Listar() {
        Util.conectar();

        manager = Util.getManager();

        System.out.println("Lista de gêneros");
        Query q = manager.query();
        q.constrain(Genero.class);
        List<Genero> listaGeneros = q.execute();
        for (Genero genero : listaGeneros) {
            System.out.println(genero);
        }

        System.out.println("\n\nLista de vídeos");
        q = manager.query();
        q.constrain(Video.class);
        List<Video> listaVideos = q.execute();
        for (Video video : listaVideos) {
            System.out.println(video);
        }
        Util.desconectar();
    }
    

    public static void main(String[] args) {
        new Listar();
    }
}
