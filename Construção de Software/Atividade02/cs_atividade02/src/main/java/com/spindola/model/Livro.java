package com.spindola.model;

import java.time.LocalDate;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private LocalDate anoPublicacao;
    private boolean status;
    private static int contadorId = 1;

    public Livro(String titulo, String autor, String isbn, LocalDate anoPublicacao) {
        this.id = contadorId++;
        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
        setAnoPublicacao(anoPublicacao);
        this.status = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(titulo == null || titulo.trim().length() <= 3){
            throw new IllegalArgumentException("Titulo deve ter pelo menos 3 caracteres");
        }
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if(autor == null || autor.trim().length() <= 3){
            throw new IllegalArgumentException("Autor deve ter pelo menos 3 caracteres");
        }
        this.autor = autor;
    }

    public String getIsbn() {
        return formatarISBN(isbn);
    }

    public void setIsbn(String isbn) {
        if(isbn == null || isbn.replaceAll("[^0-9]", "").length() != 13){
            throw new IllegalArgumentException("ISBN deve ter exatos 13 caracteres");
        }
        this.isbn = isbn;
    }

    public LocalDate getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(LocalDate anoPublicacao) {
        if(anoPublicacao.getYear() < 1500 || anoPublicacao.getYear() > 2025){
            throw new IllegalArgumentException("Ano de publicação invalido, deve ser entre 1500 a 2025");
        }
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private String formatarISBN(String isbn){
        return isbn.replaceAll("(\\d{3})(\\d{1})(\\d{4})(\\d{4})(\\d{1})", "$1-$2-$3-$4-$5");
    }

    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + formatarISBN(isbn) + ", anoPublicacao="
                + anoPublicacao.getYear() + ", status=" + status + "]";
    }
}
