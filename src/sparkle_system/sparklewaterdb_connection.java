/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparkle_system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class sparklewaterdb_connection {
    public static Connection connect() {
    try{
            String url = "jdbc:MySQL://localhost:4307/sparkle_test_db";
            String user = "root";
            String pass = "";

            Connection conn = DriverManager.getConnection(url, user, pass);
            return conn;
        } catch (SQLException e){
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }
    
    
}
