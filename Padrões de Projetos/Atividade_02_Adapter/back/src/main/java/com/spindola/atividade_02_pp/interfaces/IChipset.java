package com.spindola.atividade_02_pp.interfaces;

import com.spindola.atividade_02_pp.enums.TipoConector;

public interface IChipset {
    public Integer getId();
    public String processarDados();
    public TipoConector getTipoConector();
}
