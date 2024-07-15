package br.logone.application.service;

import br.logone.application.model.Vaga;
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
public class VagaService {

    @Autowired
    private IVagaRepository repository;

    public List<Vaga> listarTodos() {
        return repository.findAll();
    }

    public Optional<Vaga> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Vaga salvar(Vaga vaga) {
        validarDatas(vaga);
        return repository.save(vaga);
    }

    public void remover(Long id) {
        if(buscarPorId(id).isEmpty())
            throw new IllegalArgumentException("Vaga não encontrada.");

        repository.deleteById(id);
    }

    private void validarDatas(Vaga vaga) {
        LocalDate hoje = LocalDate.now();

        System.out.println(hoje);
        System.out.println(vaga.getInicio());
        System.out.println(vaga.getFim());

        if (vaga.getInicio().isBefore(hoje)) {
            throw new IllegalArgumentException("A data de início não pode ser menor que a data de hoje.");
        }
        if (vaga.getFim().isBefore(vaga.getInicio())) {
            throw new IllegalArgumentException("A data de fim não pode ser menor que a data de início.");
        }
    }
}
