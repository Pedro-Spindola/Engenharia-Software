package com.spindola.atividade_03.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spindola.atividade_03.model.Piloto;
import com.spindola.atividade_03.service.LeitorArquivoCsv;
import com.spindola.atividade_03.service.LeitorArquivoTemplate;
import com.spindola.atividade_03.service.LeitorArquivoTxt;
import com.spindola.atividade_03.service.LeitorArquivoXml;
import com.spindola.atividade_03.service.PilotoService;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {
    private final PilotoService pilotoService;

    // Constructor
    public PilotoController(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }

    // Endpoint para obter todos os pilotos da LinkedList
    @GetMapping("/linkedlist")
    public Iterable<Piloto> getPilotosLinkedList() {
        return getPilotos(pilotoService.getIteratorLinkedList());
    }

    // Endpoint para obter todos os pilotos do HashMap
    @GetMapping("/hashmap")
    public Iterable<Piloto> getPilotosHashMap() {
        return getPilotos(pilotoService.getIteratorHashMap());
    }

    // Endpoint para obter todos os pilotos do HashSet
    @GetMapping("/hashset")
    public Iterable<Piloto> getPilotosHashSet() {
        return getPilotos(pilotoService.getIteratorHashSet());
    }

    // Endpoint para obter todos os pilotos do TreeSet
    @GetMapping("/treeset")
    public Iterable<Piloto> getPilotosTreeSet() {
        return getPilotos(pilotoService.getIteratorTreeSet());
    }

    // Endpoint para obter todos os pilotos da Fila
    @GetMapping("/fila")
    public Iterable<Piloto> getPilotosFila() {
        return getPilotos(pilotoService.getIteratorFila());
    }

    // Método auxiliar para pegar pilotos de qualquer estrutura
    private Iterable<Piloto> getPilotos(Iterator<Piloto> iterator) {
        List<Piloto> pilotos = new ArrayList<>();
        while (iterator.hasNext()) {
            pilotos.add(iterator.next());
        }
        return pilotos;
    }

    // Endpoint para fazer upload do arquivo CSV
    @PostMapping("/upload")
    public Map<String, String> uploadArquivo(@RequestParam("file") MultipartFile file) {
        try {
            String nomeArquivo = file.getOriginalFilename();
            if (nomeArquivo == null || !nomeArquivo.contains(".")) {
                return Collections.singletonMap("message", "Arquivo inválido (sem extensão).");
            }

            String extensao = nomeArquivo.substring(nomeArquivo.lastIndexOf(".") + 1).toLowerCase();

            LeitorArquivoTemplate leitor;

            switch (extensao) {
                case "txt":
                    leitor = new LeitorArquivoTxt(pilotoService);
                    break;
                case "xml":
                    leitor = new LeitorArquivoXml(pilotoService);
                    break;
                case "csv":
                    leitor = new LeitorArquivoCsv(pilotoService);
                    break;
                default:
                    return Collections.singletonMap("message", "Formato de arquivo não suportado: " + extensao);
            }

            leitor.lerPilotos(file);

            return Collections.singletonMap("message", "Arquivo enviado e processado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.singletonMap("message", "Erro ao processar o arquivo.");
        }
    }

    }
