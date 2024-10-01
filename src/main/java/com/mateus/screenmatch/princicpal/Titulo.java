package com.mateus.screenmatch.princicpal;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {

    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private Integer anoDeLancamento;

    @SerializedName("Genre")
    private String genero;
    @SerializedName("Runtime")
    private String duracaoMinutos;

    public Titulo() {
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "nome='" + nome + '\'' +
                ", anoDeLancamento=" + anoDeLancamento +
                ", genero='" + genero + '\'' +
                ", duracaoMinutos='" + duracaoMinutos + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(Integer anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(String duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public int compareTo(Titulo o) {
        return 0;
    }
}
