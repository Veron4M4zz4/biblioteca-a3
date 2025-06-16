package services;

import models.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorLivros {
    private List<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(Scanner sc) {
        System.out.println("Cadastro de Livro:");
        String titulo, autor, isbn;
        int numPaginas;

        System.out.print("Título: ");
        titulo = sc.nextLine();

        System.out.print("Autor: ");
        autor = sc.nextLine();

        System.out.print("Número de Páginas: ");
        while (!sc.hasNextInt()) {
            System.out.println("Digite um número válido para páginas:");
            sc.next();
        }
        numPaginas = sc.nextInt();
        sc.nextLine();

        System.out.print("ISBN (13 dígitos): ");
        isbn = sc.nextLine();

        try {
            Livro l = new Livro(titulo, autor, numPaginas, isbn);
            livros.add(l);
            System.out.println("Livro cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar livro: " + e.getMessage());
        }
    }

    public void listarLivros() {
        if(livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        System.out.println("Lista de Livros:");
        for(Livro l : livros) {
            System.out.println(l);
        }
    }

    public Livro buscarLivroPorIsbn(String isbn) {
        for(Livro l : livros) {
            if(l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    public boolean removerLivro(String isbn) {
        for(Livro l : livros) {
            if(l.getIsbn().equals(isbn)) {
                livros.remove(l);
                System.out.println("Livro removido com sucesso.");
                return true;
            }
        }
        System.out.println("Livro não encontrado.");
        return false;
    }
}
