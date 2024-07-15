package br.logone.application.service;

import br.logone.application.dto.SolicitanteAgendamentoDTO;
import br.logone.application.model.Agenda;
import br.logone.application.model.Solicitante;
import br.logone.application.model.Vaga;
import br.logone.application.repository.IAgendaRepository;
import br.logone.application.repository.IVagaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AgendaService {

    @Autowired
    private IAgendaRepository repository;

    @Autowired
    private IVagaRepository vagaRepository;

    public List<Agenda> listarTodos() {
        return repository.findAll();
    }

    public Optional<Agenda> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Agenda salvar(Agenda agenda) {
        if (!temVagasSuficientes(agenda)) {
            throw new IllegalArgumentException("Não há vagas suficientes para o agendamento neste período.");
        }

        verificaVariosCadastros(agenda);

        return repository.save(agenda);
    }

    public void remover(Long id) {
        if(buscarPorId(id).isEmpty())
            throw new IllegalArgumentException("Agendamento não encontrado");

        repository.deleteById(id);
    }

    public List<Solicitante> listaSolicitantes(){
        return repository.getSolicitantes();
    }

    public List<Agenda> buscarPorFiltros(LocalDate dataInicio, LocalDate dataFim, Long solicitante) {
        return repository.findByFilters(dataInicio, dataFim, solicitante);
    }

    public List<SolicitanteAgendamentoDTO> buscarTotais(LocalDate dataInicio, LocalDate dataFim, Long solicitante) {
        return repository.getTotaisPorSolicitante(dataInicio, dataFim, solicitante);
    }

    private boolean temVagasSuficientes(Agenda agenda) {
        List<Vaga> vagas = vagaRepository.findByPeriod(agenda.getData());

        if (vagas.isEmpty()) {
            return false;
        }

        Vaga vaga = vagas.get(0);
        long totalAgendamentos = repository.countAgendamentosByDate(agenda.getData());

        return totalAgendamentos < vaga.getQuantidade();
    }

    private void verificaVariosCadastros(Agenda agenda){

        List<Vaga> vagas = vagaRepository.findByPeriod(agenda.getData());
        if (vagas.isEmpty()) {
            throw new IllegalArgumentException("Não há vagas disponíveis para a data selecionada.");
        }

        int quantidadeVagas = vagas.stream().mapToInt(Vaga::getQuantidade).sum();
        int limiteAgendamentos = (int) (quantidadeVagas * 0.25);

        long agendamentosExistentes = repository.findByFilters(
                agenda.getData(),
                agenda.getData(),
                agenda.getSolicitante().getId()).size();

        if (agendamentosExistentes >= limiteAgendamentos) {
            throw new IllegalStateException("Limite de agendamentos atingido para este solicitante.");
        }
    }
}
