package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/base", "user", "pass");
        } catch (ClassNotFoundException | SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
}