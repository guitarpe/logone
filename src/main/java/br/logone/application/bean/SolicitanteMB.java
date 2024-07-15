package br.logone.application.bean;

import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@Getter
@Setter
@ManagedBean
@RequestScoped
public class SolicitanteMB {
    private String nome;
}
