package com.spindola.atividade_03.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.web.multipart.MultipartFile;

import com.spindola.atividade_03.model.Piloto;

public class LeituraArquivo {

    private PilotoService pilotoService;

    public LeituraArquivo(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }

    public void lerPilotos(MultipartFile file) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            String linha;
            //br.readLine();  // Caso tenha cabeçalho, pular a primeira linha
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                
                Piloto piloto = new Piloto(Integer.parseInt(dados[0]), dados[1], dados[2], Integer.parseInt(dados[3]), dados[4], dados[5], Integer.parseInt(dados[6]));
                pilotoService.addPiloto(piloto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
