package com.spindola.atividade_03.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.spindola.atividade_03.model.Piloto;
import com.spindola.atividade_03.model.PilotoIterator;

import java.util.*;

@Service
public class PilotoService {
    private LinkedList<Piloto> linkedList;
    private HashMap<Integer, Piloto> hashMap;
    private HashSet<Piloto> hashSet;
    private TreeSet<Piloto> treeSet;
    private Queue<Piloto> fila;

    public PilotoService() {
        this.linkedList = new LinkedList<>();
        this.hashMap = new HashMap<>();
        this.hashSet = new HashSet<>();
        this.treeSet = new TreeSet<>(Comparator.comparingInt(Piloto::getPontos));  // Ordenando por pontos
        this.fila = new LinkedList<>();
    }

    // Adiciona um piloto nas 5 estruturas
    public void addPiloto(Piloto piloto) {
        linkedList.add(piloto);
        hashMap.put(piloto.getMatricula(), piloto);
        hashSet.add(piloto);
        treeSet.add(piloto);
        fila.add(piloto);
    }

    // Retorna o iterador da LinkedList
    public Iterator<Piloto> getIteratorLinkedList() {
        return new PilotoIterator(linkedList);
    }

    // Retorna o iterador do HashMap
    public Iterator<Piloto> getIteratorHashMap() {
        return new PilotoIterator(hashMap.values());
    }

    // Retorna o iterador do HashSet
    public Iterator<Piloto> getIteratorHashSet() {
        return new PilotoIterator(hashSet);
    }

    // Retorna o iterador do TreeSet
    public Iterator<Piloto> getIteratorTreeSet() {
        return new PilotoIterator(treeSet);
    }

    // Retorna o iterador da Fila
    public Iterator<Piloto> getIteratorFila() {
        return new PilotoIterator(fila);
    }    
}
