package com.teste.pratico.application.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Agendamentos {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date data;
    private String numero;
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "solictante_id")
    private Solicitantes solictante;
}
