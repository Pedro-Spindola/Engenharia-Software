package com.spindola;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    // Tabela para IDs (variáveis)
    private final Map<String, Integer> identifiers = new HashMap<>();
    private int nextIdentifierId = 1;

    // Tabela para Literais Numéricos (nu)
    private final Map<String, Integer> numbers = new HashMap<>();
    private int nextNumberId = 1;

    // Tabela para Literais de String/Frase (fr)
    private final Map<String, Integer> phrases = new HashMap<>();
    private int nextPhraseId = 1;
    
    // Método para registrar um Identificador (ID)
    public int registerIdentifier(String lexeme) {
        if (!identifiers.containsKey(lexeme)) {
            identifiers.put(lexeme, nextIdentifierId++);
        }
        return identifiers.get(lexeme);
    }
    
    // Método para registrar um Literal Numérico (NU)
    public int registerNumber(String lexeme) {
        if (!numbers.containsKey(lexeme)) {
            numbers.put(lexeme, nextNumberId++);
        }
        return numbers.get(lexeme);
    }
    
    // Método para registrar uma String/Frase (FR)
    public int registerPhrase(String lexeme) {
        if (!phrases.containsKey(lexeme)) {
            phrases.put(lexeme, nextPhraseId++);
        }
        return phrases.get(lexeme);
    }

    // --- Métodos de Saída Formatada (Conforme seu Requisito) ---
    
    // Ex: [id, 1]
    public String getIdentifierEntry(String lexeme) {
        return "[id, " + registerIdentifier(lexeme) + "]";
    }
    
    // Ex: [nu, 10]
    public String getNumberEntry(String lexeme) {
        // Usa o ID para identificação única
        return "[nu," + registerNumber(lexeme) + "]"; 
    }
    
    // Ex: [fr,entre um numero] (o próprio literal é usado no formato)
    public String getPhraseEntry(String lexeme) {
        registerPhrase(lexeme);
        // O seu exemplo mostra o literal (o texto da frase) como valor
        return "[fr," + lexeme + "]"; 
    }
    
    public void printTables() {
        System.out.println("\n--- Tabela de Símbolos ---");
        System.out.println("IDs: " + identifiers);
        System.out.println("Números: " + numbers);
        System.out.println("Frases: " + phrases);
        System.out.println("--------------------------");
    }
}