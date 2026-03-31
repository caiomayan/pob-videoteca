package appconsole;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;
import modelo.Genero;
import modelo.Video;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Consultar {
    private ObjectContainer manager;

    public Consultar() {
        Util.conectar();
        manager = Util.getManager();

        // 1ª consulta - - Quais os vídeos de classificação X?

        // Declaração da variável X de consulta a ser restringida
        String x = "12";

        String textoConsulta1 = "__________ 1ª consulta __________\n- Quais os vídeos de classificação +" + x + "?";

        System.out.println(textoConsulta1);

        Query q = manager.query();
        q.constrain(Video.class);
        q.descend("classificacao").constrain(x);
        List<Video> videos = q.execute();
        if (videos.isEmpty()) {
            System.out.println("Nenhum vídeo encontrado");
        }
        for (Video video : videos) {
            System.out.println(video);
        }

        // 2ª consulta - Quais vídeos do gênero de nome X?

        // Redeclarando variável X de consulta a ser restringida
        x = "Ação";

        String textoConsulta2 = "\n__________ 2ª consulta __________\n- Quais vídeos do gênero de nome " + x + "?";

        System.out.println(textoConsulta2);

        q = manager.query();
        q.constrain(Video.class);
        q.descend("listaGeneros").descend("nome").constrain(x);
        videos = q.execute();
        if (videos.isEmpty()) {
            System.out.println("Nenhum vídeo encontrado");
        }
        for (Video video : videos) {
            System.out.println(video);
        }

        // 3ª consulta - Quais os gêneros que tem mais de N vídeos com classificação X?

        // Redeclarando variável X de consulta a ser restringida
        x = "14";
        // Declarando variável N da quantidade de ocorrências da consulta
        int n = 1;

        String textoConsulta3 = "\n__________ 3ª consulta __________\n- Quais os gêneros que tem mais de " + n + " vídeo/vídeos com classificação +" + x + "?\n";

        System.out.println(textoConsulta3);

        q = manager.query();
        q.constrain(Genero.class);

        q.descend("listaVideos").descend("classificacao").constrain(x);
        List<Genero> generos = q.execute();
        if (generos.isEmpty()) {
            System.out.println("Nenhum gênero encontrado");
        }
        for (Genero genero : generos) {
            int i = 0;
            for(Video video : genero.getListaVideos()) {
                if (video.getClassificacao().equals(x)) {
                    i++;
                }
            }
            if(i > n)
                System.out.println(genero);
        }

        // Fim

        Util.desconectar();
        System.out.println("\nFim da consulta.");
    }

    public static void main(String[] args) {
        new Consultar();
    }
}
