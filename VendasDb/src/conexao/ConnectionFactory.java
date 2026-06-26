/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vitoria
 */
public class ConnectionFactory {
     public static Connection getConexaoMySQL() throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        String URL = "jdbc:mysql://localhost:3306/vendasdb";
        String USER = "root";
        String PASSWORD = "13312020";
     
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

   
}
