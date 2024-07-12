package com.teste.pratico.application.controller;

import com.teste.pratico.application.model.Vagas;
import com.teste.pratico.application.repository.IVagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vagas")
public class VagasController {
    @Autowired
    private IVagasRepository repository;

    @GetMapping("/novo")
    public String novoSolicitante(Model model) {
        model.addAttribute("vaga", new Vagas());
        return "vaga";
    }

    @PostMapping("/salvar")
    public String salvarVagas(@ModelAttribute("vaga") Vagas vaga,
                                    BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "vaga";
        }
        repository.save(vaga);
        return "redirect:/vaga/novo";
    }
}
