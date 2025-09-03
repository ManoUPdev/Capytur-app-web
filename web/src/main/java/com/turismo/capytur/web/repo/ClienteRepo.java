package com.turismo.capytur.web.repo;

import com.turismo.capytur.web.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente, Long> {
    Cliente findByUsernameandSenha(String username, String senha);
}