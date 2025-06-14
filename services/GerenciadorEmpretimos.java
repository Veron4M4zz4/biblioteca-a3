package services;

import models.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.List;

public class GerenciadorEmpretimos {
    private Scanner ler;
    private List<Livro> livrosEmprestados;
    private Iterator<Livro> listaLivros;
    private Usuario usuario;
    private Livro livro;
    private static GerenciadorEmpretimos instancia;
    

    private GerenciadorEmpretimos(Usuario usuario, Livro livro) {
        livrosEmprestados = new ArrayList<Livro>();

        this.usuario = usuario;
        this.livro = livro;
        livro.setEmprestado(true);
        
        livrosEmprestados.add(livro);
    }



   
    public static GerenciadorEmpretimos getInstancia(Usuario usuario, Livro livro) throws ParseException {
    if (instancia == null) {
       instancia = new GerenciadorEmpretimos(usuario, livro);
    }
    return instancia;
}

    public void AdicionarEmprestimo() {
        ler = new Scanner(System.in);
        while (true) {
            System.out.print("Titulo (vazio para sair): ");
            String titulo = ler.nextLine();
            if (titulo.isEmpty()) {
                break;
            }
            System.out.print("Autor: ");
            String autor = ler.nextLine();

            
            int numeroDePaginas;
            while (true) { 
                System.out.print("Número de Páginas: ");
                try{
                    numeroDePaginas = ler.nextInt();
                    ler.nextLine();
                    break;
                }catch(InputMismatchException e){
                    System.out.println("ERRO!! Por favor, digite um número inteiro válido.");
                    ler.nextLine();
                }

            }
            System.out.print("ISBN: ");
            String isbn = ler.nextLine();

            Livro novoLivro = new Livro(titulo, autor, numeroDePaginas, isbn);
            novoLivro.setEmprestado(true);
            livrosEmprestados.add(novoLivro);
        }
    }

        public void Devolucao() {
            ler = new Scanner(System.in);

            if (livrosEmprestados.isEmpty()) {
                System.out.println("Sem nenhuma pendência!");
                return;
            }

          
            System.out.println("Livros emprestados:");
            for (int i = 0; i < livrosEmprestados.size(); i++) {
                System.out.println((i + 1) + " - " + livrosEmprestados.get(i).getTitulo());
            }

            System.out.print("Quantos livros deseja devolver? ");
            int num = ler.nextInt();
            ler.nextLine();  

            while (num < 1 || num > livrosEmprestados.size()) {
                System.out.println("Número inválido! Tente novamente.");
                System.out.print("Quantos livros deseja devolver? ");
                num = ler.nextInt();
            }

            List<Integer> indicesParaRemover = new ArrayList<>();

            for (int devolucao = 1; devolucao <= num; devolucao++) {
                System.out.print("Escolha o nº do livro para devolver: ");
                int escolha = ler.nextInt();
                ler.nextLine();     

                while (escolha < 1 || escolha > livrosEmprestados.size() || indicesParaRemover.contains(escolha - 1)) {
                    System.out.print("Número inválido ou já escolhido. Digite outro nº: ");
                    escolha = ler.nextInt();
                }
                indicesParaRemover.add(escolha - 1);
            }

           
            indicesParaRemover.sort(Collections.reverseOrder());
            for (int idx : indicesParaRemover) {
                livrosEmprestados.get(idx).setEmprestado(false);
                livrosEmprestados.remove(idx);
                System.out.println("Livro devolvido com sucesso!");
            }
        }


    public void MostrarDados() {
        for (int i = 0; i < livrosEmprestados.size(); i++) {
            System.out.println("Livro #" + (i + 1));
            System.out.println(livrosEmprestados.get(i));
            System.out.println("---------------------------");
        }
    }
public void setLivrosEmprestados(List<Livro> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    public Iterator<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(Iterator<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }

    public Scanner getLer() {
        return ler;
    }

    public void setLer(Scanner ler) {
        this.ler = ler;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public static GerenciadorEmpretimos getInstancia() {
        return instancia;
    }

    public static void setInstancia(GerenciadorEmpretimos instancia) {
        GerenciadorEmpretimos.instancia = instancia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GerenciadorEmprestimos{");
        sb.append("livrosEmprestados=").append(livrosEmprestados);
        sb.append(", listaLivros=").append(listaLivros);
        sb.append(", ler=").append(ler);
        sb.append(", usuario=").append(usuario);
        sb.append(", livro=").append(livro);
        sb.append('}');
        return sb.toString();
    }
}