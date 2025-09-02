package com.spindola.atividade_01_pp.model;

import java.util.*;

public class SalaAtendimento {
    private String nome;
    private int quantidadeGuiches;
    private List<Guiche> guiches;
    private List<String> fila;
    private static SalaAtendimento instancia;

    private SalaAtendimento() {
        this.nome = "Sala VIP - Banco Gyn";
        this.quantidadeGuiches = 0;
        this.guiches = new ArrayList<>();
        this.fila = new ArrayList<>();
    }

    public static SalaAtendimento getInstance() {
        if (instancia == null) instancia = new SalaAtendimento();
        return instancia;
    }

    // Método adicionar guichê
    public void adicionarGuiche(Guiche guiche) {
        guiches.add(guiche);
        quantidadeGuiches++;
    }

    // Método remover guichê
    public boolean removerGuichePorId(int id) {
        // Usamos um iterador para evitar ConcurrentModificationException durante a remoção
        Iterator<Guiche> iterator = guiches.iterator();
        while (iterator.hasNext()) {
            Guiche guiche = iterator.next();
            if (guiche.getId() == id) {
                iterator.remove(); // Remove o Guiche da lista
                return true; // Retorna true quando o guiche for encontrado e removido
            }
        }
        return false; // Retorna false se o guiche com o id não for encontrado
    }

    // Adicionar uma pessoa à fila
    public void entrarNaFila(String pessoa) {
        fila.add(pessoa);
    }
    
    // Atender a próxima pessoa da fila
    public String atenderProximo() {
        if (fila.isEmpty()) return "Nenhuma pessoa na fila!";
        return fila.remove(0);
    }

    // Get e Set
    public String getNome() {
        return nome;
    }

    public int getQuantidadeGuiches() {
        return quantidadeGuiches;
    }

    public List<Guiche> getGuiches() {
        return guiches;
    }

    public List<String> getFila() {
        return fila;
    }
}
