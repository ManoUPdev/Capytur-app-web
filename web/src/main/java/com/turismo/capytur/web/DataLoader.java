package com.turismo.capytur.web;

import com.turismo.capytur.web.modelo.Cliente;
import com.turismo.capytur.web.repo.ClienteRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {
    private final ClienteRepo clienteRepo;

    public DataLoader(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Override
        public void run(String... args) {
        clienteRepo.save(new Cliente("Administrador", "admin", "1234", true));
        clienteRepo.save(new Cliente("Joao da Silva", "joao", "1234", false));
    }
}
