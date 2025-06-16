package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int numeroDePaginas;
    private boolean emprestado = false;
    private Date dataCriacao;
    private Date dataDevolucao;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Livro(String titulo, String autor, int numeroDePaginas, String isbn) {
        setTitulo(titulo);
        setAutor(autor);
        setNumeroDePaginas(numeroDePaginas);
        setIsbn(isbn);
        this.dataCriacao = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataCriacao);
        cal.add(Calendar.DAY_OF_MONTH, 14);
        this.dataDevolucao = cal.getTime();
    }

    public Livro() {}

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) {
        while(titulo == null || titulo.trim().isEmpty()) {
            System.out.println("Título inválido. Digite novamente:");
            titulo = new Scanner(System.in).nextLine();
        }
        this.titulo = titulo.trim();
    }

    public String getAutor() { return autor; }
    public void setAutor(String autor) {
        while(autor == null || autor.trim().isEmpty() || !autor.matches("[A-Za-zÀ-ÿ\\s]+")) {
            System.out.println("Autor inválido. Digite novamente:");
            autor = new Scanner(System.in).nextLine();
        }
        this.autor = autor.trim();
    }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) {
        while(isbn == null || !isbn.matches("\\d{13}")) {
            System.out.println("ISBN inválido. Deve conter 13 dígitos. Digite novamente:");
            isbn = new Scanner(System.in).nextLine();
        }
        this.isbn = isbn;
    }

    public int getNumeroDePaginas() { return numeroDePaginas; }
    public void setNumeroDePaginas(int numeroDePaginas) {
        while(numeroDePaginas <= 0) {
            System.out.println("Número de páginas inválido. Digite um número maior que zero:");
            numeroDePaginas = new Scanner(System.in).nextInt();
        }
        this.numeroDePaginas = numeroDePaginas;
    }

    public boolean isEmprestado() { return emprestado; }
    public void emprestar() { this.emprestado = true; }
    public void devolver() { this.emprestado = false; }

    public String getDataCriacao() { return sdf.format(dataCriacao); }
    public String getDataDevolucao() { return sdf.format(dataDevolucao); }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn +
                ", Páginas: " + numeroDePaginas + ", Emprestado: " + emprestado;
    }
}
