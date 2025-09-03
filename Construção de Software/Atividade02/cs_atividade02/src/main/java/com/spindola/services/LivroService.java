package com.spindola.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.spindola.model.Livro;
import com.spindola.repository.ILivroRepository;

public class LivroService {
    private final ILivroRepository repository;

    public LivroService(ILivroRepository repository){
        this.repository = repository;
    }

    public Livro cadastrarLivro(String titulo, String autor, String isbn, LocalDate anoPublicacao){
        try {
            // Validar os dados aqui.
            Livro novoLivro = new Livro(titulo, autor, isbn, anoPublicacao);
            return repository.salvar(novoLivro);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar livro: " + e.getMessage(), e);
        }
    }

    public List<Livro> listarLivro(){
        List<Livro> livros = repository.listarTodos();
        return livros;
    }

    public Livro buscaLivroPorId(int id){
        return repository.buscarPorId(id)
        .orElseThrow(() -> new RuntimeException("Livro não encontrado pelo ID fornecido: " + id));
    }

    public boolean removerLivro(int id){
        if(!repository.buscarPorId(id).isPresent()){
            throw new RuntimeException("Não existe livro com o id fornecido: " + id);
        }
        return repository.deletar(id);
    }

    public boolean atualizarLivro(int id, String titulo, String autor, String isbn, LocalDate anoPublicacao){
        Optional<Livro> livroSelect = repository.buscarPorId(id);
        if(livroSelect.isEmpty()){
            throw new RuntimeException("Livro não encontrado pelo id: " + id);
        }
        Livro livroAtualizado = livroSelect.get();
        livroAtualizado.setTitulo(titulo);
        livroAtualizado.setAutor(autor);
        livroAtualizado.setIsbn(isbn);
        livroAtualizado.setAnoPublicacao(anoPublicacao);

        return repository.atualizar(livroAtualizado);
    }

    public boolean marcarComoDisponivel(int id){
        Optional<Livro> livroSelect = repository.buscarPorId(id);
        if(livroSelect.isEmpty()){
            throw new RuntimeException("Livro não encontrado pelo id: " + id);
        }
        Livro livroAtualizado = livroSelect.get();
        livroAtualizado.setStatus(true);

        return repository.atualizar(livroAtualizado);
    }
    
    public boolean marcarComoIndisponivel(int id){
        Optional<Livro> livroSelect = repository.buscarPorId(id);
        if(livroSelect.isEmpty()){
            throw new RuntimeException("Livro não encontrado pelo id: " + id);
        }
        Livro livroAtualizado = livroSelect.get();
        livroAtualizado.setStatus(false);

        return repository.atualizar(livroAtualizado);
    }
}
