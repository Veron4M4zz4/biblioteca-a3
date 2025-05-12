package services;
import models.*;
import java.util.Scanner;
import java.util.ArrayList;
public class GerenciadorUsuarios {
    private static int qtdLivros=0;
    private ArrayList<Usuario> nomes;
    private Scanner leitor;
    
    public GerenciadorUsuarios(){
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

    public void UsuariosCadastrados(){
        for(Usuario usuarioCadastrado: nomes){
            System.out.println("usuario: "+ usuarioCadastrado);
        }
    }



    public static int getQtdLivros() {
        return qtdLivros;
    }
    public static void setQtdLivros(int qtdLivros) {
        GerenciadorUsuarios.qtdLivros = qtdLivros;
    }
    public ArrayList<Usuario> getNomes() {
        return nomes;
    }
    public void setNomes(ArrayList<Usuario> nomes) {
        this.nomes = nomes;
    }

    
    
}