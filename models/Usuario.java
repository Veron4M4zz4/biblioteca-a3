package models;

public class Usuario {
    protected String nome;
    protected String cpf;
    protected String email;
    protected String telefone;
    protected String tipo;
    protected int limiteDeLivros;
    private boolean bloqueado = true;

    

    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario(String nome,String cpf, String email, String telefone, String tipo) {
        this.nome = nome;
        this.cpf = cpf;
        setEmail(email);
        this.telefone = telefone;
        this.tipo = tipo.toLowerCase();

        if(tipo.equalsIgnoreCase("Estudante")){
            this.limiteDeLivros = 3;
        } else if (tipo.equalsIgnoreCase("Professor")){
            this.limiteDeLivros = 5;
        } else {
            this.limiteDeLivros = 0;
        }

        this.bloqueado = false;

    }

    public String exibirDados(){
        if (bloqueado == false){
            return "O(A) "+nome+"( "+tipo+" )"+" Esta com status DESBLOQUEADO e pode pegar: "+limiteDeLivros;
        } else {
            return "O(A) "+nome+" Esta com status DESBLOQUEADO";
        }
    }
    public double taxaMulta(int diasAtraso){
        return diasAtraso * 1.0;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (email != null && email.contains("@")){
            this.email = email;
        } else {
            System.out.println("Email inválido. Deve conter '@'.");
        }
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone + ", tipo=" + tipo + ", limiteDeLivros=" + limiteDeLivros + ", bloqueado=" + bloqueado
                + "]";
    }

    
    
}
