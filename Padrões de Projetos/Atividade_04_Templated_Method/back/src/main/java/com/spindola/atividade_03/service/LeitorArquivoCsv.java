package com.spindola.atividade_03.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spindola.atividade_03.model.Piloto;

public class LeitorArquivoCsv extends LeitorArquivoTemplate {

    public LeitorArquivoCsv(PilotoService pilotoService) {
        super(pilotoService);
    }

    @Override
    protected List<String[]> extrairLinhas(MultipartFile file) throws IOException {
        List<String[]> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            String linha;
            // br.readLine(); // caso tenha cabeçalho
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                linhas.add(dados);
            }
        }
        return linhas;
    }

    @Override
    protected Piloto mapearParaPiloto(String[] dados) {
        return new Piloto(
                Integer.parseInt(dados[0]),  // id
                dados[1],                    // nome
                dados[2],                    // nacionalidade
                Integer.parseInt(dados[3]),  // idade
                dados[4],                    // equipe
                dados[5],                    // motor
                Integer.parseInt(dados[6])   // pontos
        );
    }
}


