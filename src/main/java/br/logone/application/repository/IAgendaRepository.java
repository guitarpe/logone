package br.logone.application.repository;

import br.logone.application.dto.SolicitanteAgendamentoDTO;
import br.logone.application.model.Agenda;
import br.logone.application.model.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface IAgendaRepository extends JpaRepository<Agenda, Long> {
    @Query("select s from Solicitante as s")
    List<Solicitante> getSolicitantes();

    @Query("SELECT a FROM Agenda a WHERE (:dataInicio IS NULL OR a.data >= :dataInicio) " +
            "AND (:dataFim IS NULL OR a.data <= :dataFim) " +
            "AND (:solicitante IS NULL OR a.solicitante.id = :solicitante)")
    List<Agenda> findByFilters(@Param("dataInicio") LocalDate dataInicio,
                               @Param("dataFim") LocalDate dataFim,
                               @Param("solicitante") Long solicitante);

    @Query("SELECT s.nome, COUNT(a), SUM(v.quantidade), ((COUNT(a) / SUM(v.quantidade)) * 100) " +
            " FROM Agenda a " +
            " JOIN a.solicitante s " +
            " JOIN Vaga v " +
            " WHERE (:dataInicio IS NULL OR a.data >= :dataInicio) " +
            " AND (:dataFim IS NULL OR a.data <= :dataFim) " +
            " AND (:solicitante IS NULL OR a.solicitante.id = :solicitante)" +
            " GROUP BY s.nome")
    List<SolicitanteAgendamentoDTO> getTotaisPorSolicitante(@Param("dataInicio") LocalDate dataInicio,
                                                            @Param("dataFim") LocalDate dataFim,
                                                            @Param("solicitante") Long solicitante);

    @Query("SELECT COUNT(a) FROM Agenda a WHERE a.data = :date")
    long countAgendamentosByDate(@Param("date") LocalDate date);
}
