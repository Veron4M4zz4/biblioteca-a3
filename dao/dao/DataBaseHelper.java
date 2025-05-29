package dao;

import models.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper {
    private static final String URL = "jdbc:sqlite:ITAU.db";

    public void CriarTabelaUsuario() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS USUARIO (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "cpf TEXT NOT NULL," +
                "email TEXT," +
                "telefone TEXT," +
                "tipo TEXT" +
                ");";

        try (Connection conn = DriverManager.getConnection(URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("tabela 'usuarios' verificada/criada.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());

        }

    }

    public void adicionarUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (nome,cpf,email,telefone,tipo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getCpf());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getTelefone());
            pstmt.setString(5, usuario.getTipo());
            pstmt.executeUpdate();
            System.out.println("Usuário adicionado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar o usuário: " + e.getMessage());
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";
        try (Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("tipo"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar os usuários: " + e.getMessage());
        }
        return usuarios;
    }
}
