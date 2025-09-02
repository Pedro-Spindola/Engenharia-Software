package com.spindola.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.spindola.model.Livro;
import com.spindola.services.LivroService;

public class LivroController {
    private final LivroService service;
    private final Scanner sc;

    public LivroController(LivroService service){
        this.service = service;
        sc = new Scanner(System.in);
    }

    public void executar(){
        System.out.println("--- SISTEMA DE GESTÃO DE LIVROS ---");
        while (true) {
            try {
                exibirMenu();
                int opcao = lerInteiro("Escolha uma opção: ");
                switch (opcao) {
                    case 1 -> cadastrarLivro();
                    case 2 -> listarLivro();
                    case 3 -> alterarStatusLivro();
                    case 4 -> atualizarLivro();
                    case 5 -> removerLivro();
                    case 0 -> {
                    System.out.println("Saindo do sistema...");
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }

                System.out.println("\nPressione ENTER para continuar...");
                sc.nextLine();

            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
    }

    private void cadastrarLivro(){
        System.out.println("\n--- Cadastrar Livro ---");
        String titulo = lerString("Nome: ");
        String autor = lerString("Autor: ");
        String isbn = lerString("ISBN: ");
        String a = lerString("Ano Publicado: ");
        LocalDate ano = validarAno(a);

        Livro novoLivro = service.cadastrarLivro(titulo, autor, isbn, ano);
        System.out.println("Livro cadastrado com sucesso!");
        System.out.println(novoLivro);
    }

    private void listarLivro(){
        System.out.println("\n--- Listar Livro ---");
        List<Livro> livros = service.listarLivro();
        if(livros.isEmpty()){
            System.out.println("Nenhum livros cadastrado.");
            return;
        }
        System.out.println("ID - Titulo - Autor - ISBN - Ano Publicado - Status");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    private void atualizarLivro(){
        System.out.println("\n--- Atualizar Livro ---");
        Integer id = lerInteiro("Informe ID:");
        Livro livroParaAtualizar = service.buscaLivroPorId(id);

        String titulo = lerString("Nome: ");
        String autor = lerString("Autor: ");
        String isbn = lerString("ISBN: ");
        String a = lerString("Ano Publicado: ");
        LocalDate ano = validarAno(a);

        service.atualizarLivro(id, titulo, autor, isbn, ano);

        System.out.println("Livro atualizado com sucesso, pelo ID: " + livroParaAtualizar);
    }

    private void alterarStatusLivro(){
        System.out.println("\n--- Atualizar Livro ---");
        Integer id = lerInteiro("Informe ID:");
        Livro livroParaAtualizar = service.buscaLivroPorId(id);

        System.out.println("1. Disponivel");
        System.out.println("2. Indisponivel");

        Integer status = lerInteiro("Selecione o status: ");

        switch (status) {
            case 1 -> service.marcarComoDisponivel(livroParaAtualizar.getId());
            case 2 -> service.marcarComoIndisponivel(livroParaAtualizar.getId());
            default -> System.out.println("Opção inválida!");
        }

        System.out.println("Status do livro atualizado com sucesso, pelo ID: " + livroParaAtualizar);
    }

    private void removerLivro(){
        System.out.println("\n--- Remover Livro ---");
        Integer id = lerInteiro("ID do funcionário: ");
        Livro livro = service.buscaLivroPorId(id);
        System.out.println("Livro a ser removido: " + livro);

        System.out.println("1. Sim");
        System.out.println("2. Não");

        Integer status = lerInteiro("Selecione o status: ");
        boolean sucesso = false;

        switch (status) {
            case 1 -> sucesso = service.removerLivro(id);
            case 2 -> System.out.println("Operação cancelada.");
            default -> System.out.println("Opção inválida!");
        }

        if(sucesso) {
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Erro ao remover Livro.");
        }
    }

    private void exibirMenu() {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("1. Cadastrar Livros");
        System.out.println("2. Listar Livros");
        System.out.println("3. Alterar Status do Livro");
        System.out.println("4. Atualizar Livros");
        System.out.println("5. Remover Livro");
        System.out.println("0. Sair");
        System.out.println("-".repeat(40));
    }

    private int lerInteiro(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
            }
        }
    }

    private String lerString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    private LocalDate validarAno(String anoString) {
        try {
            Integer ano = Integer.parseInt(anoString);
            return LocalDate.of(ano, 1, 1);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Ano inválido. Formato esperado: YYYY");
        }
    }
}
