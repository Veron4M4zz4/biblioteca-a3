package models;

public class Aluno extends Usuario { 
    private String matricula;

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
    public String exibirDados() { 
        return "Aluno: " + nome + " | CPF: " + cpf + " | Matricula: " + matricula;
    }

    @Override
    public double taxaMulta(int diasAtraso){
        return diasAtraso * 0.5;
    }
}