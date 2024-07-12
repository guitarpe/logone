package com.teste.pratico.application.repository;

import com.teste.pratico.application.model.Solicitantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISolicitantesRepository extends JpaRepository<Solicitantes, Long> {
}
