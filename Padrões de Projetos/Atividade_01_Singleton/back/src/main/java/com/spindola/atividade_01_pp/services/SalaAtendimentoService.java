package com.spindola.atividade_01_pp.services;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.spindola.atividade_01_pp.model.Guiche;
import com.spindola.atividade_01_pp.model.SalaAtendimento;

@Service
public class SalaAtendimentoService {
    
    private SalaAtendimento salaAtendimento;

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final Random random = new Random();
    private ScheduledFuture<?> tarefaFilaAutomatica;
    private boolean filaAutomaticaAtiva = false;
    private boolean atendendoFila = false;
    private int idPadrao = 0;

    public SalaAtendimentoService() {
        this.salaAtendimento = SalaAtendimento.getInstance();
    }

    // Alterna entre iniciar e parar a fila automática
    public String alternarFilaAutomatica() {
        if (!filaAutomaticaAtiva) {
            iniciarFilaAutomatica();
            return "Fila automática iniciada!";
        } else {
            pararFilaAutomatica();
            return "Fila automática pausada!";
        }
    }
    
    private void iniciarFilaAutomatica() {
        if (filaAutomaticaAtiva) return;

        filaAutomaticaAtiva = true;

        Runnable adicionarPessoa = new Runnable() {
            @Override
            public void run() {
                if (!filaAutomaticaAtiva) return; // parar execução se desativada

                String pessoa = gerarNomeAleatorio();
                salaAtendimento.entrarNaFila(pessoa);
                System.out.println("Pessoa adicionada automaticamente: " + pessoa);

                int delay = 2 + random.nextInt(9); // 2 a 10 segundos
                tarefaFilaAutomatica = scheduler.schedule(this, delay, TimeUnit.SECONDS);
            }
        };

        tarefaFilaAutomatica = scheduler.schedule(adicionarPessoa, 0, TimeUnit.SECONDS);
    }

    private void pararFilaAutomatica() {
        filaAutomaticaAtiva = false;
        if (tarefaFilaAutomatica != null) {
            tarefaFilaAutomatica.cancel(false);
        }
    }

    private String gerarNomeAleatorio() {
        String[] nomes = {
            "Pedro", "Maria", "João", "Ana", "Carlos", "Julia", "Lucas", "Beatriz",
            "Gabriel", "Mariana", "Rafael", "Camila", "Felipe", "Larissa", "Bruno", "Amanda",
            "Thiago", "Isabela", "Daniel", "Patrícia", "Eduardo", "Fernanda", "Vinicius", "Renata"
        };
        String[] sobrenomes = {
            "Silva", "Santos", "Oliveira", "Souza", "Costa", "Pereira", "Rodrigues", "Alves",
            "Nascimento", "Lima", "Gomes", "Martins", "Araújo", "Ribeiro", "Carvalho", "Fernandes",
            "Barbosa", "Monteiro", "Moura", "Cavalcanti"
        };
        return nomes[random.nextInt(nomes.length)] + " " + sobrenomes[random.nextInt(sobrenomes.length)];
    }

    public String iniciarAtendimento() {
        if (!atendendoFila) {
            System.out.println("INICIO O ATENDIMENTO");
            atendendoFila = true;
            new Thread(() -> {
                while (atendendoFila) {
                    atenderFila();
                }
            }).start();
            return "Atendimento iniciado!";
        } else {
            atendendoFila = false;
            return "Atendimento pausado!";
        }
    }

    private void atenderFila() {
        for (Guiche guiche : salaAtendimento.getGuiches()) {
            if (!guiche.isOcupado() && !salaAtendimento.getFila().isEmpty()) {
                String pessoa = atenderProximo();
                guiche.setOcupado(true);
                guiche.setPessoaAtendida(pessoa);

                // cada atendimento em uma thread separada
                new Thread(() -> {
                    System.out.println("Atendendo: " + pessoa + " no guichê " + guiche.getNome());
                    try {
                        Thread.sleep(12000); // simula atendimento
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    guiche.setOcupado(false);
                    guiche.setPessoaAtendida(null);
                }).start();
            }
        }
    }


    // Obter a sala
    public SalaAtendimento getSala() {
        return salaAtendimento;
    }

    // Adicionar guichê
    public SalaAtendimento adicionarGuiche(String nomeGuiche) {
        Guiche guiche = new Guiche(idPadrao, nomeGuiche, SalaAtendimento.getInstance());
        salaAtendimento.adicionarGuiche(guiche);
        idPadrao++;
        return salaAtendimento;
    }

    // Apagar guiche
    public String deleteGuicheId(int id){
        boolean removido = salaAtendimento.removerGuichePorId(id);
        if(removido)return "Guiche removido";
        return "Erro";
    }

    // Colocar pessoa na fila
    public SalaAtendimento entrarNaFila(String pessoa) {
        salaAtendimento.entrarNaFila(pessoa);
        return salaAtendimento;
    }

    // Atender próximo
    public String atenderProximo() {
        return salaAtendimento.atenderProximo();
    }

    public boolean isFilaAutomaticaAtiva() {
        return filaAutomaticaAtiva;
    }

    public boolean isAtendendoFila() {
        return atendendoFila;
    }

}
