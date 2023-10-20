/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseController;

import java.sql.*;

public class DbController {
    // to store sql queries in a constant
    static final String INSERT = "insert into ";
    static final String UPDATE = "update";
    static final String DELETE = "delete";
    static final String SELECT = "select ";
    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;

    public DbController(String usn, String database, String pass) {
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", usn, pass);
            System.out.println("Connected Successfully");
            statement = conn.createStatement();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
