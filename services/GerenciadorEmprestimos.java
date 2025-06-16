package services;

import java.util.Scanner;
import models.Livro;
import models.Usuario;

public class GerenciadorEmprestimos {
    public void emprestarLivro(Scanner sc, GerenciadorUsuarios gu, GerenciadorLivros gl) {
        System.out.println("Empréstimo de Livro:");
        System.out.print("Digite CPF do usuário: ");
        String cpf = sc.nextLine();
        Usuario usuario = gu.buscarUsuarioPorCpf(cpf);
        if(usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        if(usuario.isBloqueado()) {
            System.out.println("Usuário bloqueado, não pode pegar livros.");
            return;
        }

        System.out.print("Digite ISBN do livro: ");
        String isbn = sc.nextLine();
        Livro livro = gl.buscarLivroPorIsbn(isbn);
        if(livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }
        if(livro.isEmprestado()) {
            System.out.println("Livro já está emprestado.");
            return;
        }

        livro.emprestar();
        System.out.println("Livro emprestado com sucesso!");
    }

    public void devolverLivro(Scanner sc, GerenciadorLivros gl) {
        System.out.println("Devolução de Livro:");
        System.out.print("Digite ISBN do livro: ");
        String isbn = sc.nextLine();
        Livro livro = gl.buscarLivroPorIsbn(isbn);
        if(livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }
        if(!livro.isEmprestado()) {
            System.out.println("Livro não está emprestado.");
            return;
        }
        livro.devolver();
        System.out.println("Livro devolvido com sucesso!");
    }
}

