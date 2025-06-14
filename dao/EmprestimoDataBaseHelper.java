

import models.Emprestimo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDataBaseHelper {
    private static final String URL = "jdbc:sqlite:ITAU.db";

    public void criarTabelaEmprestimo() {
        String sql = "CREATE TABLE IF NOT EXISTS EMPRESTIMO (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "cpfUsuario TEXT NOT NULL," +
                "idLivro INTEGER NOT NULL," +
                "dataEmprestimo TEXT NOT NULL," +
                "dataDevolucao TEXT," +
                "status TEXT" +
                ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'EMPRESTIMO' verificada/criada.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela EMPRESTIMO: " + e.getMessage());
        }
    }

    public void adicionarEmprestimo(Emprestimo emp) {
        String sql = "INSERT INTO EMPRESTIMO (cpfUsuario, idLivro, dataEmprestimo, dataDevolucao, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, emp.getCpfUsuario());
            pstmt.setInt(2, emp.getIdLivro());
            pstmt.setString(3, emp.getDataEmprestimo());
            pstmt.setString(4, emp.getDataDevolucao());
            pstmt.setString(5, emp.getStatus());
            pstmt.executeUpdate();
            System.out.println("Empréstimo adicionado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar empréstimo: " + e.getMessage());
        }
    }

    public List<Emprestimo> listarEmprestimos() {
        List<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM EMPRESTIMO";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Emprestimo emp = new Emprestimo(
                        rs.getInt("id"),
                        rs.getString("cpfUsuario"),
                        rs.getInt("idLivro"),
                        rs.getString("dataEmprestimo"),
                        rs.getString("dataDevolucao"),
                        rs.getString("status")
                );
                emprestimos.add(emp);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar empréstimos: " + e.getMessage());
        }

        return emprestimos;
    }

    public void deletarEmprestimo(int id) {
        String sql = "DELETE FROM EMPRESTIMO WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Empréstimo deletado com sucesso!");
            } else {
                System.out.println("Nenhum empréstimo deletado. Verifique se o ID existe.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar empréstimo: " + e.getMessage());
        }
    }
}
