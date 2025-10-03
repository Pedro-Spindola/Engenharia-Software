package com.senai.spindola.cs_atividade04.dto;

import java.time.LocalDateTime;

public record VeiculoResponseDTO(
    Long id,
    String placa,
    String modelo,
    String cor,
    LocalDateTime dataEntrada,
    LocalDateTime dataSaida,
    float valorPago
) {}
