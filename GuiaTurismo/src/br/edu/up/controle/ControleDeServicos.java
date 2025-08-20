package br.edu.up.controle;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.modelo.Profissional;
import br.edu.up.modelo.Servico;

public class ControleDeServicos {
    private List<Servico> servicos;
    private List<Profissional> profissionais;

    public ControleDeServicos() {
        this.servicos = new ArrayList<>();
        this.profissionais = new ArrayList<>();
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public void contratarProfissional(String tipo, String nome, String especialidade) {
        Profissional profissional = new Profissional(tipo, nome, especialidade);
        profissionais.add(profissional);
    }

    public void removerProfissional(Profissional profissional) {
        profissionais.remove(profissional);
    }

    public List<Profissional> getProfissionaisEmpresa() {
        return new ArrayList<>(profissionais);
    }

    public List<String> listarProfissionais() {
        List<String> lista = new ArrayList<>();
        for (Profissional profissional : profissionais) {
            lista.add("Nome: " + profissional.getNome() + ", Especialidade: " + profissional.getEspecialidade());
        }
        return lista;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public void setProfissionais(List<Profissional> profissionais) {
        this.profissionais = profissionais;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public List<Profissional> getProfissionais() {
        return profissionais;
    }

    public void editarProfissional(int index, String nome, String especialidade) {
        if (index >= 0 && index < profissionais.size()) {
            Profissional profissional = profissionais.get(index);
            profissional.setNome(nome);
            profissional.setEspecialidade(especialidade);
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void removerProfissional(int index) {
        if (index >= 0 && index < profissionais.size()) {
            profissionais.remove(index);
        } else {
            System.out.println("Índice inválido!");
        }
    }
}
