package models;

public class Livro {
    protected String titulo;
    private String autor;
    private String isbn;
    private int numeroDePaginas;
    private boolean emprestado;

    

    public Livro() {
        this("Título Desconhecido","Autor Desconhecido", 0,"ISBN Desconhecido");
    }

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public Livro(String titulo, String autor, int numeroDePaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
    }

    public Livro(String titulo, String autor, int numeroDePaginas, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        setIsbn(isbn);
        this.numeroDePaginas = numeroDePaginas;
    }

    public void emprestar(){
        this.emprestado = true;
        System.out.println("livro "+this.titulo+" emprestado.");
    }
    public void devolver(){
        this.emprestado = false;
        System.out.println("livro "+this.titulo+" devolvido.");
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
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        if (isbn != null && isbn.length() == 13){
            this.isbn = isbn;
        } else {
            System.out.println("ISBN inválido. Deve ter 13 caracteres");
        }
        
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", numeroDePaginas="
                + numeroDePaginas + ", emprestado=" + emprestado + "]";
    }


    
}