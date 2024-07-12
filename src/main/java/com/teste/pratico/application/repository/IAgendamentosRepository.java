package com.teste.pratico.application.repository;

import com.teste.pratico.application.model.Agendamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAgendamentosRepository extends JpaRepository<Agendamentos, Long> {
}
