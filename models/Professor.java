package models;

public class Professor extends Usuario {
    private String departamento; //tratado

    public Professor(String nome, String cpf, String email, String telefone, String matricula, String tipo, String departamento, String titulacao) {
        super(nome, cpf, email, telefone, tipo);
        setDepartamento(departamento);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        //verifica se o departamento e nulo
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