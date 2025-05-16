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
        livro.setEmprestado(true);

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
            System.out.println("Titulo");
            String titulo = ler.nextLine();
            if (titulo.isEmpty()){
                break;
            }
            System.out.println("AUtor");
            String autor = ler.nextLine();

            System.out.println("Numero De Paginas");
            int numeroDePaginas = ler.nextInt();
            ler.nextLine();

            System.out.println("ISBN");
            String isbn = ler.nextLine();

            livrosEmprestados.add(new Livro(titulo,autor,numeroDePaginas,isbn));
            livro.setEmprestado(true);

            System.out.println("DIA");
            int dia = ler.nextInt();

            System.out.println("MES");
            int mes = ler.nextInt();

            System.out.println("Ano");
            int ano = ler.nextInt() - 1900;
            ler.nextLine();

            dataEmprestimo = new Date(ano,mes,dia);
            this.dataEmprestimo = formato.parse(formato.format(dataEmprestimo));
            listaDatas.add(dataEmprestimo);
   
        }
    }

    public void Devoluçao() {
        ler = new Scanner(System.in); 
        for (int i = 0; i < livrosEmprestados.size();i++){ //Mostrando os livros e as datas:
            System.out.println("Livro #" + (i + 1));
            System.out.println(livrosEmprestados.get(i));
            System.out.println("Data do Empréstimo: " + formato.format(listaDatas.get(i)));
            System.out.println("---------------------------");
        }
        if (livrosEmprestados.isEmpty()){ //verificando se a lista não esta vazia
            System.out.println("SEM NENHUMA PENDENCIA!");
        } else {

            int num = ler.nextInt(); //Numeros de livros devolvidos

            if (num > livrosEmprestados.size()){
                System.out.println("OCORREU UM ERRO!@NUMERO FORNECIDO ESTA FORA DO ESCOPO DA LISTA"
                +"\nTente novamente...\n");
            }
            for (int i = 1; i <= num; i++){
                if (num == livrosEmprestados.size()){  //se o numero passado coicidir com o tamanho do array, o array ficara vazio
                    livrosEmprestados.clear();
                    listaDatas.clear();
                    
                    for(int o = 0; o < num; o++){
                        livrosEmprestados.get(o).setEmprestado(false); //tirando os TRUEs dos atributos EMPRESTADO dos livos
                    }
                    break;
                }
                
                int remove = ler.nextInt() - 1; //index do livro que sera devolvido

                livrosEmprestados.remove(remove);
                listaDatas.remove(remove);
                livrosEmprestados.get(i).setEmprestado(false);

                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            }
        }
    }

    public void  MotrarDados(){
        for (int i = 0; i < livrosEmprestados.size();i++){
        System.out.println("Livro #" + (i + 1));
        System.out.println(livrosEmprestados.get(i));
        System.out.println("Data do Empréstimo: " + formato.format(listaDatas.get(i)));
        System.out.println("---------------------------");
        }
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