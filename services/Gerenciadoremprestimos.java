package services;
import models.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorEmprestimos{
    private ArrayList<Livro> livrosEmprestados;
    private ArrayList<Date> listaDatas;
    private Scanner ler;
    private Date dataEmprestimo;
    private SimpleDateFormat formato;
    private Usuario usuario;
    private Livro livro;
    private static GerenciadorEmprestimos instancia;
    
    private GerenciadorEmprestimos(Usuario usuario, Livro livro, Date dataEmprestimo) throws ParseException {
        formato = new SimpleDateFormat("dd/MM/yyyy");
        livrosEmprestados = new ArrayList<Livro>();
        listaDatas = new ArrayList<Date>();

        this.dataEmprestimo = formato.parse(formato.format(dataEmprestimo));
        this.usuario = usuario;
        this. livro = livro;
        livrosEmprestados.add(livro);
        listaDatas.add(dataEmprestimo);
    }

    public static GerenciadorEmprestimos getInstancia(Usuario usuario,Livro livro,Date dataEmprestimo) throws ParseException{
        if (instancia == null){
            instancia = new GerenciadorEmprestimos(usuario, livro, dataEmprestimo);
        }
        return instancia;
        
    }
    public void AdicionarEmprestimo() throws ParseException{
        ler = new Scanner(System.in);
        formato = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            String titulo = ler.nextLine();

            String autor = ler.nextLine();
            int numeroDePaginas = ler.nextInt();
            String isbn = ler.nextLine();
            livrosEmprestados.add(new Livro(titulo,autor,numeroDePaginas,isbn));

            int dia = ler.nextInt();
            int mes = ler.nextInt();
            int ano = ler.nextInt() - 1900;

            dataEmprestimo = new Date(ano,mes,dia);
            this.dataEmprestimo = formato.parse(formato.format(dataEmprestimo));
            listaDatas.add(dataEmprestimo);
   
        }
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