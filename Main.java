import java.sql.SQLException;
import java.text.ParseException;
import models.*;
import services.*;
public class Main {
    public static void main(String[] args) throws ParseException, SQLException {
       /*  Usuario usuario1 = new Usuario("leo","12345678901","assa","123456789012","Professor");
        System.out.println(" | " +usuario1.exibirDados()+ " | " +usuario1.getCpf()+ " | taxa Multa " +usuario1.taxaMulta(15)+ " | " + usuario1);
        System.out.println();
        Livro livro = new Livro("leo", "Leonardo", 150, "1234567890123");
        livro.emprestar();
        livro.devolver();
        System.out.println(" | " +livro.getAutor()+ " | "+livro.toString());
        GerenciadorEmprestimos ge1 = GerenciadorEmprestimos.getInstancia(usuario1,livro);
        ge1.AdicionarEmprestimo();
        System.out.println("Devolução");
        ge1.Devolucao();
        System.out.println("Mostrardados");
        ge1.MostrarDados();

        System.out.println("\nGE2");
        GerenciadorEmprestimos ge2 = GerenciadorEmprestimos.getInstancia(usuario1,null);
        ge2.MostrarDados();
        
        Usuario usuario2 = new Usuario("leonaro","12345678901","leo@leo.com","1234567890","professor");*/
        GerenciadorUsuarios gu1 = GerenciadorUsuarios.getInstancia();
        gu1.AdicionarUsuario();
        gu1.RemoverUsuario();
        gu1.RemoverUsuarioNome("Leo");
        gu1.SalvarUsuarioNoBanco();

    }   
}
