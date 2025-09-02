package com.spindola.atividade_02_pp.dto;

import com.spindola.atividade_02_pp.model.Roteador;

public class RoteadorResponseDTO {
    private Long id;
    private String modeloRoteador;
    private String fabricante;

    private Object antena;
    private Object chipset;
    private Object fonteAlimentacao;
    private Object placaDeRede;

    private Object adapterAntena;
    private Object adapterChipset;
    private Object adapterFonte;

    public RoteadorResponseDTO(Roteador r) {
        this.id = r.getId();
        this.modeloRoteador = r.getModeloRoteador();
        this.fabricante = r.getFabricante();

        this.antena = r.getAntena();
        this.chipset = r.getChipset();
        this.fonteAlimentacao = r.getFonteAlimentacao();
        this.placaDeRede = r.getPlacaDeRede();

        this.adapterAntena = r.getAdapterAntena();
        this.adapterChipset = r.getAdapterChipset();
        this.adapterFonte = r.getAdapterFonte();
    }
    public Long getId() { return id; }
    public String getModeloRoteador() { return modeloRoteador; }
    public String getFabricante() { return fabricante; }
    public Object getAntena() { return antena; }
    public Object getChipset() { return chipset; }
    public Object getFonteAlimentacao() { return fonteAlimentacao; }
    public Object getPlacaDeRede() { return placaDeRede; }
    public Object getAdapterAntena() { return adapterAntena; }
    public Object getAdapterChipset() { return adapterChipset; }
    public Object getAdapterFonte() { return adapterFonte; }
}
