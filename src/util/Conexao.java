package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Faça o método getConexão retornar uma conexão com o banco de dados.
public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/provaunidade1";
    private static final String usuario = "remoto";
    private static final String senha = "Remoto@123";

    public static Connection getConexao(){
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");            
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não foi possível se conectar ao banco");
            e.printStackTrace();
        }
        return conexao;
    }
}
