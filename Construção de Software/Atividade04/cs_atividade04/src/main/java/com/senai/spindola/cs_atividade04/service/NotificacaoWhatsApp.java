package com.senai.spindola.cs_atividade04.service;

import org.springframework.stereotype.Service;

import com.senai.spindola.cs_atividade04.model.INotificacao;
import com.senai.spindola.cs_atividade04.model.Veiculo;

@Service
public class NotificacaoWhatsApp implements INotificacao {

    @Override
    public String mensagemEntrada(String msg, Veiculo veiculo) {
        return "[WHATSAPP]" + msg + "Veiculo: " + veiculo.getPlaca() + "\n Horario entrada: " + veiculo.getDataEntrada();
    }

    @Override
    public String mensagemSaida(String msg, Veiculo veiculo) {
        return "[WHATSAPP]" + msg + "Veiculo: " + veiculo.getPlaca() + "\n Valor pago: " + veiculo.getValorPago();
    }
}
