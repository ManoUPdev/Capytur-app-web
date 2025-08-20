package br.edu.up.modelo;

public class Avaliacao {
    private int nota;
    private Viagem viagem;
    private String titulo;

    public Avaliacao(int nota, Viagem viagem, String titulo) {
        this.nota = nota;
        this.viagem = viagem;
        this.titulo = titulo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    @Override
    public String toString() {
        return "Avaliacao [nota=" + nota + ", viagem=" + viagem + ", titulo=" + titulo + "]";
    }
}
