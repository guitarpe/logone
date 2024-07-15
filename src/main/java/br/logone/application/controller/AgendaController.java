package br.logone.application.controller;

import br.logone.application.bean.AgendaMB;
import br.logone.application.dto.SolicitanteAgendamentoDTO;
import br.logone.application.model.Agenda;
import br.logone.application.model.Solicitante;
import br.logone.application.service.AgendaService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Controller
@RequestMapping("/agendamentos")
public class AgendaController {

    @Autowired
    private AgendaService service;

    private AgendaMB agendaMB = new AgendaMB();
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long solicitanteBusca;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("busca", new AgendaMB());
        model.addAttribute("lista", service.listarTodos());
        return "agenda/list";
    }

    @GetMapping("/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Agenda agenda = service.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
        model.addAttribute("titulo", "Editar Agendamento");
        agendaMB.setData(agenda.getData());
        agendaMB.setNumero(agenda.getNumero());
        agendaMB.setMotivo(agenda.getMotivo());
        agendaMB.setSolicitante(agenda.getSolicitante());

        return "agenda/form";
    }

    @PostMapping
    public String salvar() {
        try{
            Agenda agenda = new Agenda();
            agenda.setData(agendaMB.getData());
            agenda.setNumero(agendaMB.getNumero());
            agenda.setMotivo(agendaMB.getMotivo());
            agenda.setSolicitante(agendaMB.getSolicitante());

            service.salvar(agenda);

            FacesContext.getCurrentInstance().getExternalContext().redirect("/agendamentos");
            return null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            return null;
        }
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        agendaMB = new AgendaMB();
        model.addAttribute("titulo", "Cadastrar Agendamento");
        return "agenda/form";
    }

    @GetMapping("/consulta-totais")
    public String consultaTotais(Model model) {
        agendaMB = new AgendaMB();
        model.addAttribute("titulo", "Consulta de agendamentos por solicitante");
        return "agenda/consult";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        try{
            service.remover(id);

            FacesContext.getCurrentInstance().getExternalContext().redirect("/agendamentos");
            return null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            return null;
        }
    }

    public List<Solicitante> solicitantes() {
        return service.listaSolicitantes();
    }

    @PostMapping("/buscar")
    public String buscar(Model model) {
        List<Agenda> agendamentos = (dataInicio != null || dataFim != null || solicitanteBusca != null)
            ? service.buscarPorFiltros(dataInicio, dataFim, solicitanteBusca)
            : service.listarTodos();

        model.addAttribute("lista", agendamentos);
        return "agenda/list";
    }

    @PostMapping("/totais")
    public String totais(Model model) {
        List<SolicitanteAgendamentoDTO> agendamentos = (dataInicio != null || dataFim != null || solicitanteBusca != null)
                ? service.buscarTotais(dataInicio, dataFim, solicitanteBusca)
                : List.of();

        model.addAttribute("lista", agendamentos);
        return "agenda/consult";
    }
}
