package models;

public class Aluno extends Usuario {
    private String matricula;

    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf);
        setMatricula(matricula);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula == null || !matricula.matches("\\d{12}")) {
            throw new IllegalArgumentException("Matrícula inválida. Deve conter exatamente 12 dígitos numéricos.");
        }
        this.matricula = matricula;
    }

    @Override
    public String exibirDados() {
        return "Aluno: " + nome + " | CPF: " + cpf + " | Matrícula: " + matricula;
    }

    @Override
    public double taxaMulta(int diasAtraso) {
        return diasAtraso * 0.5;
    }
}