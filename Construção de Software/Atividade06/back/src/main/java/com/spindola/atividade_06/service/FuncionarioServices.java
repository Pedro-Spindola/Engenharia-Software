package com.spindola.atividade_06.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.atividade_06.dto.DepartamentoResponseDTO;
import com.spindola.atividade_06.dto.FuncionarioRequestDTO;
import com.spindola.atividade_06.dto.FuncionarioResponseDTO;
import com.spindola.atividade_06.exception.EmailException;
import com.spindola.atividade_06.exception.FuncionarioException;
import com.spindola.atividade_06.mapper.DepartamentoMapper;
import com.spindola.atividade_06.mapper.FuncionarioMapper;
import com.spindola.atividade_06.model.Departamento;
import com.spindola.atividade_06.model.Funcionario;
import com.spindola.atividade_06.repository.DepartamentoRepository;
import com.spindola.atividade_06.repository.FuncionarioRepository;

@Service
public class FuncionarioServices {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    FuncionarioMapper funcionarioMapper;

    @Autowired DepartamentoMapper departamentoMapper;

    public List<FuncionarioResponseDTO> listarFuncionarios(){
        return funcionarioRepository.findAll().stream()
                .map(funcionario -> {
                    DepartamentoResponseDTO depDTO = departamentoMapper.toResponse(funcionario.getDepartamento());
                    return funcionarioMapper.toResponse(funcionario, depDTO);
                })
                .toList();
    }

    public FuncionarioResponseDTO obterFuncionarioId(Long id){
        Funcionario funcionario = funcionarioRepository.findById(id)
            .orElseThrow(() -> new FuncionarioException("Funcionario com id " + id + " não existe."));
        DepartamentoResponseDTO depDTO = departamentoMapper.toResponse(funcionario.getDepartamento());
        return funcionarioMapper.toResponse(funcionario, depDTO);
    }

    public FuncionarioResponseDTO cadastrarFuncionario(FuncionarioRequestDTO dto){
        Departamento departamento = departamentoRepository.findById(dto.id_departamento())
            .orElseThrow(() -> new FuncionarioException("Departamento com id " + dto.id() + " não existe."));
        
        if(!departamento.getAtivo()){
            throw new FuncionarioException("O departamento deve está ativo.");
        }

        Funcionario funcionario = funcionarioMapper.toEntity(dto, departamento);
        if (funcionario.getNome() == null || funcionario.getNome().isEmpty()) {
            throw new FuncionarioException("O nome do funcionário não pode estar vazio.");
        }

        if (funcionario.getEmail() == null || funcionario.getEmail().isEmpty()) {
            throw new FuncionarioException("O email do funcionário não pode estar vazio.");
        }

        if(funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new EmailException(funcionario.getEmail());
        }

        if (funcionario.getCargo() == null || funcionario.getCargo().isEmpty()) {
            throw new FuncionarioException("O cargo do funcionário não pode estar vazio.");
        }

        if (funcionario.getSalario() == null || funcionario.getSalario().doubleValue() <= 0) {
            throw new FuncionarioException("O salario do funcionário não pode estar vazio, deve ser maior do que 0.");
        }

        funcionario.setDataAdmissao(LocalDate.now());
        funcionario.setAtivo(true);
        funcionario.setDepartamento(departamento);

        funcionarioRepository.save(funcionario);

        DepartamentoResponseDTO departamentoResponseDTO = departamentoMapper.toResponse(departamento);

        return funcionarioMapper.toResponse(funcionario, departamentoResponseDTO);

        /**
         * Se um novo cadastro for feito com o mesmo e-mail de um funcionário inativo, o sistema deve reativar o
funcionário existente, atualizando seus dados e marcando ativo = true .
         */
    }

    public FuncionarioResponseDTO editarFuncionario(FuncionarioRequestDTO dto){
        Departamento departamento = departamentoRepository.findById(dto.id_departamento())
            .orElseThrow(() -> new FuncionarioException("Departamento com id " + dto.id() + " não existe."));
        
        if(!departamento.getAtivo()){
            throw new FuncionarioException("O departamento deve está ativo.");
        }

        Funcionario funcionarioNovo = funcionarioMapper.toEntity(dto, departamento);
        Funcionario funcionarioAtual = funcionarioRepository.findById(funcionarioNovo.getId())
            .orElseThrow(() -> new FuncionarioException("Funcionario com ID " + funcionarioNovo.getId() + " não encontrado."));

        if(!funcionarioNovo.getAtivo()) {
            throw new FuncionarioException("Funcionario com statu inativo, não pode ser editado.");
        }

        if(funcionarioAtual.getSalario().doubleValue() > funcionarioNovo.getSalario().doubleValue()){
            throw new FuncionarioException("Salario do funcionário não pode ser reduzido.");
        }

        Optional<Funcionario> funcionarioEmailExistente = funcionarioRepository.findByEmail(funcionarioNovo.getEmail());

        if(funcionarioEmailExistente.isPresent() && !funcionarioEmailExistente.get().getEmail().equals(funcionarioAtual.getEmail())){
            throw new EmailException(funcionarioNovo.getEmail());
        }

        funcionarioNovo.setDataAdmissao(funcionarioAtual.getDataAdmissao());
        funcionarioNovo.setDepartamento(departamento);

        funcionarioRepository.save(funcionarioNovo);

        DepartamentoResponseDTO departamentoResponseDTO = departamentoMapper.toResponse(departamento);

        return funcionarioMapper.toResponse(funcionarioNovo, departamentoResponseDTO);

        /*
A API deve retornar HTTP 400 (Bad Request) em caso de violação de regra.
        */
    }

    public Boolean inativarFuncionario(Long id){
        Funcionario funcionario = funcionarioRepository.findById(id)
            .orElseThrow(() -> new FuncionarioException("Funcionario com id " + id + " não existe."));
        
        if(funcionario.getAtivo()){
            funcionario.setAtivo(false);
        }else{
            funcionario.setAtivo(true);
        }
        funcionarioRepository.save(funcionario);
        return true;
    }
}
