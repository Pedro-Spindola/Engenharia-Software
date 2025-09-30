package com.spindola.cs_prova_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spindola.cs_prova_01.model.Plano;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long>{
    
}
