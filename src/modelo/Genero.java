package modelo;

import java.util.ArrayList;
import java.util.List;

public class Genero {
    // Declaração das variáveis da classe
    private int id;
    private final String nome;
    private List<Video> listaVideos = new ArrayList<>(); // Um gênero pode ter vários vídeos N:N

    // Construtor
    public Genero(String nome){
        this.nome = nome;
    }

    // Metodos Get

    public String getNome() {
        return nome;
    }

    public List<Video> getListaVideos() {
        return listaVideos;
    }

    // Metodos Set / add e remover

    public void addVideo(Video video) {
        listaVideos.add(video);
    }

    public void removerVideo(Video video) {
        listaVideos.remove(video);
    }

    // Metodo toString override

    @Override
    public String toString() {
        String texto = "\nGênero " + id + ": " + nome + "\nVídeos: ";
        if (listaVideos.isEmpty())
            texto += "Sem vídeos";
        else
            for(Video v: listaVideos)
                texto += "'" + v.getTitulo() + "'" + ";\n";
        return texto;
    }
}
