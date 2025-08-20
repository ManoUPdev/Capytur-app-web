package br.edu.up.modelo;

import java.util.ArrayList;
import java.util.List;

public class Viagem {
    private String destino;
    private String descricao;
    private String data;
    private String local;
    private List<Cliente> clientes;
    private List<Avaliacao> avaliacoes;
    private List<Servico> servicos; // Adicionando lista de serviços à classe Viagem

    public Viagem(String destino, String descricao, String data, String local) {
        this.destino = destino;
        this.descricao = descricao;
        this.data = data;
        this.local = local;
        this.clientes = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
        this.servicos = new ArrayList<>(); // Inicializa a lista de serviços
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void addAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }

    public void addServico(Servico servico) {
        this.servicos.add(servico); // Adiciona um serviço à lista de serviços
    }

    @Override
    public String toString() {
        return "Viagem [destino=" + destino + ", descricao=" + descricao + ", data=" + data + ", local=" + local + "]";
    }

    public Cliente getCriador() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCriador'");
    }
}
