package models;

import java.util.regex.Pattern;
import java.util.Date;
import java.util.Scanner;
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
        Scanner sc = new Scanner(System.in);
        System.out.println("titulo:");
        setTitulo(sc.nextLine());
        System.out.println("Autor:");
        setAutor(sc.nextLine());
        System.out.println("Numero de Paginas");
        setNumeroDePaginas(sc.nextInt());
        sc.nextLine();
        System.out.println("ISBN:");
        setIsbn(sc.nextLine());

        this.dataCriacao = new Date(); 
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataCriacao);
        cal.add(Calendar.DAY_OF_MONTH, 14);
        this.dataDevolucao = cal.getTime();
        System.out.println("Livro criado em: " + sdf.format(this.dataCriacao));
        System.out.println("Data Prevista para Devolução: " + sdf.format(this.dataDevolucao));
    }

    public Livro(String titulo, String autor) {
        setTitulo(titulo);
        setAutor(autor);
        this.dataCriacao = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataCriacao);
        cal.add(Calendar.DAY_OF_MONTH, 14);
        this.dataDevolucao = cal.getTime();
        System.out.println("Livro criado em: " + sdf.format(this.dataCriacao));
        System.out.println("Data Prevista para Devolução: " + sdf.format(this.dataDevolucao));
    }

    public Livro(String titulo, String autor, int numeroDePaginas) {
        Scanner sc = new Scanner(System.in);
        setTitulo(titulo);
        setAutor(autor);
        setNumeroDePaginas(numeroDePaginas);
        this.dataCriacao = new Date();// 
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataCriacao);
        cal.add(Calendar.DAY_OF_MONTH, 14);
        this.dataDevolucao = cal.getTime();
        System.out.println("Livro criado em: " + sdf.format(this.dataCriacao));
        System.out.println("Data Prevista para Devolução: " + sdf.format(this.dataDevolucao));
    }

    public Livro(String titulo, String autor, int numeroDePaginas, String isbn) {
        setTitulo(titulo);
        setAutor(autor);
        setNumeroDePaginas(numeroDePaginas);
        setIsbn(isbn);
        this.dataCriacao = new Date();// 
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataCriacao);
        cal.add(Calendar.DAY_OF_MONTH, 14);
        this.dataDevolucao = cal.getTime();
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

    //tratamento de string 
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) { //trim corta espaço, isEmpty
            throw new IllegalArgumentException("Título não pode ser nulo ou vazio.");
        }
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor não pode ser nulo ou vazio.");
        }   //se for diferente da sintaxe 
        /*if (!Pattern.matches("^[A-Za-zÀ-ÿ\\\\s.'-]+$", autor)) {
            throw new IllegalArgumentException("Autor inválido. Deve conter apenas letras e espaços, sem números ou caracteres especiais.");
        }*/
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || !isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException("ISBN inválido. Deve conter exatamente 13 dígitos numéricos.");
        }
        this.isbn = isbn;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        /*if (numeroDePaginas <= 0) { //menor ou igual a zero
            throw new IllegalArgumentException("Número de páginas deve ser maior que zero.");
        }*/
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