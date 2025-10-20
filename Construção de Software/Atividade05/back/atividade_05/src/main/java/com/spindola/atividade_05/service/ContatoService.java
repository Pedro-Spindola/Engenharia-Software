package com.spindola.atividade_05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.atividade_05.dto.ContatoRequestDTO;
import com.spindola.atividade_05.dto.ContatoResponse;
import com.spindola.atividade_05.mapper.ContatoMapper;
import com.spindola.atividade_05.model.Contato;
import com.spindola.atividade_05.repository.ContatoRepository;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ContatoMapper contatoMapper;

    public List<ContatoResponse> findAll() {
        return contatoRepository.findAll().stream()
        .map(contatoMapper::toResponse)
        .toList();
    }

    public ContatoResponse findById(Long id) {
        Contato contato = contatoRepository.findById(id).get();
        return contatoMapper.toResponse(contato);
    }

    public ContatoResponse save(ContatoRequestDTO contato) {
        Contato novoContato = contatoMapper.toEntity(contato);
        novoContato.setId(null);
        contatoRepository.save(novoContato);
        return contatoMapper.toResponse(novoContato);
    }

    public ContatoResponse update(Long id, ContatoRequestDTO contatoDetalhes) {
        Contato contato = contatoRepository.findById(id).get();
        contato = contatoMapper.toEntity(contatoDetalhes);
        contatoRepository.save(contato);

        return contatoMapper.toResponse(contato);
    }

    public boolean delete(Long id) {
        Contato contato = contatoRepository.findById(id).get();
        contatoRepository.delete(contato);
        return true;
    }
}
