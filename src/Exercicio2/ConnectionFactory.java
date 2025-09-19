package Exercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

  
    private static final String URL = "jdbc:postgresql://localhost:5432/teste"; 
    private static final String USER = "tiagomreis"; 
    private static final String PASSWORD = "nina"; 


    public static Connection getConnection() {
        try {
           
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
           
            System.err.println("Falha na conexão com o banco de dados: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}