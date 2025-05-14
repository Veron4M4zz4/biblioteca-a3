package services;
import models.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GerenciadorEmprestimos{
    private Date dataEmprestimo;
    private SimpleDateFormat formato;
    private Usuario usuario;
    private Livro livro;
    
    
    public GerenciadorEmprestimos(Usuario usuario, Livro livro, Date dataEmprestimo) throws ParseException {
        formato = new SimpleDateFormat("dd/MM/yyyy");

        this.dataEmprestimo = formato.parse(formato.format(dataEmprestimo));
        this.usuario = usuario;
        this. livro = livro;
    }

    public void  MotrarDados(){
        System.out.println(dataEmprestimo);
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