package com.spindola.atividade_02_pp.interfaces;

import com.spindola.atividade_02_pp.enums.TipoConector;

public interface IPlacaDeRede {
    public Integer getId();
    public String enviarPacote();
    public String receberPacote();
    public TipoConector getTipoConectorAntena();
    public TipoConector getTipoConectorFonteAlimentacao();
    public TipoConector getTipoConectorChipset();
    public String diagnostico();
}
