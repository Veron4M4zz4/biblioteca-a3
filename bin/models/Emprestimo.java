package bin.models;

public class Emprestimo {
    private int id;
    private String cpfUsuario;
    private int idLivro;
    private String dataEmprestimo;
    private String dataDevolucao;
    private String status;

    public Emprestimo(int id, String cpfUsuario, int idLivro, String dataEmprestimo, String dataDevolucao, String status) {
        this.id = id;
        this.cpfUsuario = cpfUsuario;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    public int getId() { return id; }
    public String getCpfUsuario() { return cpfUsuario; }
    public int getIdLivro() { return idLivro; }
    public String getDataEmprestimo() { return dataEmprestimo; }
    public String getDataDevolucao() { return dataDevolucao; }
    public String getStatus() { return status; }
}
