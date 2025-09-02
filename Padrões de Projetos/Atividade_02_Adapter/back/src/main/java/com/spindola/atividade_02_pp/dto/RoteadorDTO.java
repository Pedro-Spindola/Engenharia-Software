package com.spindola.atividade_02_pp.dto;

public class RoteadorDTO {
    private String modeloRoteador;
    private String fabricante;
    private Integer antenaId;
    private Integer chipsetId;
    private Integer fonteId;
    private Integer placaId;

    public String getModeloRoteador() { return modeloRoteador; }
    public String getFabricante() { return fabricante; }
    public Integer getAntenaId() { return antenaId; }
    public Integer getChipsetId() { return chipsetId; }
    public Integer getFonteId() { return fonteId; }
    public Integer getPlacaId() { return placaId; }

    public void setModeloRoteador(String modeloRoteador) { this.modeloRoteador = modeloRoteador; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
    public void setAntenaId(Integer antenaId) { this.antenaId = antenaId; }
    public void setChipsetId(Integer chipsetId) { this.chipsetId = chipsetId; }
    public void setFonteId(Integer fonteId) { this.fonteId = fonteId; }
    public void setPlacaId(Integer placaId) { this.placaId = placaId; }
}



