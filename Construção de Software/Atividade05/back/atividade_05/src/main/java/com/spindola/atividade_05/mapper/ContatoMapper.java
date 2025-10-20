package com.spindola.atividade_05.mapper;

import org.springframework.stereotype.Component;

import com.spindola.atividade_05.dto.ContatoRequestDTO;
import com.spindola.atividade_05.dto.ContatoResponse;
import com.spindola.atividade_05.model.Contato;

@Component
public class ContatoMapper {
    public Contato toEntity(ContatoRequestDTO dto){
        Contato contato = new Contato();
        contato.setId(dto.id());
        contato.setNome(dto.nome());
        contato.setEmail(dto.email());
        contato.setTelefone(dto.telefone());
        return contato;
    }
    
    public ContatoResponse toResponse(Contato contato){
        ContatoResponse contatoResponse = new ContatoResponse(
            contato.getId(),
            contato.getNome(),
            contato.getEmail(),
            contato.getTelefone()
        );
        return contatoResponse;
    }
}
