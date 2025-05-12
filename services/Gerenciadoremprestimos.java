package services;
import models.*;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class GerenciadorEmprestimos{
    private Date dataEmprestimo;
    private SimpleDateFormat 
    private Usuario usuario;
    private Livro livro;
    private Scanner ler;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    

    public GerenciadorEmprestimos(Usuario usuario, Date dataEmprestimo,Livro livro) {
        this.usuario = usuario;
        String dataFormato = 

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