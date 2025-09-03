package com.turismo.capytur.web.modelo;

import jakarta.persistence.*;

@Entity
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destino;
    private double preco;

    public Viagem() {}

    public Viagem(String destino, double preco) {
        this.destino = destino;
        this.preco = preco;
    }

    //getters e setters
    public Long getId() { return id; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco;}
}
