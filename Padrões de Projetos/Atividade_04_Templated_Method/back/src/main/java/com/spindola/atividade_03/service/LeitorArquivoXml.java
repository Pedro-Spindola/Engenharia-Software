package com.spindola.atividade_03.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.spindola.atividade_03.model.Piloto;

public class LeitorArquivoXml extends LeitorArquivoTemplate {

    public LeitorArquivoXml(PilotoService pilotoService) {
        super(pilotoService);
    }

    @Override
    protected List<String[]> extrairLinhas(MultipartFile file) throws IOException {
        List<String[]> linhas = new ArrayList<>();
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(file.getInputStream());
            NodeList pilotos = doc.getElementsByTagName("Piloto");

            for (int i = 0; i < pilotos.getLength(); i++) {
                Element p = (Element) pilotos.item(i);
                linhas.add(new String[]{
                    p.getElementsByTagName("Numero").item(0).getTextContent(),
                    p.getElementsByTagName("Nome").item(0).getTextContent(),
                    p.getElementsByTagName("Nacionalidade").item(0).getTextContent(),
                    p.getElementsByTagName("Idade").item(0).getTextContent(),
                    p.getElementsByTagName("Equipe").item(0).getTextContent(),
                    p.getElementsByTagName("Motor").item(0).getTextContent(),
                    p.getElementsByTagName("Pontos").item(0).getTextContent()
                });
            }
        } catch (Exception e) {
            throw new IOException("Erro ao ler XML", e);
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

