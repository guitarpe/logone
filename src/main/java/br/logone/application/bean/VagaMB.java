package br.logone.application.bean;

import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.time.LocalDate;

@Getter
@Setter
@ManagedBean
@RequestScoped
public class VagaMB {
    private LocalDate inicio;
    private LocalDate fim;
    private int quantidade;
}
