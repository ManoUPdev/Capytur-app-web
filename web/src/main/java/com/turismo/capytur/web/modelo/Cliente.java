package com.turismo.capytur.web.modelo;

import jakarta.persistence.*;


public class Cliente {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String nome;
    private String username;
    private String senha;
    private boolean admin;

    // getters e setters

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public boolean isAdmin() { return admin; }
    public void setAdmin(boolean admin) { this.admin = admin; }

}
