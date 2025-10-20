package com.spindola;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lexer {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private final SymbolTable symbolTable;
    
    private int start = 0;   // Início do lexema atual
    private int current = 0; // Posição atual no código-fonte
    
    private static final Map<String, TokenType> keywords;

    // Inicializa as palavras-chave da sua linguagem
    static {
        keywords = new HashMap<>();
        keywords.put("inicio", TokenType.KW_INICIO);
        keywords.put("var", TokenType.KW_VAR);
        keywords.put("leia", TokenType.KW_LEIA);
        keywords.put("escreva", TokenType.KW_ESCREVA);
        keywords.put("se", TokenType.KW_SE);
        keywords.put("senao", TokenType.KW_SENAO);
        keywords.put("fim", TokenType.KW_FIM);
    }

    public Lexer(String source, SymbolTable symbolTable) {
        // O source deve ser o código JÁ limpo (sem comentários e linhas em branco)
        this.source = source; 
        this.symbolTable = symbolTable;
    }

    public List<Token> scanTokens() {
        while (!isAtEnd()) {
            start = current;
            scanToken();
        }

        tokens.add(new Token(TokenType.EOF, "", null));
        return tokens;
    }

    private void scanToken() {
        char c = advance();
        switch (c) {
            case '(': addToken(TokenType.SIMB_PARENTESES_ABRE); break;
            case ')': addToken(TokenType.SIMB_PARENTESES_FECHA); break;
            case ':': addToken(TokenType.SIMB_ATRIBUICAO); break;
            case ';': addToken(TokenType.SIMB_PONTO_VIRGULA); break;
            
            // OPERADORES MATEMÁTICOS (OM)
            case '+':
            case '-':
            case '*':
            case '/':
            case '%': 
                addToken(TokenType.OM); 
                break;
                
            // OPERADORES LÓGICOS/RELACIONAIS (OL)
            case '<':
            case '>':
            case '=':
            case '!': 
            case '|': 
            case '&': 
            case '~':
                addToken(TokenType.OL); 
                break;

            case ' ', '\r', '\t', '\n':
                // Ignora espaços em branco (se o código de limpeza não os removeu 100%)
                break;

            case '"': string(); break; // Lida com literais de string/frases (FR)

            default:
                if (isDigit(c)) {
                    number(); // Lida com literais numéricos (NU)
                } else if (isAlpha(c)) {
                    identifier(); // Lida com palavras-chave e identificadores (ID)
                } else {
                    // **EMITE MENSAGEM DE ERRO (Token não reconhecido)**
                    System.err.println("ERRO LÉXICO: Caractere não reconhecido: '" + c + 
                                       "' na posição " + start);
                    addToken(TokenType.ERROR);
                }
                break;
        }
    }
    
    private void identifier() {
        // Padrão ID: (letra | digito | _) +
        while (isAlphaNumeric(peek())) advance();

        String text = source.substring(start, current);
        TokenType type = keywords.get(text);
        
        if (type == null) {
            // É um identificador (ID). O ID é registrado na SymbolTable
            int id = symbolTable.registerIdentifier(text);
            addToken(TokenType.ID, id); 
        } else {
            // É uma palavra-chave
            addToken(type);
        }
    }
    
    private void number() {
        // Padrão NU: (digito)+
        while (isDigit(peek())) advance();

        String text = source.substring(start, current);
        // O número é registrado na SymbolTable
        int id = symbolTable.registerNumber(text);
        addToken(TokenType.NU, id);
    }
    
    private void string() {
        // Padrão FR: ("caracter+")
        while (peek() != '"' && !isAtEnd()) {
            advance(); 
        }

        if (isAtEnd()) {
            System.err.println("ERRO LÉXICO: Frase não terminada.");
            addToken(TokenType.ERROR);
            return;
        }

        advance(); // Consome o " de fechamento

        // Extrai o valor da string (removendo as aspas)
        String value = source.substring(start + 1, current - 1);
        // A frase é registrada na SymbolTable
        int id = symbolTable.registerPhrase(value);
        addToken(TokenType.FR, id);
    }

    // --- Métodos Auxiliares ---
    private boolean isAtEnd() { return current >= source.length(); }
    private char advance() { return source.charAt(current++); }
    private char peek() { return isAtEnd() ? '\0' : source.charAt(current); }
    
    private void addToken(TokenType type) {
        addToken(type, null);
    }

    private void addToken(TokenType type, Object literal) {
        String lexeme = source.substring(start, current);
        tokens.add(new Token(type, lexeme, literal));
    }
    
    private boolean isDigit(char c) { return c >= '0' && c <= '9'; }
    private boolean isAlpha(char c) { 
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_'; 
    }
    private boolean isAlphaNumeric(char c) { return isAlpha(c) || isDigit(c); }
}