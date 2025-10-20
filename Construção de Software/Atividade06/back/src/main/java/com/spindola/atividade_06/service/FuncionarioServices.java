package com.spindola.atividade_06.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.atividade_06.dto.FuncionarioRequestDTO;
import com.spindola.atividade_06.dto.FuncionarioResponseDTO;
import com.spindola.atividade_06.exception.EmailException;
import com.spindola.atividade_06.exception.FuncionarioException;
import com.spindola.atividade_06.mapper.FuncionarioMapper;
import com.spindola.atividade_06.model.Funcionario;
import com.spindola.atividade_06.repository.FuncionarioRepository;

@Service
public class FuncionarioServices {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    FuncionarioMapper funcionarioMapper;

    public List<FuncionarioResponseDTO> listarFuncionarios(){
        return funcionarioRepository.findAll().stream()
                .map(funcionarioMapper::toResponse)
                .toList();
    }

    public FuncionarioResponseDTO obterFuncionarioId(Long id){
        Funcionario funcionario = funcionarioRepository.findById(id)
            .orElseThrow(() -> new FuncionarioException("Funcionario com id " + id + " não existe."));

        return funcionarioMapper.toResponse(funcionario);
    }

    public FuncionarioResponseDTO cadastrarFuncionario(FuncionarioRequestDTO dto){
        Funcionario funcionario = funcionarioMapper.toEntity(dto);
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

        return funcionarioMapper.toResponse(funcionarioRepository.save(funcionario));

        /**
         * Se um novo cadastro for feito com o mesmo e-mail de um funcionário inativo, o sistema deve reativar o
funcionário existente, atualizando seus dados e marcando ativo = true .
         */
    }

    public FuncionarioResponseDTO editarFuncionario(FuncionarioRequestDTO dto){
        Funcionario funcionarioNovo = funcionarioMapper.toEntity(dto);
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

        return funcionarioMapper.toResponse(funcionarioRepository.save(funcionarioNovo));

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
