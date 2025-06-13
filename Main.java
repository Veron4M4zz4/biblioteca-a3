import java.sql.SQLException;
import java.text.ParseException;
import models.*;
import services.*;
public class Main {
    public static void main(String[] args) throws ParseException, SQLException {
        Usuario usuario1 = new Usuario("leo","12345678901","assa","123456789012","Professor");
        //GerenciadorUsuarios usuarios56 = new GerenciadorUsuarios.getInstancia();
        //DataBaseHelper 
        //System.out.println("----------------------------------------------------");
        //Livro livro = new Livro();
        //Date data = new Date(100,1,20);
       


        Professor usuario2 = (Professor) new Usuario(null, null, null, null, null);

        //usuario - nome, 


        /*GerenciadorEmprestimos GE = GerenciadorEmprestimos.getInstancia(usuario1, livro, data);
        GE.AdicionarEmprestimo();
        GE.Devoluçao();
        GE.Devoluçao();
        System.out.println("_______");*/
    }
}
