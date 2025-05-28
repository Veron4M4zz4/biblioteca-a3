package services;

import models.*;
import java.util.Scanner;

import dao.DataBaseHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GerenciadorUsuarios {
    private List<Usuario> nomes;
    private Iterator<Usuario> listaNomes;
    private Scanner leitor;
    private static GerenciadorUsuarios instancia;

    private GerenciadorUsuarios() {
        nomes = new ArrayList<Usuario>();
        leitor = new Scanner(System.in);
        System.out.println("SE QUISER PARAR DEIXE NOME VAZIO.");

        while (true) {
            System.out.println("----------------------------------");

            System.out.println("nome: ");
            String aux_nome = leitor.nextLine();
            if (aux_nome.isEmpty()) {
                break;
            }
            System.out.println("cpf: ");
            String aux_cpf = leitor.nextLine();

            System.out.println("email: ");
            String aux_email = leitor.nextLine();

            System.out.println("telefone: ");
            String aux_telefone = leitor.nextLine();

            System.out.println("tipo: ");
            String aux_tipo = leitor.nextLine();

            nomes.add(new Usuario(aux_nome, aux_cpf, aux_email, aux_telefone, aux_tipo));
        }
    }

    public static GerenciadorUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorUsuarios();
        }
        return instancia;
    }

    public void RemoverUsuario() {
        leitor = new Scanner(System.in);
        int numRemover = leitor.nextInt();

        for (int p = 0; p < nomes.size(); p++) {
            System.out.println("Usuario #" + (p + 1));
            System.out.println(nomes.get(p));
        }
        if (numRemover > nomes.size()) {
            System.out.println("ERRO!@ NUMERO INFORMADO É MAIOR QUE O ESCOPO NA LISTA DE USUARIOS!!!");
        } else {
            if (numRemover == nomes.size()) {
                nomes.clear();
                return;
            }
            for (int i = 1; i <= numRemover; i++) {
                System.out.println("-==-==-==-==-==-==-==-==-==-==-");

                int indexRemover = leitor.nextInt() - 1;
                leitor.nextLine();

                nomes.remove(indexRemover);

                System.out.println("-==-==-==-==-==-==-==-==-==-==-");
                for (int o = 0; o < nomes.size(); o++) {
                    System.out.println("Usuario #" + (o + 1));
                    System.out.println(nomes.get(o));
                }
            }
        }
    }

    public void AdicionarUsuario() {
        System.out.println("SE QUISER PARAR DEIXE NOME VAZIO.");
        while (true) {
            System.out.println("----------------------------------");
            System.out.println("nome: ");
            String aux_nome = leitor.nextLine();
            if (aux_nome.isEmpty()) {
                break;
            }
            System.out.println("cpf: ");
            String aux_cpf = leitor.nextLine();

            System.out.println("email: ");
            String aux_email = leitor.nextLine();

            System.out.println("telefone: ");
            String aux_telefone = leitor.nextLine();

            System.out.println("tipo: ");
            String aux_tipo = leitor.nextLine();

            nomes.add(new Usuario(aux_nome, aux_cpf, aux_email, aux_telefone, aux_tipo));
        }
    }

    public List<Usuario> RemoverUsuarioNome(String usuarioNome) {
        leitor = new Scanner(System.in);
        listaNomes = nomes.iterator();

        while (listaNomes.hasNext()) { // Usando iterator para percorrer a lista, evita que de o erro
                                       // IndexOutOfBoundsException
            Usuario analiseUsuario = listaNomes.next(); // pega os elemenotos do array e o percorre
            if (analiseUsuario.getNome().equals(usuarioNome)) {
                listaNomes.remove();
            }
        }
        return nomes;
    }

    public void SalvarUsuarioNoBanco() {
        DataBaseHelper databaseHelper = new DataBaseHelper();
        for (Usuario usuarios : nomes) {
            databaseHelper.adicionarUsuario(usuarios);
        }
        System.out.println("Todos usuarios salvos no banco de dados!");
    }

    public void UsuariosCadastrados() {
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println("Usuario #" + (i + 1));
            System.out.println(nomes.get(i));
        }
    }

    public int NumeroUsuarios() {
        return nomes.size();
    }

    @Override
    public String toString() {
        return "GerenciadorUsuarios [nomes=" + nomes + ", NumeroUsuarios()=" + NumeroUsuarios() + "]";
    }
}