package com.senai.spindola.cs_atividade04.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.spindola.cs_atividade04.dto.VeiculoRequestDTO;
import com.senai.spindola.cs_atividade04.mapper.VeiculoMapper;
import com.senai.spindola.cs_atividade04.model.INotificacao;
import com.senai.spindola.cs_atividade04.model.Veiculo;
import com.senai.spindola.cs_atividade04.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;
    @Autowired
    private List<INotificacao> notificacao;
    @Autowired
    private VeiculoMapper veiculoMapper;

    public Veiculo registrarEntrada(VeiculoRequestDTO veiculoDTO){

        Veiculo veiculo = veiculoMapper.toEntity(veiculoDTO);

        if(!verificarVagasDisponivel()){

        }
        if(findByPlaca(veiculo.getPlaca()) == null){

        }
        if(!validarPlaca(veiculo.getPlaca())){

        }
        veiculo.setAtivo(true);
        veiculo.setDataEntrada(LocalDateTime.now());

        notificacao.forEach(n -> n.mensagemEntrada("Notificação enviada: ", veiculo));

        return repository.save(veiculo);
        // Verificar se tem vagas disponivel.
        // Verificar se não tem um veiculos com a mesma placa já estacionado.
        // Validar placa do carro.
        // Deixar vaga ocupada.
    }

    public Veiculo registrarSaida(Long id){
        Veiculo veiculo = repository.findById(id).get();
        veiculo.setDataSaida(LocalDateTime.now());
        veiculo.setAtivo(false);
        veiculo.setValorPago(calcularValorPago(veiculo.getDataEntrada(), veiculo.getDataSaida()));
        return repository.save(veiculo);
    }

    private float calcularValorPago(LocalDateTime entrada, LocalDateTime saida){
        // Taxa fixa de 5 reais até 30 min, apos isso cobra um valor de 0.25 centavos a cada mim.
        long tempoUtilizado = entrada.until(saida, ChronoUnit.MINUTES);
        float valorPago = 0;
        if(tempoUtilizado <= 30) valorPago = 5;
        else valorPago = (float)((tempoUtilizado - 30) * 0.25) + 5;
        return valorPago;
    }

    private boolean verificarVagasDisponivel(){
        if(listarEstacionados().size() > 3) return false;
        return true;
        // Capacidade maxima 10, fazer com 3 para teste.
    }

    private boolean validarPlaca(String placa) {
        if (placa == null) return false;
        placa = placa.toUpperCase();
        if (placa.length() != 7) return false;
        String padraoAntigo = "^[A-Z]{3}[0-9]{4}$";
        String padraoMercosul = "^[A-Z]{3}[0-9][A-Z][0-9]{2}$";
        return placa.matches(padraoAntigo) || placa.matches(padraoMercosul);
    }


    public List<Veiculo> listarEstacionados(){
        return repository.findByAtivo(true);
    }

    public Veiculo findByPlaca(String placa) {
        return repository.findByPlaca(placa).orElseThrow(() -> new RuntimeException("Veículo não encontrado com a placa: " + placa));
    }

    public List<Veiculo> buscarTodos(){
        return repository.findAll();
    }

    public String faturamentoDia(LocalDateTime date){
        // intervalo do dia
        LocalDateTime inicio = date.toLocalDate().atStartOfDay();
        LocalDateTime fim = inicio.plusDays(1).minusSeconds(1);

        List<Veiculo> veiculos = repository.findByDataSaidaBetween(inicio, fim);

        long quantidade = veiculos.size();
        float total = (float) veiculos.stream().mapToDouble(v -> v.getValorPago()).sum();

        return "No dia " + date.toLocalDate() + " saíram " + quantidade + " veículos e o faturamento foi de R$ " + total;
    }
    
}
