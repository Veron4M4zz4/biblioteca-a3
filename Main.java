import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import models.*;
import services.*;
import dao.*;
public class Main {
    public static void main(String[] args) throws ParseException, SQLException {
        Usuario usuario1 = new Usuario("leo","12345678901","assa","123456789012","Professor");
        //GerenciadorUsuarios usuarios56 = new GerenciadorUsuarios.getInstancia();
        //DataBaseHelper 
        //System.out.println("----------------------------------------------------");
        //Livro livro = new Livro();
        //Date data = new Date(100,1,20);
        GerenciadorUsuarios gu = GerenciadorUsuarios.getInstancia();
        //gu.UsuariosCadastrados();
        //gu.AdicionarUsuario();
        gu.SalvarUsuarioNoBanco();


        Professor usuario2 = new Usuario(null, null, null, null, null);

        //usuario - nome, 


        /*GerenciadorEmprestimos GE = GerenciadorEmprestimos.getInstancia(usuario1, livro, data);
        GE.AdicionarEmprestimo();
        GE.Devoluçao();
        GE.Devoluçao();
        System.out.println("_______");*/
    }
}
