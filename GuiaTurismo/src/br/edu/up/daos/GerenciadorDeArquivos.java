package br.edu.up.daos;

import br.edu.up.modelo.Cliente;
import br.edu.up.modelo.Profissional;
import br.edu.up.modelo.Viagem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GerenciadorDeArquivos {

    public void salvarDados(String nomeArquivo, List<Cliente> clientes, List<Viagem> viagens, List<Profissional> profissionais, Map<Viagem, List<Cliente>> clientesPorViagem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            // Escreve os clientes
            for (Cliente cliente : clientes) {
                writer.write("Cliente: " + cliente.getNome() + ", Username: " + cliente.getUsername() + ", Senha: " + cliente.getSenha() + ", Admin: " + cliente.isAdmin());
                writer.newLine();
            }
            
            // Escreve as viagens e os clientes associados
            for (Viagem viagem : viagens) {
                writer.write("Viagem: " + viagem.toString());
                writer.newLine();
                List<Cliente> clientesDaViagem = clientesPorViagem.get(viagem);
                if (clientesDaViagem != null) {
                    for (Cliente cliente : clientesDaViagem) {
                        writer.write("Cliente associado à viagem: " + cliente.getUsername());
                        writer.newLine();
                    }
                }
            }
            
            // Escreve os profissionais
            for (Profissional profissional : profissionais) {
                writer.write("Profissional: " + profissional.getNome() + ", Especialidade: " + profissional.getEspecialidade());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados no arquivo: " + e.getMessage());
        }
    }
}
