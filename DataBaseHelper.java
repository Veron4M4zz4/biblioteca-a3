import models.*;
import java.sql.*;
import java.util.ArrayList;

public class DataBaseHelper {
    private static final String URL = "jdbc:sqlite:ITAU.db";

    public static void CriarTabelaUsuario() throws SQLException{
        String sql = "CREATE TABLE IF NOT EXISTS USUARIO ("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "nome TEXT NOT NULL"+
                    "cpf TEXT NOT NULL"+
                    "email TEXT"+
                    "telefone TEXT"+
                    "tipo TEXT";

        try(Connection conn = DriverManager.getConnection(URL)){
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("tabela 'usuarios' verificada/criada.");
        } catch(SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());

        }
    
    }
    public void adicionarUsuario(Usuario usuario){
        String sql = "INSRT INTO USUARIO (nome,cpf,email,telefone,tipo) VALUE (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, usuario.getNome());
                pstmt.setString(2, usuario.getCpf());
                pstmt.
            }

        }
    }
}
