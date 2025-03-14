/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admi
 */
public class DBContext {
   protected Connection connection;

    public DBContext() {
        // Edit URL, username, password to authenticate with your MS SQL Server
        String url = "jdbc:sqlserver://admin\\SQLEXPRESS:1433;databaseName=MANAGEMENT;trustServerCertificate=true;";
        String username = "sa";
        String password = "12345";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://admin\\SQLEXPRESS:1433;databaseName=MANAGEMENT;trustServerCertificate=true;";
        String username = "sa";
        String password = "12345";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
        } catch (SQLException ex) {
            System.err.println("Lỗi khi kết nối: " + ex.getMessage());
        }
    }
}
    
 

