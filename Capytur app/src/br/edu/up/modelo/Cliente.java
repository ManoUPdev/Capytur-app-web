package br.edu.up.modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Cliente {
    private String nome;
    private String username;
    private String senha;
    private boolean isAdmin;

    public Cliente(String nome, String username, String senha, boolean isAdmin) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.isAdmin = isAdmin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void salvarParaArquivo(String nomeDoArquivo) {
        try {
            FileWriter arquivo = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivo);

            gravador.println("Nome: " + nome);
            gravador.println("Username: " + username);
            gravador.println("Senha: " + senha);
            gravador.println("É admin: " + isAdmin);

            gravador.close();
            System.out.println("Cliente salvo com sucesso em " + nomeDoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar cliente em arquivo: " + e.getMessage());
        }
    }

    public String toCSV() {
        return "Nome:" + nome + "," + "Username:" + username + "," + "Senha:" + senha + "," + "Admin:" + isAdmin;
    }
}
