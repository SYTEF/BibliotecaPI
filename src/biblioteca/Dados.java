package biblioteca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dados {

    // LIVROS
    public List<Livro> getLivros() {
        List<Livro> lista = new ArrayList<>();
        try (Connection con = Conexao.getConexao();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM livros")) {
            while (rs.next()) {
                Livro l = new Livro(rs.getInt("id"), rs.getString("titulo"),
                        rs.getString("autor"), rs.getString("categoria"));
                l.setDisponivel(rs.getBoolean("disponivel"));
                lista.add(l);
            }
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
        return lista;
    }

    public void adicionarLivro(Livro l) {
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(
                "INSERT INTO livros (titulo, autor, categoria) VALUES (?,?,?)")) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getCategoria());
            ps.executeUpdate();
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void atualizarLivro(Livro l) {
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(
                "UPDATE livros SET titulo=?, autor=?, categoria=? WHERE id=?")) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getCategoria());
            ps.setInt(4, l.getId());
            ps.executeUpdate();
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void removerLivro(Livro l) {
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement("DELETE FROM livros WHERE id=?")) {
            ps.setInt(1, l.getId());
            ps.executeUpdate();
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    // USUARIOS
    public List<Usuario> getUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        try (Connection con = Conexao.getConexao();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM usuarios")) {
            while (rs.next()) {
                lista.add(new Usuario(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("cpf"), rs.getString("email")));
            }
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
        return lista;
    }

    public void adicionarUsuario(Usuario u) {
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(
                "INSERT INTO usuarios (nome, cpf, email) VALUES (?,?,?)")) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getCpf());
            ps.setString(3, u.getEmail());
            ps.executeUpdate();
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void atualizarUsuario(Usuario u) {
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(
                "UPDATE usuarios SET nome=?, cpf=?, email=? WHERE id=?")) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getCpf());
            ps.setString(3, u.getEmail());
            ps.setInt(4, u.getId());
            ps.executeUpdate();
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void removerUsuario(Usuario u) {
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement("DELETE FROM usuarios WHERE id=?")) {
            ps.setInt(1, u.getId());
            ps.executeUpdate();
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    // EMPRESTIMOS
    public List<Emprestimo> getEmprestimos() {
        List<Emprestimo> lista = new ArrayList<>();
        try (Connection con = Conexao.getConexao();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(
                "SELECT e.*, l.titulo, l.autor, l.categoria, l.disponivel, " +
                "u.nome, u.cpf, u.email FROM emprestimos e " +
                "JOIN livros l ON e.livro_id = l.id " +
                "JOIN usuarios u ON e.usuario_id = u.id")) {
            while (rs.next()) {
                Livro l = new Livro(rs.getInt("livro_id"), rs.getString("titulo"),
                        rs.getString("autor"), rs.getString("categoria"));
                l.setDisponivel(rs.getBoolean("disponivel"));
                Usuario u = new Usuario(rs.getInt("usuario_id"), rs.getString("nome"),
                        rs.getString("cpf"), rs.getString("email"));
                Emprestimo emp = new Emprestimo(rs.getInt("id"), u, l);
                emp.setStatus(rs.getString("status"));
                lista.add(emp);
            }
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
        return lista;
    }

    public void adicionarEmprestimo(Emprestimo emp) {
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(
                "INSERT INTO emprestimos (livro_id, usuario_id, data_emprestimo, status) VALUES (?,?,?,?)")) {
            ps.setInt(1, emp.getLivro().getId());
            ps.setInt(2, emp.getUsuario().getId());
            ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            ps.setString(4, "ATIVO");
            ps.executeUpdate();
            // marca livro como indisponível
            try (PreparedStatement ps2 = con.prepareStatement(
                "UPDATE livros SET disponivel=false WHERE id=?")) {
                ps2.setInt(1, emp.getLivro().getId());
                ps2.executeUpdate();
            }
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void devolverEmprestimo(Emprestimo emp) {
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(
                "UPDATE emprestimos SET status='DEVOLVIDO' WHERE id=?")) {
            ps.setInt(1, emp.getId());
            ps.executeUpdate();
            try (PreparedStatement ps2 = con.prepareStatement(
                "UPDATE livros SET disponivel=true WHERE id=?")) {
                ps2.setInt(1, emp.getLivro().getId());
                ps2.executeUpdate();
            }
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public boolean autenticar(String login, String senha) {
        return login.equals("admin") && senha.equals("1234");
    }

    private static Dados instancia;
    public static Dados get() {
        if (instancia == null) instancia = new Dados();
        return instancia;
    }
}