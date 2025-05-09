package services;
import models.*;
import java.util.Date;
public class GerenciadorEmprestimos{
    private Date dataEmprestimo;
    private Usuario usuario;
    private Livro livro;

    public GerenciadorEmprestimos(Usuario usuario, Date dataEmprestimo,Livro livro) {
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this. livro = livro;

    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    @Override
    public String toString() {
        return "GetenciadorEmprestimos [dataEmprestimo=" + dataEmprestimo + ", usuario=" + usuario + ", livro=" + livro
                + "]";
    }

    
}