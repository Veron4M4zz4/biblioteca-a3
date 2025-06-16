package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Usuario;

public class GerenciadorUsuarios {
    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(Scanner sc) {
        System.out.println("Cadastro de Usuário:");
        String nome, cpf, email, telefone, tipo;

        System.out.print("Nome: ");
        nome = sc.nextLine();

        System.out.print("CPF (11 dígitos): ");
        cpf = sc.nextLine();

        System.out.print("Email: ");
        email = sc.nextLine();

        System.out.print("Telefone (10 a 12 dígitos): ");
        telefone = sc.nextLine();

        System.out.print("Tipo (Estudante ou Professor): ");
        tipo = sc.nextLine();

        try {
            Usuario u = new Usuario(nome, cpf, email, telefone, tipo);
            usuarios.add(u);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public void listarUsuarios() {
        if(usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        System.out.println("Lista de Usuários:");
        for(Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    public boolean deletarUsuario(String cpf) {
        for(Usuario u : usuarios) {
            if(u.getCpf().equals(cpf)) {
                usuarios.remove(u);
                System.out.println("Usuário removido com sucesso.");
                return true;
            }
        }
        System.out.println("Usuário não encontrado.");
        return false;
    }

    public Usuario buscarUsuarioPorCpf(String cpf) {
        for(Usuario u : usuarios) {
            if(u.getCpf().equals(cpf)) {
                return u;
            }
        }
        return null;
    }
}
