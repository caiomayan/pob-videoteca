package modelo;

import java.util.ArrayList;
import java.util.List;

public class Video {
    // Declaração de variáveis
    private int id;
    private String titulo;
    private String data;
    private String linksite;
    private String classificacao;
    private List<Genero> listaGeneros = new ArrayList<>(); // Um vídeo pode ter vários gêneros N:N

    // Construtor
    public Video(String titulo, String data, String linksite, String classificacao){
        this.titulo = titulo;
        this.data = data;
        this.linksite = linksite;
        this.classificacao = classificacao;
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

    public List<Genero> getListaGeneros() {
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
        if(!listaGeneros.contains(genero)){
            listaGeneros.add(genero);
            genero.addVideo(this);
        }
    }

    public void removerGenero(Genero genero) {
        if(listaGeneros.contains(genero)){
            listaGeneros.remove(genero);
            genero.removerVideo(this);
        }

    }

    // Metodo toString

    @Override
    public String toString() {
        String texto = "\nVídeo " + id + ": " + titulo + "\nData: " + data + "\nClassificação: " + classificacao + "\nURL: '" + linksite + "'" + "\nGêneros: " ;
        if (listaGeneros.isEmpty())
            texto += "Sem gêneros";
        else
            for(Genero g: listaGeneros)
                texto += g.getNome() + "; ";
        return texto;
    }
}
