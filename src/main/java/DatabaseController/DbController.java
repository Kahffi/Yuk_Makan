/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseController;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, usn, pass);
            System.out.println("Connected Successfully");
            statement = conn.createStatement();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public DbController(){}
    
    public void insert(String table,String property, String value){
        try {
            System.out.println(INSERT + table + property + "values " + value);
            statement.executeUpdate(INSERT + table + property + "values " + value);
        } catch (SQLException ex) {
            Logger.getLogger(DbController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet select(String column, String table, String arg){
         System.out.println(SELECT + " * from " + table + " where " + column + " = " + "'" + arg + "'") ;
        try {
            resultSet = statement.executeQuery(SELECT + " * from " + table + " where " + column + " = " + "'" + arg + "'");
            System.out.println("found!");
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(DbController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     }
}
