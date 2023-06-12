/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author trieu
 */
public class DBConnection {
    private static Connection con =null;
    
    public static Connection getConnection(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","TRIEUBUI003@");
    }catch (ClassNotFoundException | SQLException e)
    {
        e.printStackTrace();
    }
    return con;
}
}