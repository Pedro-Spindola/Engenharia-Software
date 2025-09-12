package com.spindola.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.spindola.model.Responsavel;
import com.spindola.model.Tarefa;
import com.spindola.services.TarefaServices;

public class TarefaController {
    private final TarefaServices service;
    private final Scanner sc;
    private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

    public TarefaController(TarefaServices service){
        this.service = service;
        sc = new Scanner(System.in);
    }

    public void executar(){
        System.out.println("--- SISTEMA DE GESTÃO DE TAREFAS ---");
        while (true) {
            try {
                exibirMenu();
                int opcao = lerInteiro("Escolha uma opção: ");
                switch (opcao) {
                    case 1 -> cadastrarTarefa();
                    case 2 -> listarTarefas();
                    case 3 -> atualizarTarefa();
                    case 4 -> alterarStatusTarefa();
                    case 5 -> buscarPeloId();
                    case 6 -> removerTarefa();
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

    private void cadastrarTarefa(){
        System.out.println("\n--- Cadastrar nova tarefa ---");
        String titulo = lerString("Titulo: ");
        String descricao = lerString("Descrição: ");
        for (Responsavel resp : service.listarResponsavel()){
            System.out.println(resp.getId() + " - " + resp.getNome() + ".");
        }
        Integer responsavel = lerInteiro("Selecione responsavel: ");
        System.out.println("Status disponivel:");
        System.out.println("1 - Pendente");
        System.out.println("2 - Em Andamento");
        Integer status = lerInteiro("Selecione o status: ");
        System.out.println("Prioridade disponivel:");
        System.out.println("1 - Baixa");
        System.out.println("2 - Media");
        System.out.println("3 - Alta");
        Integer prioridade = lerInteiro("Selecione a prioridade: ");
        
        Tarefa novaTarefa = service.cadastrarTarefa(titulo, descricao, responsavel, status, prioridade);
        System.out.println("Tarefa cadastrada com sucesso!");
        System.out.println(novaTarefa);
    }

    private void listarTarefas(){
        System.out.println("\n--- Lista todas as tarefa ---");
        List<Tarefa> tarefas = service.listarTarefas();

        for (Tarefa t : tarefas) {
            System.out.println("ID: " + t.getId());
            System.out.println("Título: " + t.getTitulo());
            System.out.println("Descrição: " + t.getDescricao());
            System.out.println("Responsável: " + t.getResponsavel().getNome());
            System.out.println("Status: " + t.getStatus());
            System.out.println("Prioridade: " + t.getPrioridade());
            System.out.println("Data de Criação: " + t.getDataCriacao().format(formatador));
            System.out.println("Data de Conclusão: " + (t.getDataConclusao() != null ? t.getDataConclusao().format(formatador) : "Não concluída"));
            System.out.println("-".repeat(40));
        }
    }

    private void atualizarTarefa(){
        System.out.println("\n--- Atualizar uma tarefa ---");
        System.out.println("Informe o Id da tarefa que deseja atualizar!");
        Integer id = lerInteiro("Digite ID: ");
        String titulo = lerString("Titulo: ");
        String descricao = lerString("Descrição: ");
        for (Responsavel resp : service.listarResponsavel()){
            System.out.println(resp.getId() + " - " + resp.getNome() + ".");
        }
        Integer responsavel = lerInteiro("Selecione responsavel: ");
        System.out.println("Prioridade disponivel:");
        System.out.println("1 - Baixa");
        System.out.println("2 - Media");
        System.out.println("3 - Alta");
        Integer prioridade = lerInteiro("Selecione a prioridade: ");

        Tarefa tarefaAtualizada = service.atualizarTarefa(id, titulo, descricao, responsavel, prioridade);
        System.out.println("Tarefa atualizada com sucesso!");
        System.out.println(tarefaAtualizada);
    }

    private void alterarStatusTarefa(){
        System.out.println("\n--- Atualizar status de uma tarefa ---");
        System.out.println("Informe o Id da tarefa que deseja buscar!");
        Integer idBusca = lerInteiro("Digite ID: ");
        System.out.println("Status disponivel:");
        System.out.println("1 - Pendente");
        System.out.println("2 - Em Andamento");
        System.out.println("3 - Concluído");
        Integer status = lerInteiro("Selecione o status: ");
        service.atualizarStatus(idBusca, status);
    }

    private void buscarPeloId(){
        System.out.println("\n--- Buscar pelo Id ---");
        System.out.println("Informe o Id da tarefa que deseja buscar!");
        Integer idBusca = lerInteiro("Digite ID: ");
        Tarefa t = service.buscarPeloId(idBusca);
        System.out.println("ID: " + t.getId());
        System.out.println("Título: " + t.getTitulo());
        System.out.println("Descrição: " + t.getDescricao());
        System.out.println("Responsável: " + t.getResponsavel().getNome());
        System.out.println("Status: " + t.getStatus());
        System.out.println("Prioridade: " + t.getPrioridade());
        System.out.println("Data de Criação: " + t.getDataCriacao().format(formatador));
        System.out.println("Data de Conclusão: " + (t.getDataConclusao() != null ? t.getDataConclusao().format(formatador) : "Não concluída"));
        System.out.println("-------------------------");

    }

    private void removerTarefa(){
        System.out.println("\n--- Remover tarefa ---");
        List<Tarefa> tarefas = service.listarTarefas();
        for (Tarefa t : tarefas) {
            System.out.println("ID: " + t.getId());
            System.out.println("Título: " + t.getTitulo());
            System.out.println("Descrição: " + t.getDescricao());
            System.out.println("Responsável: " + t.getResponsavel().getNome());
            System.out.println("Status: " + t.getStatus());
            System.out.println("Prioridade: " + t.getPrioridade());
            System.out.println("Data de Criação: " + t.getDataCriacao().format(formatador));
            System.out.println("Data de Conclusão: " + (t.getDataConclusao() != null ? t.getDataConclusao().format(formatador) : "Não concluída"));
            System.out.println("-------------------------");
        }

        System.out.println("Informe o Id da tarefa que deseja remover!");
        Integer idRemover = lerInteiro("Digite ID: ");
        System.out.println("Desejar mesmo remover a tarefa selecionado com o ID: " + idRemover + ", digite S para sim, N para não.");
        String confirmacaoString = lerString("Confirme: ");
        Boolean confirmacao = confirmacaoString.equals("S") ? true : false;
        if(confirmacao){
            service.removerTarefa(idRemover);
            System.out.println("Tarefa removida com sucesso.");
        }else{
            System.out.println("Operação cancelada.");
        }

    }

    private void exibirMenu() {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("1. Cadastrar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Atualizar Tarefas");
        System.out.println("4. Alterar Status da Tarefa");
        System.out.println("5. Buscar Tarefa pelo ID");
        System.out.println("6. Remover Tarefa");
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
}
