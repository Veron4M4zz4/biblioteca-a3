package models;

import java.util.Scanner;

public class Professor extends Usuario {
    private String departamento;

/*     public Professor(String nome, String cpf, String email, String telefone, String matricula, String tipo, String departamento, String titulacao) {
        super(nome, cpf, email, telefone, tipo);
        setDepartamento(departamento);
    }
*/
    public Professor(){
        System.out.println("tchau");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome:");
        setNome(sc.nextLine());
        System.out.println("CPF:");
        setCpf(sc.nextLine());
        System.out.println("Email:");
        setEmail(sc.nextLine());
        System.out.println("Telefone:");
        setTelefone(sc.nextLine());
        setTipo("Professor");
        this.departamento = sc.nextLine();

        setBloqueado(false);
    }
    

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não pode ser nulo.");
        }

        // Verifica se só há letras, espaços e até 3 números — sem caracteres especiais
        if (!departamento.matches("^[A-Za-zÀ-ÿ\\s\\d]+$")) {
            throw new IllegalArgumentException("Departamento inválido. Apenas letras e até 3 números são permitidos, sem caracteres especiais.");
        }

        // Verifica se não há mais de 3 números
        long quantidadeNumeros = departamento.chars().filter(Character::isDigit).count();
        if (quantidadeNumeros > 3) {
            throw new IllegalArgumentException("Departamento inválido. Pode conter no máximo 3 números.");
        }

        this.departamento = departamento;
    }

    @Override
    public String exibirDados() {
        return "Professor: " + nome + " | CPF: " + cpf + " | Departamento: " + departamento;
    }

    @Override
    public double taxaMulta(int diasAtraso) {
        return diasAtraso * 0;
    }
}