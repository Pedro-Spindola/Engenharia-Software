package com.spindola.repository;

import java.util.List;
import java.util.Optional;

import com.spindola.model.Livro;

public interface ILivroRepository {
    Livro salvar(Livro livro);
    List<Livro> listarTodos();
    Optional<Livro> buscarPorId(int id);
    Optional<Livro> buscarPorIsbn(String isbn);
    boolean atualizar(Livro livro);
    boolean deletar(int id);
    int contar();

    /*
     * 
     *
     */
}
