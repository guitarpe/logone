package br.logone.application.bean;

import br.logone.application.model.Solicitante;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.time.LocalDate;

@Getter
@Setter
@ManagedBean
@RequestScoped
public class AgendaMB {
    private LocalDate data;
    private String numero;
    private String motivo;
    private Solicitante solicitante;
}
