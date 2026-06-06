package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USUARIO = "root";
    private static final String SENHA = "1234";

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}