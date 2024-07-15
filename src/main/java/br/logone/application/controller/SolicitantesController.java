package br.logone.application.controller;

import br.logone.application.bean.SolicitanteMB;
import br.logone.application.model.Solicitante;
import br.logone.application.service.SolicitanteService;
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
@RequestMapping("/solicitantes")
public class SolicitantesController {

    @Autowired
    private SolicitanteService service;

    private SolicitanteMB solicitanteMB = new SolicitanteMB();

    @GetMapping
    public String listar() {
        return "solicitantes/list";
    }

    @GetMapping("/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Solicitante solicitante = service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
        solicitanteMB.setNome(solicitante.getNome());
        model.addAttribute("titulo", "Editar Solicitante");
        return "solicitantes/form";
    }

    @PostMapping
    public String salvar() {
        try{
            Solicitante solicitante = new Solicitante();
            solicitante.setNome(solicitanteMB.getNome());

            service.salvar(solicitante);

            FacesContext.getCurrentInstance().getExternalContext().redirect("/solicitantes");
            return null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            return null;
        }
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        solicitanteMB = new SolicitanteMB();
        model.addAttribute("titulo", "Cadastrar Solicitante");
        return "solicitantes/form";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        try{
            service.remover(id);

            FacesContext.getCurrentInstance().getExternalContext().redirect("/solicitantes");
            return null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            return null;
        }
    }

    public List<Solicitante> lista(){
        return service.listarTodos();
    }
}
