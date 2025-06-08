package models;

import java.util.regex.Pattern;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Livro {
    protected String titulo; //tratado
    private String autor; //tratado
    private String isbn; //tratado 
    private int numeroDePaginas; //tratado
    private boolean emprestado;
    private Date dataCriacao;
    private Date dataDevolucao;
    private static final SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy");

    public Livro() {
        this("Título Desconhecido", "Autor Desconhecido", 0, "0000000000000");
    }

    public Livro(String titulo, String autor) {
        setTitulo(titulo);
        setAutor(autor);
    }

    public Livro(String titulo, String autor, int numeroDePaginas) {
        setTitulo(titulo);
        setAutor(autor);
        setNumeroDePaginas(numeroDePaginas);
    }

    public Livro(String titulo, String autor, int numeroDePaginas, String isbn) {
        setTitulo(titulo);
        setAutor(autor);
        setNumeroDePaginas(numeroDePaginas);
        setIsbn(isbn);
        this.dataCriacao = new Date();// 
        Calender cal = Calender.getInstance();
        cal.setTime(dataCriacao);
        cal.add(Calendar.DAY_OF_MONTH, 14);
        this.dataDevolucao = cal.getTIME();
        System.out.println("Livro criado em: " + sdf.format(this.dataCriacao));
        System.out.println("Data Prevista para Devolução: " + sdf.format(this.dataDevolucao));
        

        


    }

    public void emprestar() {
        this.emprestado = true;
        System.out.println("Livro \"" + this.titulo + "\" emprestado.");
    }

    public void devolver() {
        this.emprestado = false;
        System.out.println("Livro \"" + this.titulo + "\" devolvido.");
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser nulo ou vazio.");
        }
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor não pode ser nulo ou vazio.");
        }
        if (!Pattern.matches("^[A-Za-zÀ-ÿ\\s]+$", autor)) {
            throw new IllegalArgumentException("Autor inválido. Deve conter apenas letras e espaços, sem números ou caracteres especiais.");
        }
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || !isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException("ISBN inválido. Deve conter exatamente 13 dígitos numéricos.");
        }
        this.isbn = isbn;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        if (numeroDePaginas <= 0) {
            throw new IllegalArgumentException("Número de páginas deve ser maior que zero.");
        }
        this.numeroDePaginas = numeroDePaginas;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn
                + ", numeroDePaginas=" + numeroDePaginas + ", emprestado=" + emprestado + "]";
    }
}