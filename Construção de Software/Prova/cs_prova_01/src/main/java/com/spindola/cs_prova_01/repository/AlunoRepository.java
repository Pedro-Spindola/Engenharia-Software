package com.spindola.cs_prova_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spindola.cs_prova_01.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}
