package br.edu.up.modelo;

import java.util.ArrayList;
import java.util.List;

public class Servico {
    private String nome;
    private String especialidade;
    private Profissional prestador; // Novo atributo para armazenar o prestador do serviço
    private List<Cliente> solicitantes;

    public Servico(String nome, String especialidade, Profissional prestador) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.prestador = prestador;
        this.solicitantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public Profissional getPrestador() {
        return prestador;
    }

    public List<Cliente> getSolicitantes() {
        return solicitantes;
    }

    public void adicionarSolicitante(Cliente cliente) {
        solicitantes.add(cliente);
    }

    @Override
    public String toString() {
        return "Servico{" +
                "nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", prestador=" + prestador +
                '}';
    }
}
