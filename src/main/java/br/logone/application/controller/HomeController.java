package br.logone.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.faces.view.ViewScoped;

@Controller
@ViewScoped
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Bem-vindo à nossa aplicação!");
        return "home";
    }
}
