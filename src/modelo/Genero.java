package modelo;

import java.util.ArrayList;

public class Genero {
    // Declaração das variáveis da classe
    private final String nome;
    private ArrayList<Video> listaVideos; // Um gênero pode ter vários vídeos N:N

    // Construtor
    public Genero(String nome, ArrayList<Video> listaVideos){
        this.nome = nome;
        this.listaVideos = listaVideos;
    }

    // Metodos Get

    public String getNome() {
        return nome;
    }

    public ArrayList<Video> getListaVideos() {
        return listaVideos;
    }

    // Metodos Set

    public void setListaVideos(ArrayList<Video> listaVideos) {
        this.listaVideos = listaVideos;
    }
}
