package services;
import models.*;
import java.util.Scanner;
import java.util.ArrayList;
public class GerenciadorUsuarios {
    private static int qtdLivros=0;
    private ArrayList<Usuario> nomes;
    private Scanner leitor;
    private static GerenciadorUsuarios instancia;
    
    private GerenciadorUsuarios(){
        nomes = new ArrayList<>();
        leitor = new Scanner(System.in);
        System.out.println("SE QUISER PARAR DEIXE NOME VAZIO.");
        
        while(true){
            System.out.println("----------------------------------");
            System.out.println("nome: ");
            String aux_nome = leitor.nextLine();
            if (aux_nome.isEmpty()){
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
            nomes.add(new Usuario(aux_nome,aux_cpf,aux_email,aux_telefone,aux_tipo));
            qtdLivros ++;
        }   
    }


    public static GerenciadorUsuarios getInstancia(){
        if (instancia == null){
            instancia = new GerenciadorUsuarios();
        }
        return instancia;
    }

    public void UsuariosCadastrados(){
        for(Usuario usuarioCadastrado: nomes){
            System.out.println("usuario: "+ usuarioCadastrado);
        }
    }

    public void AdicionarUsuario(){
        System.out.println("SE QUISER PARAR DEIXE NOME VAZIO.");
        
        while(true){
            System.out.println("----------------------------------");
            System.out.println("nome: ");
            String aux_nome = leitor.nextLine();
            if (aux_nome.isEmpty()){
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
            nomes.add(new Usuario(aux_nome,aux_cpf,aux_email,aux_telefone,aux_tipo));
            qtdLivros ++;
        }   
    }
    }

    
    
