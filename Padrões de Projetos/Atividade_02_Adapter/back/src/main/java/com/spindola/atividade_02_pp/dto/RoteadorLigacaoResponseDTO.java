package com.spindola.atividade_02_pp.dto;

import java.util.List;

public class RoteadorLigacaoResponseDTO {
   private Long id;
    private String modeloRoteador;
    private String fabricante;
    private List<String> diagnostico;
    private AdapterConectorDTO adapterAntena;
    private AdapterConectorDTO adapterChipset;
    private AdapterConectorDTO adapterFonte;
    private String status;

    public RoteadorLigacaoResponseDTO(Long id, String modeloRoteador, String fabricante, List<String> diagnostico, AdapterConectorDTO adapterAntena, AdapterConectorDTO adapterChipset, AdapterConectorDTO adapterFonte, String status) {
        this.id = id;
        this.modeloRoteador = modeloRoteador;
        this.fabricante = fabricante;
        this.diagnostico = diagnostico;
        this.adapterAntena = adapterAntena;
        this.adapterChipset = adapterChipset;
        this.adapterFonte = adapterFonte;
        this.status = status;
    } 

    public Long getId() {
        return id;
    }

    public String getModeloRoteador() {
        return modeloRoteador;
    }

    public String getFabricante() {
        return fabricante;
    }

    public List<String> getDiagnostico() {
        return diagnostico;
    }

    public AdapterConectorDTO getAdapterAntena() {
        return adapterAntena;
    }

    public AdapterConectorDTO getAdapterChipset() {
        return adapterChipset;
    }

    public AdapterConectorDTO getAdapterFonte() {
        return adapterFonte;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setModeloRoteador(String modeloRoteador) {
        this.modeloRoteador = modeloRoteador;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setDiagnostico(List<String> diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setAdapterAntena(AdapterConectorDTO adapterAntena) {
        this.adapterAntena = adapterAntena;
    }

    public void setAdapterChipset(AdapterConectorDTO adapterChipset) {
        this.adapterChipset = adapterChipset;
    }

    public void setAdapterFonte(AdapterConectorDTO adapterFonte) {
        this.adapterFonte = adapterFonte;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
