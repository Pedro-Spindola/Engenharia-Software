package com.spindola.cs_prova_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spindola.cs_prova_01.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;
}
