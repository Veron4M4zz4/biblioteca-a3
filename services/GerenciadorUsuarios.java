package services;

import dao.DataBaseHelper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import models.*;

public class GerenciadorUsuarios {
    private List<Usuario> nomes;
    private Iterator<Usuario> listaNomes;
    private Scanner leitor;
    private static GerenciadorUsuarios instancia;


    private GerenciadorUsuarios() {
        nomes = new ArrayList<Usuario>();
        leitor = new Scanner(System.in);
        System.out.println("SE QUISER PARAR DIGITE -1 NO NOME.");

        while (true) {
            String aux_cpf;
            String aux_email;
            String aux_telefone;
            String aux_tipo;
            System.out.println("----------------------------------");

            System.out.println("nome: ");
            String aux_nome = leitor.nextLine();
            if (aux_nome ==  "-1") {
                break;
            }
            while (true) { 
                System.out.println("cpf: ");
                aux_cpf = leitor.nextLine();
                if(aux_cpf.length() == 11){
                    break;
                }
                else {
                    System.out.println("CPF inválido! Deve ter 11 dígitos.");
                }
            }

            while (true) { 
                System.out.println("email: ");
                aux_email = leitor.nextLine();
                if(aux_email.contains("@")){
                    break;
                }
                else {
                    System.out.println("Email inválido! Deve conter '@'.");
                }
            }


            while (true) { 
                System.out.println("telefone: ");
                aux_telefone = leitor.nextLine();
                if(aux_telefone.length() == 12){
                    break;
                }
                else {
                    System.out.println("Telefone inválido! Deve ter 12 dígitos.");
                }
            }
            while (true) { 
                System.out.println("1 - Aluno\n2 - Professor\ntipo: ");
                int opcao = leitor.nextInt();
                leitor.nextLine();
                    if (opcao == 1) {
                        aux_tipo = "Aluno";
                        break;
                    } else if (opcao == 2) {
                        aux_tipo = "Professor";
                        break;
                    } else {
                        System.out.println("Opção inválida! Digite 1 para Aluno ou 2 para Professor.");
                        opcao = leitor.nextInt();
                    }
                }
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

        UsuariosCadastrados();

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

                UsuariosCadastrados();

            }
        }
    }

    public void AdicionarUsuario() {
        while (true) {
            String aux_cpf;
            String aux_email;
            String aux_telefone;
            String aux_tipo;
            System.out.println("SE QUISER PARAR DEIXE NOME VAZIO.");
            System.out.println("----------------------------------");
            System.out.println("nome: ");
            String aux_nome = leitor.nextLine();
            leitor.nextLine();
            if (aux_nome.isEmpty()) {
                break;
            }

            while (true) { 
                System.out.println("cpf: ");
                aux_cpf = leitor.nextLine();
                if(aux_cpf.length() == 11){
                    break;
                }
                else {
                    System.out.println("CPF inválido! Deve ter 11 dígitos.");
                }
            }

            while (true) { 
                System.out.println("email: ");
                aux_email = leitor.nextLine();
                if(aux_email.contains("@")){
                    break;
                }
                else {
                    System.out.println("Email inválido! Deve conter '@'.");
                }
            }


            while (true) { 
                System.out.println("telefone: ");
                aux_telefone = leitor.nextLine();
                if(aux_telefone.length() == 12){
                    break;
                }
                else {
                    System.out.println("Telefone inválido! Deve ter 12 dígitos.");
                }
            }

            while (true) { 
                System.out.println("1 - Aluno\n2 - Professor\ntipo: ");
                System.out.println();
                int opcao = leitor.nextInt();
                leitor.nextLine();
                if (opcao == 1) {
                    aux_tipo = "Aluno";
                    break;
                } else if (opcao == 2) {
                    aux_tipo = "Professor";
                    break;
                } else {
                    System.out.println("Opção inválida! Digite 1 para Aluno ou 2 para Professor.");
                    opcao = leitor.nextInt();
                }
            }
            

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

    public void SalvarUsuarioNoBanco() throws SQLException {
        DataBaseHelper databaseHelper = new DataBaseHelper();
        databaseHelper.CriarTabelaUsuario();
        for(Usuario usuario: nomes){
            databaseHelper.AdicionarUsuario(usuario);
        }
        System.out.println("Usuario adicionado com sucesso!");
        
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