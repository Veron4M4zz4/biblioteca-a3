import java.sql.SQLException;
import java.text.ParseException;
import models.*;
import services.*;
public class Main {
    public static void main(String[] args) throws ParseException, SQLException {

        System.out.println("oi");
        Professor professor1 = new Professor(); //Leonardo Alves Gonçalves,00000000000,LeonardoAlves@gmail.com,719999999999,Matematica
        System.out.println(professor1);



        /* 
        GerenciadorEmprestimos ge1 = GerenciadorEmprestimos.getInstancia(usuario1,livro);
        ge1.AdicionarEmprestimo();
        System.out.println("Devolução");
        ge1.Devolucao();
        System.out.println("Mostrardados");
        ge1.MostrarDados();

        System.out.println("\nGE2");
        GerenciadorEmprestimos ge2 = GerenciadorEmprestimos.getInstancia(usuario1,null);
        ge2.MostrarDados();
        
        Usuario usuario1 = new Usuario("Leonado Alves Gonçalves","98484107086","assa@gmail.com","121945668901","Professor");
        Usuario usuario2 = new Usuario("Alice Sampaio da Silva","29840165054","Sampaio23@gmail.com","719883870190","Aluno");
        Usuario usuario3 = new Usuario("Luiz Alberto Carlos","78314228036","LuizALb459@hotmail.com","989968493001","Professor");
        Usuario usuario4 = new Usuario("Carlos Almeida","14956654022");
        Usuario usuario5 = new Usuario(); //Leonardo Alves Gonçalves,00000000000,LeonardoAlves@gmail.com,719999999999,Estudante
        System.out.println(usuario5);
        System.out.println(usuario1);
        System.out.println(usuario2);
        System.out.println(usuario3);
        System.out.println(usuario4);
        System.out.println(usuario5);

        Livro livro = new Livro("Diario de um Banana: dias de cão", "Jeff Kinney", 224, "9780670074952");
        Livro livro1 = new Livro("Diario de um Banana: Rodrick é o cara", "Jeff Kinney", 224);
        Livro livro2 = new Livro("Tratado de Anatomia Veterinaria","Dyce");
        livro.emprestar();
        livro.devolver();
        livro1.emprestar();
        livro1.devolver();
        livro2.emprestar();
        livro2.devolver();
        System.out.println(livro);
        System.out.println(livro1);
        System.out.println(livro2);
        Livro livro3 = new Livro(); // Livro exemplo, Autor, 212, 9780670074952
        System.out.println(livro3);

        GerenciadorEmpretimos ge1 = GerenciadorEmpretimos.getInstancia(usuario5,livro3);
        System.out.println(ge1);
        System.out.println("\nAdicionar Emprestimo:");
        ge1.AdicionarEmprestimo();
        System.out.println(ge1);

        Usuario usuario2 = new Usuario("leonaro","12345678901","leo@leo.com","1234567890","professor");
        GerenciadorUsuarios gu1 = GerenciadorUsuarios.getInstancia();
        gu1.AdicionarUsuario();
        gu1.RemoverUsuario();
        gu1.RemoverUsuarioNome("Leo");
        gu1.SalvarUsuarioNoBanco();
        */
    }   
}
