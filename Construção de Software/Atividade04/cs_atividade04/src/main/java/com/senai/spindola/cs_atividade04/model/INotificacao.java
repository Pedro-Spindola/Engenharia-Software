package com.senai.spindola.cs_atividade04.model;

import org.springframework.stereotype.Service;

@Service
public interface INotificacao {
    String mensagemEntrada(String msg, Veiculo veiculo);
    String mensagemSaida(String msg, Veiculo veiculo);
}
