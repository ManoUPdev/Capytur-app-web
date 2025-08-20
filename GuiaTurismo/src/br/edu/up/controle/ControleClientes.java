package br.edu.up.controle;

import br.edu.up.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ControleClientes {
    private List<Cliente> clientes;

    public ControleClientes() {
        this.clientes = new ArrayList<>();
    }

    public boolean login(String username, String senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getUsername().equals(username) && cliente.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdmin(String username) {
        for (Cliente cliente : clientes) {
            if (cliente.getUsername().equals(username) && cliente.isAdmin()) {
                return true;
            }
        }
        return false;
    }

    public void registrar(String nome, String username, String senha, boolean isAdmin) {
        Cliente novoCliente = new Cliente(nome, username, senha, isAdmin);
        clientes.add(novoCliente);
    }

    public void removerCliente(String username) {
        Cliente clienteRemover = null;
        for (Cliente cliente : clientes) {
            if (cliente.getUsername().equals(username)) {
                clienteRemover = cliente;
                break;
            }
        }
        if (clienteRemover != null) {
            clientes.remove(clienteRemover);
        }
    }

    public List<String> listarClientes() {
        List<String> usernames = new ArrayList<>();
        for (Cliente cliente : clientes) {
            usernames.add(cliente.getUsername());
        }
        return usernames;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente(String username) {
        for (Cliente cliente : clientes) {
            if (cliente.getUsername().equals(username)) {
                return cliente;
            }
        }
        return null; 
    }
}
