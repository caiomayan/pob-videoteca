package modelo;

import java.util.ArrayList;

public class Video {
    // Declaração de variáveis
    private int id;
    private String titulo;
    private String data;
    private String linksite;
    private String classificacao;
    private ArrayList<Genero> listaGeneros = new ArrayList<>(); // Um vídeo pode ter vários gêneros N:N

    // Construtor
    public Video(String titulo, String data, String linksite, String classificacao){
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

    // Metodos Set / add e remover

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

    public void addGenero(Genero genero) {
        listaGeneros.add(genero);
    }

    public void removerGenero(Genero genero) {
        listaGeneros.remove(genero);
    }

    // Metodo toString

    @Override
    public String toString() {
        String texto= "ID: "+id + " Título:" + String.format("%8s", titulo) + " Gêneros:" ;
        if (listaGeneros.isEmpty())
            texto += "Sem gêneros";
        else
            for(Genero g: listaGeneros)
                texto += g.getNome() + ", ";
        return texto;

    }
}
