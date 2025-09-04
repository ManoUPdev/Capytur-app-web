package com.turismo.capytur.web.controle;

import com.turismo.capytur.web.modelo.Servico;
import com.turismo.capytur.web.repo.ServicoRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicos")
public class ServicoController {
    private final ServicoRepo servicoRepo;

    public ServicoController(ServicoRepo servicoRepo) {
        this.servicoRepo = servicoRepo;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("servicos", servicoRepo.findAll());
        return "servicos";
    }
    @GetMapping("/novo")
    public String formNovo("servico", new Servico());
        return "formServico";
}
    @PostMapping
    public String salvar(@ModelAttribute Servico servico) {
        servicoRepo.save(servico);
        return "redirect:/servicos";
}
