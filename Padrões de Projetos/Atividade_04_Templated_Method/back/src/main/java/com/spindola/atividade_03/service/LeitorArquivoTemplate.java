package com.spindola.atividade_03.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spindola.atividade_03.model.Piloto;

public abstract class LeitorArquivoTemplate {

    protected PilotoService pilotoService;

    public LeitorArquivoTemplate(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }

    // Método Template (não muda)
    public final void lerPilotos(MultipartFile file) throws IOException {
        List<String[]> linhas = extrairLinhas(file);
        for (String[] dados : linhas) {
            Piloto piloto = mapearParaPiloto(dados);
            pilotoService.addPiloto(piloto);
        }
    }

    // Métodos que variam e serão implementados por subclasses
    protected abstract List<String[]> extrairLinhas(MultipartFile file) throws IOException;
    protected abstract Piloto mapearParaPiloto(String[] dados);
}
