package models;

import java.util.Scanner;

public class Usuario {
    protected String nome; //tratado
    protected String cpf; //tratado
    protected String email; //tratado
    protected String telefone; //tratado
    protected String tipo;
    protected int limiteDeLivros;
    private boolean bloqueado = true;

    public Usuario(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public Usuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome:");
        setNome(sc.nextLine());
        System.out.println("CPF:");
        setCpf(sc.nextLine());
        System.out.println("Email:");
        setEmail(sc.nextLine());
        System.out.println("Telefone:");
        setTelefone(sc.nextLine());
        System.out.println("Professor ou Estudante?");
        this.tipo = sc.nextLine().toLowerCase(); //para letra caixa baixa, ou seja tudo minusculo

        if(tipo.equalsIgnoreCase("Estudante")){
            this.limiteDeLivros = 3;
        } else if (tipo.equalsIgnoreCase("Professor")){
            this.limiteDeLivros = 5;
        } else {
            this.limiteDeLivros = 0;
        }

        this.bloqueado = false;
    }

    public Usuario(String nome, String cpf, String email, String telefone, String tipo) {
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
        setTelefone(telefone);
        this.tipo = tipo.toLowerCase(); //para letra caixa baixa, ou seja tudo minusculo

        if(tipo.equalsIgnoreCase("Estudante")){
            this.limiteDeLivros = 3;
        } else if (tipo.equalsIgnoreCase("Professor")){
            this.limiteDeLivros = 5;
        } else {
            this.limiteDeLivros = 0;
        }

        this.bloqueado = false;
    }

    public String exibirDados() {
        if (!bloqueado) {
            return "O(A) " + nome + " (" + tipo + ") está com status DESBLOQUEADO e pode pegar: " + limiteDeLivros;
        } else {
            return "O(A) " + nome + " está com status BLOQUEADO";
        }
    }

    public double taxaMulta(int diasAtraso) {
        return diasAtraso * 1.0; 
    }

    public String getNome() {
        return nome;
    }
     //verifica se o nome e nulo e se contem apenas letras
    public void setNome(String nome) {
        /*if (nome == null || !Pattern.matches("^[A-Za-zÀ-ÿ\\s]+$", nome.trim())) {
            throw new IllegalArgumentException("Nome inválido. Deve conter apenas letras e não pode ser nulo.");
        }*/
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
     //verifica se o email contem @
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Email inválido. Deve conter '@'.");
        }
    }

    public String getTelefone() {
        return telefone;
    }
    //verifica se o telefone e nulo e verifica que so pode conter 12 numeros
    public void setTelefone(String telefone) {
        if (telefone == null || !telefone.matches("\\d{12}")) {
            throw new IllegalArgumentException("Telefone inválido. Deve conter exatamente 12 dígitos numéricos.");
        }
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLimiteDeLivros() {
        return limiteDeLivros;
    }

    public void setLimiteDeLivros(int limiteDeLivros) {
        this.limiteDeLivros = limiteDeLivros;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getCpf() {
        return cpf;
    }
    //verifica se o cpf e nulo e verifica que so pode conter 11 numeros
    public void setCpf(String cpf) {
        /*if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido. Deve conter exatamente 11 dígitos numéricos.");
        }*/
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone
                + ", tipo=" + tipo + ", limiteDeLivros=" + limiteDeLivros + ", bloqueado=" + bloqueado + "]";
    }
}