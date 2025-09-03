package com.turismo.capytur.web.controle;

import com.turismo.capytur.web.modelo.Cliente;
import com.turismo.capytur.web.repo.ClienteRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    private final ClienteRepo clienteRepo;

    public LoginController(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; //login.html
    }

    @PostMapping("/login")
    public String processarLogin(@RequestParam String username,
                                 @RequestParam String senha,
                                 Model model){
        Cliente cliente = clienteRepo.findByUsernameandSenha(username, senha);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return cliente.isAdmin() ? "menuAdmin" : "menuUsuario";

        } else {
            model.addAttribute("erro", "Usuario ou senha incorretos!");
            return "login";

    }
}