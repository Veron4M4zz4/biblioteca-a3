import java.util.Scanner;
import services.GerenciadorEmprestimos;
import services.GerenciadorLivros;
import services.GerenciadorUsuarios;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorUsuarios gu = new GerenciadorUsuarios();
        GerenciadorLivros gl = new GerenciadorLivros();
        GerenciadorEmprestimos ge = new GerenciadorEmprestimos();

        boolean rodando = true;
        while(rodando) {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Deletar Usuário");
            System.out.println("3 - Listar Usuários");
            System.out.println("4 - Cadastrar Livro");
            System.out.println("5 - Listar Livros");
            System.out.println("6 - Emprestar Livro");
            System.out.println("7 - Devolver Livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha a opção: ");

            String opcao = sc.nextLine();
            switch(opcao) {
                case "1":
                    gu.cadastrarUsuario(sc);
                    break;
                case "2":
                    System.out.print("Digite o CPF do usuário a deletar: ");
                    String cpfDel = sc.nextLine();
                    gu.deletarUsuario(cpfDel);
                    break;
                case "3":
                    gu.listarUsuarios();
                    break;
                case "4":
                    gl.cadastrarLivro(sc);
                    break;
                case "5":
                    gl.listarLivros();
                    break;
                case "6":
                    ge.emprestarLivro(sc, gu, gl);
                    break;
                case "7":
                    ge.devolverLivro(sc, gl);
                    break;
                case "0":
                    rodando = false;
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}
