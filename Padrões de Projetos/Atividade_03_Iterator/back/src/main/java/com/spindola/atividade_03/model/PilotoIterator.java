package com.spindola.atividade_03.model;

import java.util.Iterator;

public class PilotoIterator implements Iterator<Piloto>{
    private Iterator<Piloto> iterator;

    public PilotoIterator(Iterable<Piloto> pilotos) {
        this.iterator = pilotos.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Piloto next() {
        return iterator.next();
    }

    @Override
    public void remove() {
        iterator.remove();
    }
    
}
