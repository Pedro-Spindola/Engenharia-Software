package com.spindola.atividade_06.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.atividade_06.dto.DepartamentoRequestDTO;
import com.spindola.atividade_06.dto.DepartamentoResponseDTO;
import com.spindola.atividade_06.exception.FuncionarioException;
import com.spindola.atividade_06.mapper.DepartamentoMapper;
import com.spindola.atividade_06.model.Departamento;
import com.spindola.atividade_06.repository.DepartamentoRepository;

@Service
public class DepartamentoServices {
    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    DepartamentoMapper departamentoMapper;

    public List<DepartamentoResponseDTO> listarTodos(){
        return departamentoRepository.findAll().stream()
                .map(departamentoMapper::toResponse)
                .toList();
    }

    public List<DepartamentoResponseDTO> listarAtivos() {
        return departamentoRepository.findByAtivoTrue().stream()
                .map(departamentoMapper::toResponse)
                .toList();
    }

    public DepartamentoResponseDTO criarDepartamento(DepartamentoRequestDTO dto){
        Departamento departamento = departamentoMapper.toEntity(dto);
        if (departamento.getNome() == null || departamento.getNome().isEmpty()) {
            throw new FuncionarioException("O nome do departamento não pode estar vazio.");
        }
        if(departamentoRepository.findByNome(dto.nome()).isPresent()){
            throw new FuncionarioException("Já existe um departamento com esse nome.");
        }
        if (departamento.getSigla() == null || departamento.getSigla().isEmpty()) {
            throw new FuncionarioException("O nome do departamento não pode estar vazio.");
        }
        departamento.setAtivo(true);

        return departamentoMapper.toResponse(departamentoRepository.save(departamento));
    }

    public DepartamentoResponseDTO atualizarDepartamento(Long id, DepartamentoRequestDTO dto) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new FuncionarioException("Departamento não encontrado."));

        Optional<Departamento> departamentoNomeExistente = departamentoRepository.findByNome(dto.nome());

        if(departamentoNomeExistente.isPresent() && !departamentoNomeExistente.get().getNome().equals(dto.nome())){
            throw new FuncionarioException("Já existe um departamento com esse nome.");
        }
        
        if (dto.sigla() == null && dto.sigla().isEmpty()) {
            throw new FuncionarioException("A Sigla não pode estar vazio.");    
        }

        if (dto.ativo() == null) {
            throw new FuncionarioException("Status ativo não pode ser null");
        }
        departamento.setNome(dto.nome());
        departamento.setSigla(dto.sigla());
        departamento.setAtivo(dto.ativo());

        Departamento atualizado = departamentoRepository.save(departamento);
        return departamentoMapper.toResponse(atualizado);
    }


    public Boolean inativarDepartamento(Long id){
        return null;
    }
}
