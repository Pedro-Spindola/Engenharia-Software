package com.senai.spindola.cs_atividade04.service;

import org.springframework.stereotype.Service;

import com.senai.spindola.cs_atividade04.model.INotificacao;
import com.senai.spindola.cs_atividade04.model.Veiculo;

@Service
public class NotificacaoEmail implements INotificacao {

    @Override
    public String mensagemEntrada(String msg, Veiculo veiculo) {
        return "[EMAIL]" + msg + "Veiculo: " + veiculo.getPlaca() + "\n Horario entrada: " + veiculo.getDataEntrada();
    }

    @Override
    public String mensagemSaida(String msg, Veiculo veiculo) {
        return "[EMAIL]" + msg + "Veiculo: " + veiculo.getPlaca() + "\n Valor pago: " + veiculo.getValorPago();
    }
}
