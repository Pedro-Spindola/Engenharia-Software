package com.spindola.atividade_05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spindola.atividade_05.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    
}
