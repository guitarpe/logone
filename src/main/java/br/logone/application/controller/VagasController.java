package br.logone.application.controller;

import br.logone.application.bean.VagaMB;
import br.logone.application.model.Vaga;
import br.logone.application.service.VagaService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Getter
@Setter
@Controller
@RequestMapping("/vagas")
public class VagasController {

    @Autowired
    private VagaService service;

    private VagaMB vagaMB = new VagaMB();

    @GetMapping
    public String listar() {
        return "vagas/list";
    }

    public List<Vaga> lista(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Vaga vaga = service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
        model.addAttribute("titulo", "Editar Vaga");
        model.addAttribute("edit", true);
        vagaMB.setInicio(vaga.getInicio());
        vagaMB.setFim(vaga.getFim());
        vagaMB.setQuantidade(vaga.getQuantidade());
        return "vagas/form";
    }

    @PostMapping
    public String salvar() {
        try{
            Vaga vaga = new Vaga();
            vaga.setInicio(vagaMB.getInicio());
            vaga.setFim(vagaMB.getFim());
            vaga.setQuantidade(vagaMB.getQuantidade());

            service.salvar(vaga);

            FacesContext.getCurrentInstance().getExternalContext().redirect("/vagas");
            return null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            return null;
        }
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        vagaMB = new VagaMB();
        model.addAttribute("titulo", "Cadastrar Vaga");
        model.addAttribute("edit", false);
        return "vagas/form";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        try{
            service.remover(id);

            FacesContext.getCurrentInstance().getExternalContext().redirect("/vagas");
            return null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            return null;
        }
    }
}
