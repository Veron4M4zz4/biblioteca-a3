package models;

public class Aluno extends Usuario { 
    private string matricula;

    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula; 
        
        
    }
    public String getMatricula() { 
        return matricula;
    } 
    public void setMatricula(String matricula) {
        this.matricula = matricula; 
    }

    @Override
    public void exibirDados() { 
        System.out.println("Aluno: " + nome + " | CPF: " + cpf + " | Matricula; " + matricula);
    }
}