package com.example.capytur;

public class PontoTuristico {
    private String nome;
    private String descricao;

    public PontoTuristico(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome(){
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }
}
