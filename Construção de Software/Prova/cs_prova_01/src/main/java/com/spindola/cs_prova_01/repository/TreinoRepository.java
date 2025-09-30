package com.spindola.cs_prova_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spindola.cs_prova_01.model.Treino;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long>{
    
}
