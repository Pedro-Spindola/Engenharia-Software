package com.spindola;

public class Token {
    private final TokenType type;
    private final String lexeme;
    private final Object literal; // Usado para armazenar o ID da Tabela de Símbolos

    public Token(TokenType type, String lexeme, Object literal) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
    }

    public TokenType getType() { return type; }
    public String getLexeme() { return lexeme; }
    public Object getLiteral() { return literal; }

    @Override
    public String toString() {
        // Formato para debug: [TIPO, LEXEMA, LITERAL]
        return "[" + type.name() + ", " + (lexeme != null ? lexeme : "") + 
               (literal != null ? ", " + literal.toString() : "") + "]";
    }
}