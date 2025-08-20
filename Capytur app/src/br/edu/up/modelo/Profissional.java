package br.edu.up.modelo;

public class Profissional {
    private String tipo;
    private String nome;
    private String especialidade;

    public Profissional(String tipo, String nome, String especialidade) {
        this.tipo = tipo;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void exibirInformacoes() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Nome: " + nome);
        System.out.println("Especialidade: " + especialidade);
    }
}
