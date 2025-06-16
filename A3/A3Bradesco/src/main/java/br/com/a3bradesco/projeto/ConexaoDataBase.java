package br.com.a3bradesco.projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDataBase {
    private static final String URL = "jdbc:postgresql://localhost:5432/Data_Base_A3";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "browwjoh20@";

    public static Connection conectar() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco: " + e.getMessage());
        }
    }
}
