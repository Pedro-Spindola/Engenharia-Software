package com.spindola.atividade_03.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spindola.atividade_03.model.Piloto;

public class LeitorArquivoTxt extends LeitorArquivoTemplate {



    @Override
    protected List<String[]> extrairLinhas(MultipartFile file) throws IOException {
        List<String[]> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha.split(","));
            }
        }
        return linhas;
    }

    @Override
    protected Piloto mapearParaPiloto(String[] dados) {
        return new Piloto(
            Integer.parseInt(dados[0]),
            dados[1],
            dados[2],
            Integer.parseInt(dados[3]),
            dados[4],
            dados[5],
            Integer.parseInt(dados[6])
        );
    }
}
