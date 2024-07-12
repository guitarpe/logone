package com.teste.pratico.application.controller;

import com.teste.pratico.application.model.Agendamentos;
import com.teste.pratico.application.model.Solicitantes;
import com.teste.pratico.application.repository.IAgendamentosRepository;
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
@RequestMapping("/agendamentos")
public class AgendamentosController {
    @Autowired
    private IAgendamentosRepository repository;

    @GetMapping("/novo")
    public String novoSolicitante(Model model) {
        model.addAttribute("agendamento", new Agendamentos());
        return "agendamento";
    }

    @PostMapping("/salvar")
    public String salvarAgendamento(@ModelAttribute("agendamento") Agendamentos agendamento,
                                    BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "agendamento";
        }
        repository.save(agendamento);
        return "redirect:/agendamento/novo";
    }
}
