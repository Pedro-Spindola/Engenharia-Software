package com.spindola.cs_prova_01.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cs_prova_01.dto.AlunoRequestAlterarDTO;
import com.spindola.cs_prova_01.dto.AlunoRequestRegistroDTO;
import com.spindola.cs_prova_01.dto.AlunoResponseDTO;
import com.spindola.cs_prova_01.dto.AlunoResponseListDTO;
import com.spindola.cs_prova_01.dto.PlanoResponseDTO;
import com.spindola.cs_prova_01.dto.TreinoResponseDTO;
import com.spindola.cs_prova_01.mapper.AlunoMapper;
import com.spindola.cs_prova_01.mapper.PlanoMapper;
import com.spindola.cs_prova_01.mapper.TreinoMapper;
import com.spindola.cs_prova_01.model.Aluno;
import com.spindola.cs_prova_01.model.AlunoTreinoVinculo;
import com.spindola.cs_prova_01.model.Plano;
import com.spindola.cs_prova_01.model.Treino;
import com.spindola.cs_prova_01.model.enums.StatusAluno;
import com.spindola.cs_prova_01.repository.AlunoRepository;
import com.spindola.cs_prova_01.repository.PlanoRepository;
import com.spindola.cs_prova_01.repository.TreinoRepository;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    PlanoRepository planoRepository;
    @Autowired
    TreinoRepository treinoRepository;
    @Autowired
    AlunoMapper alunoMapper;
    @Autowired
    PlanoMapper planoMapper;
    @Autowired
    TreinoMapper treinoMapper;

    public AlunoResponseDTO buscarPorId(Long id){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Aluno com ID " + id + " não encontrado."));
        
        PlanoResponseDTO planoDTO = null;
        if (aluno.getPlano() != null) {
            planoDTO = planoMapper.toResponseDTO(aluno.getPlano());
        }

        List<TreinoResponseDTO> treinosDTO = aluno.getTreinos().stream()
            .map(vinculo -> treinoMapper.toResponseDTO(vinculo.getTreino()))
            .collect(Collectors.toList());

        return alunoMapper.toResponseDTO(aluno, planoDTO, treinosDTO);
    }

    public List<AlunoResponseListDTO> buscarTodos(){
        return alunoRepository.findAll().stream()
                .map(alunoMapper::toResponseListDTO)
                .toList();
    }

    public AlunoResponseDTO registrarAluno(AlunoRequestRegistroDTO alunoRequestDTO){
        validarCamposObrigatorios(alunoRequestDTO.nome(), alunoRequestDTO.cpf(), alunoRequestDTO.data_nascimento());

        if (alunoRepository.findByCpf(alunoRequestDTO.cpf()).isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado no sistema.");
        }

        Aluno aluno = alunoMapper.toEntity(alunoRequestDTO);
        aluno.setId(null);
        aluno.setData_ingressao(LocalDate.now());
        aluno.setStatus(StatusAluno.INATIVO);
        alunoRepository.save(aluno);

        PlanoResponseDTO planoDTO = null;
        List<TreinoResponseDTO> treinosDTO = null;

        return alunoMapper.toResponseDTO(aluno, planoDTO, treinosDTO);
    }

    public AlunoResponseDTO alterarAluno(AlunoRequestAlterarDTO alunoRequestDTO){
        if (alunoRequestDTO.id() == null) {
            throw new IllegalArgumentException("O ID do aluno é obrigatório para alteração.");
        }
        
        Aluno alunoExistente = alunoRepository.findById(alunoRequestDTO.id())
            .orElseThrow(() -> new NoSuchElementException("Aluno com ID " + alunoRequestDTO.id() + " não encontrado para alteração."));

        validarCamposObrigatorios(alunoRequestDTO.nome(), alunoRequestDTO.cpf(), alunoRequestDTO.data_nascimento());


        Optional<Aluno> alunoCpfExistente = alunoRepository.findByCpf(alunoRequestDTO.cpf());
        if (alunoCpfExistente.isPresent() && !alunoCpfExistente.get().getId().equals(alunoRequestDTO.id())) {
            throw new IllegalArgumentException("CPF já cadastrado em outro aluno.");
        }
        
        Plano plano = null;
        if (alunoRequestDTO.plano_id() != null) {
            plano = planoRepository.findById(alunoRequestDTO.plano_id())
                .orElseThrow(() -> new NoSuchElementException("Plano com ID " + alunoRequestDTO.plano_id() + " não encontrado."));
        }
        
        Aluno alunoAtualizado = alunoMapper.toEntity(alunoRequestDTO, plano);
        alunoAtualizado.setData_ingressao(alunoExistente.getData_ingressao());
        
        List<AlunoTreinoVinculo> vinculos = new ArrayList<>();  

        if (alunoRequestDTO.treinos() != null && !alunoRequestDTO.treinos().isEmpty()){
            for (Long id_treino : alunoRequestDTO.treinos()) {
                
                Treino treino = treinoRepository.findById(id_treino)
                    .orElseThrow(() -> new NoSuchElementException("Treino com ID " + id_treino + " não encontrado."));
                
                AlunoTreinoVinculo vinculo = new AlunoTreinoVinculo();
                vinculo.setAluno(alunoAtualizado);
                vinculo.setTreino(treino);
                vinculo.setDataAssociacao(LocalDate.now());
                vinculos.add(vinculo);
            }
        }
        
        alunoAtualizado.setTreinos(vinculos);

        alunoRepository.save(alunoAtualizado);

        PlanoResponseDTO planoDTO = null;
        if (alunoAtualizado.getPlano() != null) {
            planoDTO = planoMapper.toResponseDTO(alunoAtualizado.getPlano());
        }
        
        List<TreinoResponseDTO> treinosDTO = alunoAtualizado.getTreinos().stream()
            .map(vinculo -> treinoMapper.toResponseDTO(vinculo.getTreino()))
            .collect(Collectors.toList());

        return alunoMapper.toResponseDTO(alunoAtualizado, planoDTO, treinosDTO);
    }

    public Boolean desativarAluno(Long id, StatusAluno novoStatus){
        if (id == null) {
            throw new IllegalArgumentException("O ID do aluno é obrigatório para desativação.");
        }
        
        if (novoStatus == null) {
            throw new IllegalArgumentException("O novo status do aluno é obrigatório.");
        }
        
        Aluno aluno = alunoRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Aluno com ID " + id + " não encontrado."));
            
        if (novoStatus == StatusAluno.ATIVO) {
            throw new IllegalArgumentException("Use o fluxo de reativação para mudar o status para ATIVO.");
        }
        
        aluno.setStatus(novoStatus);
        alunoRepository.save(aluno);
        return true;
    }

    /*
    public Boolean validarEntrada(Long id){
        Aluno aluno = alunoRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Aluno com ID " + id + " não encontrado."));
            
        if(aluno.getStatus() !=StatusAluno.ATIVO){
            throw new IllegalArgumentException("Aluno inativo ou com inadimplências. Status atual: " + aluno.getStatus());
        }
        // Futura implementação: checar pagamentos/inadimplência.
        return true;
    }*/

    private boolean validarCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            return false;
        }

        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        try {
            int soma = 0, peso = 10;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }
            int digito1 = 11 - (soma % 11);
            if (digito1 > 9) digito1 = 0;
            if (digito1 != (cpf.charAt(9) - '0')) return false;

            soma = 0; peso = 11;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }
            int digito2 = 11 - (soma % 11);
            if (digito2 > 9) digito2 = 0;
            return digito2 == (cpf.charAt(10) - '0');
        } catch (Exception e) {
            return false;
        }
    }

    private void validarCamposObrigatorios(String nome, String cpf, LocalDate dataNascimento) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (!validarCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }

        LocalDate hoje = LocalDate.now();
        if (dataNascimento == null || dataNascimento.isAfter(hoje)) {
            throw new IllegalArgumentException("Data de nascimento inválida.");
        }

        int idade = Period.between(dataNascimento, hoje).getYears();
        if (idade < 10) {
            throw new IllegalArgumentException("Aluno deve ter pelo menos " + 10 + " anos.");
        }
    }
}
