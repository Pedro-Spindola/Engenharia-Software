package com.spindola;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    
    // Método para ler e limpar o código (Passo 1: Remoção de comentários e espaços)
    public static String getCleanedCode(String inputPathString) throws IOException {
        Path inputPath = Paths.get(inputPathString);
        String content = Files.readString(inputPath); // Lê o arquivo inteiro

        // 1. REMOVER COMENTÁRIOS DE MÚLTIPLAS LINHAS (/* ... */)
        String withoutBlockComments = content.replaceAll("(?s)/\\*.*?\\*/", "");

        // 2. REMOVER COMENTÁRIOS DE LINHA ÚNICA (// ...)
        String withoutLineComments = withoutBlockComments.replaceAll("//.*", "");

        // 3. REMOVER LINHAS VAZIAS OU COM APENAS ESPAÇOS E JUNTAR
        // Juntamos com um espaço para garantir que tokens não se fundam (ex: 'var x' 'var y' -> 'varxvary')
        String cleanedCode = withoutLineComments.lines()
                .map(String::trim) 
                .filter(line -> !line.isEmpty())
                .collect(Collectors.joining(" "));

        return cleanedCode; 
    }
    
    public static void main(String[] args) {
        // Altere o nome do arquivo para o seu código de entrada
        String inputFile = "src\\main\\resources\\input.txt"; 

        try {
            // 1. Limpeza do Código (Passo 1)
            String cleanSource = getCleanedCode(inputFile);
            System.out.println("--- Código Limpo ---\n" + cleanSource + "\n--------------------");
            
            // 2. Análise Léxica (Passo 2)
            SymbolTable symbolTable = new SymbolTable();
            Lexer lexer = new Lexer(cleanSource, symbolTable);
            
            List<Token> tokens = lexer.scanTokens();
            
            // 3. Impressão da Saída no formato solicitado
            System.out.println("\n--- Sequência de Tokens (Léxico) ---");
            tokens.forEach(token -> {
                String output = "";
                TokenType type = token.getType();
                String lexeme = token.getLexeme();
                
                // Formata os Identificadores, Números e Frases com IDs da Tabela de Símbolos
                if (type == TokenType.ID) {
                    output = symbolTable.getIdentifierEntry(lexeme);
                } else if (type == TokenType.NU) {
                    output = symbolTable.getNumberEntry(lexeme);
                } else if (type == TokenType.FR) {
                    output = symbolTable.getPhraseEntry(lexeme);
                } 
                // Formata os Operadores (OM e OL) conforme o padrão [token, lexema]
                else if (type == TokenType.OL) {
                    output = "[ol, " + lexeme + "]";
                } else if (type == TokenType.OM) {
                    // O seu exemplo não mostra OM, mas segue o padrão
                    output = "[om, " + lexeme + "]"; 
                }
                // Formata Símbolos e Palavras-Chave [token, ]
                else {
                    // Pega o nome do token e remove "KW_" ou "SIMB_" se houver, e converte para minúsculas
                    String typeName = type.name().toLowerCase().replace("kw_", "").replace("simb_", "");
                    
                    // Exceções para símbolos:
                    if (type == TokenType.SIMB_ATRIBUICAO) typeName = ":";
                    if (type == TokenType.SIMB_PONTO_VIRGULA) typeName = ";";
                    if (type == TokenType.SIMB_PARENTESES_ABRE) typeName = "(";
                    if (type == TokenType.SIMB_PARENTESES_FECHA) typeName = ")";
                    
                    if (type == TokenType.EOF) {
                        output = "[EOF, ]";
                    } else if (type == TokenType.ERROR) {
                        output = "[ERROR, " + lexeme + "]";
                    } else {
                        output = "[" + typeName + ", ]";
                    }
                }
                
                // Imprime a saída formatada
                System.out.print(output + " ");
            });
            
            symbolTable.printTables(); 
            
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}