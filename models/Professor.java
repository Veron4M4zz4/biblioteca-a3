package models;

public class Professor extends Usuario{
    private String departamento;

    public Professor (String nome, String cpf,String email, String telefone, String matricula, String tipo,String departamento, String titulacao){
        super(nome,cpf,email,telefone,tipo);
        this.departamento = departamento;

        
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    @Override
    public String exibirDados() { 
        return "Professor: " + nome + " | CPF: " + cpf + " | Departamento: " + departamento;
    }

    @Override
    public double taxaMulta(int diasAtraso){
        return diasAtraso * 0;
    }
}
