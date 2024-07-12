package com.teste.pratico.application.repository;

import com.teste.pratico.application.model.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVagasRepository extends JpaRepository<Vagas, Long> {
}
