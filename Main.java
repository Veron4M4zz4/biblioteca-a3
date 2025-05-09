import models.*;
import services.*;
public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("leo","123","assa","123456789","Professor");
        System.out.println(usuario1.toString());
        System.out.println("----------------------------------------------------");
        GerenciadorUsuarios gu = new GerenciadorUsuarios();
        gu.UsuariosCadastrados();
    }
}