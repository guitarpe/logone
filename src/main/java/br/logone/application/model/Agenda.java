package br.logone.application.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "agendamento")
public class Agenda {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate data;
    private String numero;
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "solictante_id")
    private Solicitante solicitante;
}
