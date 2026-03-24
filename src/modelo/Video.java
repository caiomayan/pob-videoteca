package modelo;

import java.util.ArrayList;

public class Video {
    // Declaração de variáveis

    private final int id;
    private String titulo;
    private String data;
    private String linksite;
    private String classificacao;
    private ArrayList<Genero> listaGeneros; // Um vídeo pode ter vários gêneros N:N

    // Construtor
    public Video(int id, String titulo, String data, String linksite, String classificacao){
        this.id = id;
        this.titulo = titulo;
    }

    // Metodos Get

    public int getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }

    public String getData() {
        return data;
    }
    public String getLinksite() {
        return linksite;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public ArrayList<Genero> getListaGeneros() {
        return listaGeneros;
    }

    // Metodos Set

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLinksite(String linksite) {
        this.linksite = linksite;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public void setListaGeneros(ArrayList<Genero> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }
}
