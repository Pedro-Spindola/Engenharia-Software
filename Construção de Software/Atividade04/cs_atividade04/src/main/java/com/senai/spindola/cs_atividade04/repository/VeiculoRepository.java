package com.senai.spindola.cs_atividade04.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.spindola.cs_atividade04.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Optional<Veiculo> findByPlaca(String placa);
    List<Veiculo> findByAtivo();
    List<Veiculo> findByDataFaturamento(LocalDateTime inicio, LocalDateTime fim);
}