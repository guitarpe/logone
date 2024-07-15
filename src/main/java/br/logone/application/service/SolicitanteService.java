package br.logone.application.service;

import br.logone.application.model.Solicitante;
import br.logone.application.repository.ISolicitanteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SolicitanteService {

    @Autowired
    private ISolicitanteRepository repository;

    public List<Solicitante> listarTodos() {
        return repository.findAll();
    }

    public Optional<Solicitante> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Solicitante salvar(Solicitante solicitante) {
        return repository.save(solicitante);
    }

    public void remover(Long id) {
        if(buscarPorId(id).isEmpty())
            throw new IllegalArgumentException("Solicitante não encontrado");

        repository.deleteById(id);
    }
}
