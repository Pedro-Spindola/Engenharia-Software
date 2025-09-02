package com.spindola.atividade_02_pp.interfaces;

import com.spindola.atividade_02_pp.enums.TipoConector;

public interface IFonteAlimentacao {
    public Integer getId();
    public String fornecerEnergia();
    public TipoConector getTipoConector();
}
