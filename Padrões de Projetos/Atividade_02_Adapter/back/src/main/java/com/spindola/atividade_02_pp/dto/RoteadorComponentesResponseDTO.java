package com.spindola.atividade_02_pp.dto;

public class RoteadorComponentesResponseDTO {
    private Long id;
    private String modeloRoteador;
    private String fabricante;

    private Object antena;
    private Object chipset;
    private Object fonteAlimentacao;
    private Object placaDeRede;

    private AdapterConectorDTO adapterAntena;
    private AdapterConectorDTO adapterChipset;
    private AdapterConectorDTO adapterFonte;

    public RoteadorComponentesResponseDTO(Long id, String modeloRoteador, String fabricante, Object antena, Object chipset, Object fonteAlimentacao, Object placaDeRede, AdapterConectorDTO adapterAntena, AdapterConectorDTO adapterChipset, AdapterConectorDTO adapterFonte) {
        this.id = id;
        this.modeloRoteador = modeloRoteador;
        this.fabricante = fabricante;
        this.antena = antena;
        this.chipset = chipset;
        this.fonteAlimentacao = fonteAlimentacao;
        this.placaDeRede = placaDeRede;
        this.adapterAntena = adapterAntena;
        this.adapterChipset = adapterChipset;
        this.adapterFonte = adapterFonte;
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

    public Object getAntena() {
        return antena;
    }

    public Object getChipset() {
        return chipset;
    }

    public Object getFonteAlimentacao() {
        return fonteAlimentacao;
    }

    public Object getPlacaDeRede() {
        return placaDeRede;
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

    public void setAntena(Object antena) {
        this.antena = antena;
    }

    public void setChipset(Object chipset) {
        this.chipset = chipset;
    }

    public void setFonteAlimentacao(Object fonteAlimentacao) {
        this.fonteAlimentacao = fonteAlimentacao;
    }

    public void setPlacaDeRede(Object placaDeRede) {
        this.placaDeRede = placaDeRede;
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
}
