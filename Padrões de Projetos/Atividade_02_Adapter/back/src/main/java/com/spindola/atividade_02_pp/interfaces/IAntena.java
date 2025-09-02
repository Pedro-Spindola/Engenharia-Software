package com.spindola.atividade_02_pp.interfaces;

import com.spindola.atividade_02_pp.enums.TipoConector;

public interface IAntena {
    public Integer getId();
    public String transmitirSinal();
    public String receberSinal();
    public TipoConector getTipoConector();
}
