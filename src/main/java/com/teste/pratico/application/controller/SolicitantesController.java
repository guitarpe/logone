package com.teste.pratico.application.controller;

import com.teste.pratico.application.model.Solicitantes;
import com.teste.pratico.application.repository.ISolicitantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/solicitantes")
public class SolicitantesController {
    @Autowired
    private ISolicitantesRepository repository;

    @GetMapping("/novo")
    public String novoSolicitante(Model model) {
        model.addAttribute("solicitante", new Solicitantes());
        return "solicitante";
    }

    @PostMapping("/salvar")
    public String salvarSolicitante(@ModelAttribute("solicitante") Solicitantes solicitante,
                                    BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "solicitante";
        }
        repository.save(solicitante);
        return "redirect:/solicitantes/novo";
    }
}
