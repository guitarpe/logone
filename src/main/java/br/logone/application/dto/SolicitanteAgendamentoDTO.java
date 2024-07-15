package br.logone.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SolicitanteAgendamentoDTO {
    private String nome;
    private Long total;
    private Long quantidade;
    private Double percentual;
}
