package com.spindola;

import com.spindola.controller.LivroController;
import com.spindola.repository.ILivroRepository;
import com.spindola.repository.LivroRepositoryMemoria;
import com.spindola.services.LivroService;

public class Main {
    public static void main(String[] args) {
        ILivroRepository repository = new LivroRepositoryMemoria();
        LivroService service = new LivroService(repository);
        LivroController controller = new LivroController(service);

        controller.executar();
    }
}