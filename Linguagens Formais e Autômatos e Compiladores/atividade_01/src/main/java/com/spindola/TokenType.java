package com.spindola;

public enum TokenType {
    // Palavras Chave (Keywords)
    KW_INICIO,
    KW_VAR,
    KW_LEIA,
    KW_ESCREVA,
    KW_SE,
    KW_SENAO,
    KW_FIM,

    // Operadores e Símbolos
    OM,           // Operador Matemático (+, *, /, -, %)
    OL,           // Operador Lógico/Relacional/Booleano (<, >, =, !, |, &, ~)
    SIMB_PARENTESES_ABRE,  // (
    SIMB_PARENTESES_FECHA, // )
    SIMB_ATRIBUICAO,       // :
    SIMB_PONTO_VIRGULA,    // ;

    // Identificadores e Literais
    ID,           // Identificador (letra)+
    NU,           // Literal Numérico (digito)+
    FR,           // Literal de Frase ("caracter+")

    // Fim de Arquivo e Erro
    EOF,
    ERROR         // Token não reconhecido
}
