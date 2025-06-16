package models;

import java.util.Scanner;

public class Usuario {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String tipo;
    private int limiteDeLivros;
    private boolean bloqueado = false;

    public Usuario(String nome, String cpf, String email, String telefone, String tipo) {
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
        setTelefone(telefone);
        setTipo(tipo);
        if(tipo.equalsIgnoreCase("estudante")) {
            limiteDeLivros = 3;
        } else if(tipo.equalsIgnoreCase("professor")) {
            limiteDeLivros = 5;
        } else {
            limiteDeLivros = 0;
        }
        bloqueado = false;
    }

    public Usuario() {}

    public String getNome() { return nome; }
    public void setNome(String nome) {
        while(nome == null || nome.trim().isEmpty() || !nome.matches("[A-Za-zÀ-ÿ\\s]+")) {
            System.out.println("Nome inválido. Digite novamente:");
            nome = new Scanner(System.in).nextLine();
        }
        this.nome = nome.trim();
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) {
        while(cpf == null || !cpf.matches("\\d{11}")) {
            System.out.println("CPF inválido. Deve ter 11 dígitos numéricos. Digite novamente:");
            cpf = new Scanner(System.in).nextLine();
        }
        this.cpf = cpf;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        while(email == null || !email.contains("@") || email.trim().isEmpty()) {
            System.out.println("Email inválido. Digite novamente:");
            email = new Scanner(System.in).nextLine();
        }
        this.email = email.trim();
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) {
        while(telefone == null || !telefone.matches("\\d{10,12}")) {
            System.out.println("Telefone inválido. Digite somente números (10 a 12 dígitos). Digite novamente:");
            telefone = new Scanner(System.in).nextLine();
        }
        this.telefone = telefone;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) {
        while(tipo == null || (!tipo.equalsIgnoreCase("estudante") && !tipo.equalsIgnoreCase("professor"))) {
            System.out.println("Tipo inválido. Digite 'Estudante' ou 'Professor':");
            tipo = new Scanner(System.in).nextLine();
        }
        this.tipo = tipo.toLowerCase();
    }

    public int getLimiteDeLivros() { return limiteDeLivros; }

    public boolean isBloqueado() { return bloqueado; }
    public void setBloqueado(boolean bloqueado) { this.bloqueado = bloqueado; }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Email: " + email + ", Telefone: " + telefone +
                ", Tipo: " + tipo + ", Limite de livros: " + limiteDeLivros + ", Bloqueado: " + bloqueado;
    }
}
