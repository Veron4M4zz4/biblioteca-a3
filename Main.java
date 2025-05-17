import java.text.ParseException;
import java.util.Date;
import models.*;
import services.*;
public class Main {
    public static void main(String[] args) throws ParseException {
        Usuario usuario1 = new Usuario("leo","123","assa","123456789","Professor");
        
        System.out.println("----------------------------------------------------");
        Livro livro = new Livro();
        Date data = new Date(100,1,20);
        /*GerenciadorUsuarios gu = GerenciadorUsuarios.getInstancia();
        gu.UsuariosCadastrados();*/

        GerenciadorEmprestimos GE = GerenciadorEmprestimos.getInstancia(usuario1, livro, data);
        GE.AdicionarEmprestimo();
        GE.Devoluçao();
        GE.Devoluçao();
        System.out.println("_______");
    }
}
