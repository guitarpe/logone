package br.logone.application.repository;

import br.logone.application.model.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISolicitanteRepository extends JpaRepository<Solicitante, Long> {

}
