package com.spindola.atividade_03.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.spindola.atividade_03.model.Piloto;

public abstract class LeitorArquivoTemplate {
    
    @Autowired
    protected PilotoService pilotoService;

    public final void lerArquivo(MultipartFile file) throws IOException {
        List<String[]> linhas = extrairLinhas(file);
        for (String[] dados : linhas) {
            Piloto piloto = mapearParaPiloto(dados);
            pilotoService.addPiloto(piloto);
        }
    }

    protected abstract List<String[]> extrairLinhas(MultipartFile file) throws IOException;
    protected abstract Piloto mapearParaPiloto(String[] dados);
}
