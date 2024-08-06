package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
     public static Connection getConexao() throws Exception {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/prova3unidade1?";
            String usuario = "root";
            String senha = "root";
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException e) {
           
            System.out.println("Não foi possível conectar ao BD");
            e.printStackTrace();
        }
        return con;
    }
}
