package com.spindola.atividade_06.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spindola.atividade_06.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    List<Departamento> findByAtivoTrue();
    Optional<Departamento> findByNome(String nome);
}
