package com.spindola.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spindola.model.Livro;

public class LivroRepositoryMemoria implements ILivroRepository {
    private Map<Integer, Livro> livros = new HashMap<>();

    @Override
    public List<Livro> listarTodos() {
        return new ArrayList<>(livros.values());
    }

    @Override
    public boolean atualizar(Livro livro) {
        if(livro == null || !livros.containsKey(livro.getId())){
            return false;
        }
        return true;
    }

    @Override
    public Livro salvar(Livro livro) {
        if(livro == null){
            throw new IllegalArgumentException("Livro não pode ser null");
        }
        if(buscarPorIsbn(livro.getIsbn()).isPresent()){
            throw new IllegalArgumentException("ISBN já cadastrado.");
        }
        livros.put(livro.getId(), livro);
        return livro;
    }

    @Override
    public boolean deletar(int id) {
        return livros.remove(id) != null;
    }

    @Override
    public int contar() {
        return livros.size();
    }

    @Override
    public Optional<Livro> buscarPorId(int id) {
        return Optional.ofNullable(livros.get(id));
    }

    @Override
    public Optional<Livro> buscarPorIsbn(String isbn) {
        return livros.values().stream()
        .filter(l -> l.getIsbn().equals(isbn.replaceAll("[^0-9]", "")))
        .findFirst();    
    }
}
