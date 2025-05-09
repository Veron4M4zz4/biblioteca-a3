package services;
import models.*;
import java.util.Scanner;
import java.util.ArrayList;
public class GerenciadorUsuarios {
    private static int qtdLivros=0;
    
    Scanner leitor = new Scanner(System.in);
    ArrayList<Usuario> nomes = new ArrayList<>();

    public GerenciadorUsuarios(){
        //"i"Ler quantos livros seram adicionados ao ArrayList de usuario
        int i = leitor.nextInt();
        for(int cont = 0 ; cont < i; cont++){
            nomes.add(new Usuario(leitor.nextLine(),leitor.nextLine(),leitor.nextLine(),leitor.nextLine(),leitor.nextLine()));
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
    public Scanner getLeitor() {
        return leitor;
    }
    public void setLeitor(Scanner leitor) {
        this.leitor = leitor;
    }
    public ArrayList<Usuario> getNomes() {
        return nomes;
    }
    public void setNomes(ArrayList<Usuario> nomes) {
        this.nomes = nomes;
    }

    
    
}