package br.edu.up.controle;

import br.edu.up.modelo.Viagem;
import br.edu.up.modelo.Avaliacao;
import br.edu.up.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ControleDeViagem {
    private List<Viagem> viagens = new ArrayList<>();
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public void adicionarViagem(Viagem viagem, Cliente clienteLogado) {
        viagem.addCliente(clienteLogado);
        viagens.add(viagem);    
    }
    public void adicionarAvaliacao(Viagem viagem, Avaliacao avaliacao) {
        for (Viagem v : viagens) {
            if (v.equals(viagem)) {
                v.addAvaliacao(avaliacao);
                avaliacoes.add(avaliacao); 
                return;
            }
        }
        System.out.println("Viagem não encontrada para adicionar a avaliação.");
    }

    public List<Viagem> listarViagens() {
        return viagens;
    }
    
    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
    
    public List<Viagem> procurarViagens(String destino) {
        List<Viagem> resultado = new ArrayList<>();
        for (Viagem viagem : viagens) {
            if (viagem.getDestino().equalsIgnoreCase(destino)) {
                resultado.add(viagem);
            }
        }
        return resultado;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }
    public List<Viagem> listarViagensCliente(Cliente cliente) {
        List<Viagem> viagensCliente = new ArrayList<>();
        for (Viagem viagem : viagens) {
            if (viagem.getClientes().contains(cliente)) {
                viagensCliente.add(viagem);
            }
        }
        return viagensCliente;
    }
    
}
