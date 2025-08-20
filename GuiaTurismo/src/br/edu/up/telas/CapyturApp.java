package br.edu.up.telas;

import br.edu.up.controle.ControleClientes;
import br.edu.up.controle.ControleDeServicos;
import br.edu.up.controle.ControleDeViagem;
import br.edu.up.modelo.Avaliacao;
import br.edu.up.modelo.Cliente;
import br.edu.up.modelo.Servico;
import br.edu.up.modelo.Viagem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CapyturApp {

    ControleDeServicos controleDeServicos = new ControleDeServicos();
    ControleDeViagem controleDeViagem = new ControleDeViagem();
    ControleClientes controleClientes = new ControleClientes();
    private Scanner scanner = new Scanner(System.in);
    private Cliente clienteLogado;

    public void iniciar() {
        int opcao;

        System.out.println("=================================");
        System.out.println(" Bem-vindo ao Capytur! ");
        System.out.println("=================================");

        do {
            System.out.println(" ");
            System.out.println("Escolha a opção desejada: ");
            System.out.println("1 - Login");
            System.out.println("2 - Registrar");
            System.out.println("3 - Sair");
            System.out.println("=================================");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    login();
                    break;
                case 2:
                    registrar();
                    break;
                case 3:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 3);

        // Salvar todos os dados antes de sair
        salvarDados(null, null, null, null);
    }
    private void login() {
        System.out.println("=================================");
        System.out.println(" Login ");
        System.out.println("=================================");
        System.out.println("Digite seu username: ");
        String username = scanner.next();
    
        System.out.println("Digite sua senha: ");
        String senha = scanner.next();
    
        boolean sucesso = controleClientes.login(username, senha);
        if (sucesso) {
            clienteLogado = controleClientes.getCliente(username); // Definindo o cliente logado
            boolean isAdmin = controleClientes.isAdmin(username);
            System.out.println("Login realizado com sucesso!");
            mostrarMenuInicial(isAdmin);
        } else {
            System.out.println("Username ou senha incorretos.");
        }
    }

    private void registrar() {
        System.out.println("=================================");
        System.out.println(" Registrar ");
        System.out.println("=================================");
        System.out.println("Digite seu nome: ");
        String nome = scanner.next();

        System.out.println("Digite seu username: ");
        String username = scanner.next();

        System.out.println("Digite sua senha: ");
        String senha = scanner.next();

        System.out.println("Você deseja registrar como administrador? (S/N): ");
        boolean isAdmin = scanner.next().equalsIgnoreCase("S");

        controleClientes.registrar(nome, username, senha, isAdmin);
        System.out.println("Registro realizado com sucesso!");
    }

    private void mostrarMenuInicial(boolean isAdmin) {
        if (isAdmin) {
            mostrarMenuAdmin();
        } else {
            mostrarMenuUsuario();
        }
    }
    private void mostrarMenuAdmin() {
        int opcao;
    
        do {
            System.out.println(" ");
            System.out.println("=================================");
            System.out.println(" Menu Inicial - Capytur (Admin) ");
            System.out.println("=================================");
            System.out.println("Escolha a opção desejada: ");
            System.out.println("1 - Controle de Viagens");
            System.out.println("2 - Procurar Viagens");
            System.out.println("3 - Serviços");
            System.out.println("4 - Gerenciar Clientes");
            System.out.println("5 - Gerenciar Profissionais");
            System.out.println("6 - Gravar clientes e sair");
            System.out.println("=================================");
    
            opcao = scanner.nextInt();
    
            switch (opcao) {
                case 1:
                    controleDeViagens();
                    break;
                case 2:
                    procurarViagens();
                    break;
                case 3:
                    mostrarServicos();
                    break;
                case 4:
                    gerenciarClientes();
                    break;
                case 5:
                    gerenciarProfissionais();
                    break;
                case 6:
                    // Popule as listas de clientes e profissionais antes de chamar o método salvarDados
                    List<String> usernamesClientes = controleClientes.listarClientes();
                    List<Viagem> viagens = controleDeViagem.listarViagens();
                    List<String> nomesProfissionais = controleDeServicos.listarProfissionais();
                    salvarDados("dados.txt", usernamesClientes, viagens, nomesProfissionais);
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 6);
    }
    
    
    private void mostrarMenuUsuario() {
        int opcao;

        do {
            System.out.println(" ");
            System.out.println("=================================");
            System.out.println(" Menu Inicial - Capytur ");
            System.out.println("=================================");
            System.out.println("Escolha a opção desejada: ");
            System.out.println("1 - Controle de Viagens");
            System.out.println("2 - Procurar Viagens");
            System.out.println("3 - Serviços");
            System.out.println("4 - Sair");
            System.out.println("=================================");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    controleDeViagens();
                    break;
                case 2:
                    procurarViagens();
                    break;
                case 3:
                    mostrarServicos();
                    break;
                case 4:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 4);
    }

    private void controleDeViagens() {
        int opcao;

        do {
            System.out.println(" ");
            System.out.println("=================================");
            System.out.println(" Controle de Viagens ");
            System.out.println("=================================");
            System.out.println("Escolha a opção desejada: ");
            System.out.println("1 - Adicionar Viagem");
            System.out.println("2 - Adicionar Avaliação");
            System.out.println("3 - Voltar ao Menu Inicial");
            System.out.println("=================================");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarViagem();
                    break;
                case 2:
                    adicionarAvaliacao();
                    break;
                case 3:
                    System.out.println("Voltando ao Menu Inicial...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 3);
    }
    private void adicionarViagem() {
        scanner.nextLine();  // Consumir a quebra de linha
        System.out.println("=================================");
        System.out.println(" Adicionar Viagem ");
        System.out.println("=================================");
    
        System.out.println("Digite o destino da viagem: ");
        String destino = scanner.nextLine();
    
        System.out.println("Digite a descrição da viagem: ");
        String descricao = scanner.nextLine();
    
        System.out.println("Digite a data da viagem: ");
        String data = scanner.nextLine();
    
        System.out.println("Digite o local da viagem: ");
        String local = scanner.nextLine();
    
        Viagem viagem = new Viagem(destino, descricao, data, local);
        controleDeViagem.adicionarViagem(viagem, clienteLogado);// Passa o cliente que está adicionando a viagem
        System.out.println("Viagem adicionada com sucesso!");
    }
    

   private void adicionarAvaliacao() {
    scanner.nextLine();  // Consumir a quebra de linha
    System.out.println("=================================");
    System.out.println(" Adicionar Avaliação ");
    System.out.println("=================================");

    List<Viagem> viagens = controleDeViagem.listarViagens();
    if (viagens.isEmpty()) {
        System.out.println("Nenhuma viagem disponível para avaliação.");
        return;
    }

    System.out.println("Selecione a viagem para avaliar:");
    for (int i = 0; i < viagens.size(); i++) {
        System.out.println((i + 1) + " - " + viagens.get(i).toString());
    }

    int escolha;
    do {
        System.out.println("Digite o número da viagem: ");
        escolha = scanner.nextInt();
    } while (escolha < 1 || escolha > viagens.size());

    scanner.nextLine();  // Consumir a quebra de linha

    Viagem viagemSelecionada = viagens.get(escolha - 1);

    System.out.println("Digite o título da avaliação: ");
    String titulo = scanner.nextLine();

    System.out.println("Digite a nota da avaliação (0 a 5): ");
    int nota = scanner.nextInt();
    scanner.nextLine();  // Consumir a quebra de linha

    Avaliacao avaliacao = new Avaliacao(nota, viagemSelecionada, titulo);
    controleDeViagem.adicionarAvaliacao(viagemSelecionada, avaliacao);
    System.out.println("Avaliação adicionada com sucesso!");
}


    private void procurarViagens() {
        scanner.nextLine();  // Consumir a quebra de linha
        System.out.println("=================================");
        System.out.println(" Procurar Viagens ");
        System.out.println("=================================");

        System.out.println("Digite o destino da viagem: ");
        String destino = scanner.nextLine();

        List<Viagem> viagensEncontradas = controleDeViagem.procurarViagens(destino);
        if (viagensEncontradas.isEmpty()) {
            System.out.println("Nenhuma viagem encontrada.");
        } else {
            System.out.println("Viagens encontradas: ");
            for (Viagem viagem : viagensEncontradas) {
                System.out.println(viagem);
            }
        }
    }

    private void mostrarServicos() {
        int opcao;

        do {
            System.out.println(" ");
            System.out.println("=================================");
            System.out.println(" Serviços ");
            System.out.println("=================================");
            System.out.println("Escolha a opção desejada: ");
            System.out.println("1 - Contratar Guia de Turismo");
            System.out.println("2 - Contratar Professor");
            System.out.println("3 - Contratar Fotógrafo");
            System.out.println("4 - Voltar ao Menu Inicial");
            System.out.println("=================================");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    contratarGuiaDeTurismo();
                    break;
                case 2:
                    contratarProfessor();
                    break;
                case 3:
                    contratarFotografo();
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Inicial...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 4);
    }

    private void contratarGuiaDeTurismo() {
        System.out.println("=================================");
        System.out.println(" Contratar Guia de Turismo ");
        System.out.println("=================================");
        System.out.println("Digite o nome do guia: ");
        String nome = scanner.next();
    
        System.out.println("Digite a especialidade do guia: ");
        String especialidade = scanner.next();
    
        controleDeServicos.contratarProfissional("Guia de Turismo", nome, especialidade);
        System.out.println("Guia de Turismo contratado com sucesso!");
    }
    
    private void contratarProfessor() {
        System.out.println("=================================");
        System.out.println(" Contratar Professor ");
        System.out.println("=================================");
        System.out.println("Digite o nome do professor: ");
        String nome = scanner.next();
    
        System.out.println("Digite a especialidade do professor: ");
        String especialidade = scanner.next();
    
        controleDeServicos.contratarProfissional("Professor", nome, especialidade);
        System.out.println("Professor contratado com sucesso!");
    }
    
    private void contratarFotografo() {
        System.out.println("=================================");
        System.out.println(" Contratar Fotógrafo ");
        System.out.println("=================================");
        System.out.println("Digite o nome do fotógrafo: ");
        String nome = scanner.next();
    
        System.out.println("Digite a especialidade do fotógrafo: ");
        String especialidade = scanner.next();
    
        controleDeServicos.contratarProfissional("Fotógrafo", nome, especialidade);
        System.out.println("Fotógrafo contratado com sucesso!");
    }
    

    private void gerenciarClientes() {
        int opcao;

        do {
            System.out.println(" ");
            System.out.println("=================================");
            System.out.println(" Gerenciar Usuários ");
            System.out.println("=================================");
            System.out.println("Escolha a opção desejada: ");
            System.out.println("1 - Adicionar Usuário");
            System.out.println("2 - Remover Usuário");
            System.out.println("3 - Listar Usuários");
            System.out.println("4 - Voltar ao Menu Inicial");
            System.out.println("=================================");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarUsuario();
                    break;
                case 2:
                    removerUsuario();
                    break;
                case 3:
                    listarUsuarios();
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Inicial...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 4);
    }

    private void adicionarUsuario() {
        System.out.println("=================================");
        System.out.println(" Adicionar Usuário ");
        System.out.println("=================================");
        System.out.println("Digite o nome do usuário: ");
        String nome = scanner.next();

        System.out.println("Digite o username do usuário: ");
        String username = scanner.next();

        System.out.println("Digite a senha do usuário: ");
        String senha = scanner.next();

        System.out.println("O usuário é um administrador? (S/N): ");
        boolean isAdmin = scanner.next().equalsIgnoreCase("S");

        controleClientes.registrar(nome, username, senha, isAdmin);
        System.out.println("Usuário adicionado com sucesso!");
    }

    private void removerUsuario() {
        System.out.println("=================================");
        System.out.println(" Remover Usuário ");
        System.out.println("=================================");
        System.out.println("Digite o username do usuário a ser removido: ");
        String username = scanner.next();

        controleClientes.removerCliente(username);
        System.out.println("Usuário removido com sucesso!");
    }

    private void listarUsuarios() {
        System.out.println("=================================");
        System.out.println(" Listar Usuários ");
        System.out.println("=================================");
        System.out.println("Usuários registrados: ");
        for (String username : controleClientes.listarClientes()) {
            System.out.println(username);
        }
    }

    private void gerenciarProfissionais() {
        int opcao;

        do {
            System.out.println(" ");
            System.out.println("=================================");
            System.out.println(" Gerenciar Profissionais ");
            System.out.println("=================================");
            System.out.println("Escolha a opção desejada: ");
            System.out.println("1 - Adicionar Profissional");
            System.out.println("2 - Editar Profissional");
            System.out.println("3 - Remover Profissional");
            System.out.println("4 - Listar Profissionais");
            System.out.println("5 - Voltar ao Menu Inicial");
            System.out.println("=================================");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                contratarProfissional("Guia de Turismo");
                    break;
                case 2:
                    editarProfissional();
                    break;
                case 3:
                    removerProfissional();
                    break;
                case 4:
                    listarProfissionais();
                    break;
                case 5:
                    System.out.println("Voltando ao Menu Inicial...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);
    }

    private void listarProfissionais() {
        System.out.println("=================================");
        System.out.println(" Lista de Profissionais ");
        System.out.println("=================================");
        System.out.println("Profissionais registrados: ");
        List<String> profissionais = controleDeServicos.listarProfissionais();
        if (profissionais.isEmpty()) {
            System.out.println("Nenhum profissional registrado.");
        } else {
            for (String profissional : profissionais) {
                System.out.println(profissional);
            }
        }
    }

    private void contratarProfissional(String tipo) {
        System.out.println("=================================");
        System.out.println(" Adicionar " + tipo);
        System.out.println("=================================");
    
        System.out.println("Digite o nome do " + tipo + ": ");
        String nome = scanner.next();
    
        System.out.println("Digite a especialidade do " + tipo + ": ");
        String especialidade = scanner.next();
    
        controleDeServicos.contratarProfissional(tipo, nome, especialidade);
        System.out.println(tipo + " adicionado com sucesso!");
    }
    
    private void editarProfissional() {
        System.out.println("=================================");
        System.out.println(" Editar Profissional ");
        System.out.println("=================================");
        System.out.println("Digite o índice do profissional a ser editado: ");
        int index = scanner.nextInt();

        System.out.println("Digite o novo nome do profissional: ");
        String nome = scanner.next();

        System.out.println("Digite a nova especialidade do profissional: ");
        String especialidade = scanner.next();

        controleDeServicos.editarProfissional(index, nome, especialidade);
        System.out.println("Profissional editado com sucesso!");
    }

    private void removerProfissional() {
        System.out.println("=================================");
        System.out.println(" Remover Profissional ");
        System.out.println("=================================");
        System.out.println("Digite o índice do profissional a ser removido: ");
        int index = scanner.nextInt();

        controleDeServicos.removerProfissional(index);
        System.out.println("Profissional removido com sucesso!");
    }
    public void salvarDados(String nomeArquivo, List<String> usernamesClientes, List<Viagem> viagens, List<String> nomesProfissionais) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            // Escreve os clientes
            if (usernamesClientes != null) {
                for (String username : usernamesClientes) {
                    Cliente cliente = controleClientes.getCliente(username);
                    boolean isAdmin = controleClientes.isAdmin(username);
                    writer.write("Cliente: " + cliente.getNome() + ", Username: " + cliente.getUsername() + ", Admin: " + isAdmin);
                    writer.newLine();
    
                    // Escreve as viagens associadas ao cliente
                    List<Viagem> viagensCliente = controleDeViagem.listarViagensCliente(cliente);
                    for (Viagem viagem : viagensCliente) {
                        writer.write("Viagem: Destino: " + viagem.getDestino() + ", Data: " + viagem.getData() + ", Local: " + viagem.getLocal());
                        writer.newLine();
                        // Escreve os serviços associados à viagem
                        List<Servico> servicos = viagem.getServicos();
                        if (!servicos.isEmpty()) {
                            writer.write("Serviços: ");
                            for (Servico servico : servicos) {
                                writer.write(servico.getNome() + ", ");
                            }
                            writer.newLine();
                        }
                    }
                }
            }
    
            // Escreve os profissionais
            if (nomesProfissionais != null) {
                for (String nomeProfissional : nomesProfissionais) {
                    writer.write("Profissional: " + nomeProfissional);
                    writer.newLine();
                }
            }
    
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados no arquivo: " + e.getMessage());
        }
    }
    
    
    
}

