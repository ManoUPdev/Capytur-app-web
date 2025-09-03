package com.turismo.capytur.web.controle;

import com.turismo.capytur.web.modelo.Viagem;
import com.turismo.capytur.web.repo.ViagemRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/viagens")
public class ViagemController {

    private final ViagemRepo viagemRepo;

    public ViagemController(ViagemRepo viagemRepo) {
        this.viagemRepo = viagemRepo;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("viagens", viagemRepo.findAll());
        return "viagens";
    }
    @GetMapping("/nova")
    public String formNova(Model model) {
        model.addAttribute("viagem", new Viagem());
        return "formViagem";
    }

    @PostMapping
    public String salvar(@ModelAttribute Viagem viagem) {
        viagemRepo.save(viagem);
        return "redirect:/viagens";
    }
}
