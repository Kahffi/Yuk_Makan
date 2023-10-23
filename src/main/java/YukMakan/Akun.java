package YukMakan;
import DatabaseController.DbController;
import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Akun {
    public String username;
    private String password;
    private String nama;
    private String phoneNum;
    private String email;
    private String role;
    
    private DbController dbController;
    private static final String PROPERTIES = "(username, password, nama, phonenum, email, role)";
    String value;
    Scanner scanner = new Scanner(System.in);
    

    public Akun(String username, String password, String phoneNum, String nama, String email, String role, DbController dbController){
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.phoneNum = phoneNum;
        this.email = email;
        this.dbController = dbController;
        this.role = role;
        this.value = "(" + "'"+ username + "', " + "'" + password + "', " + "'" + nama + "', " + "'" + phoneNum + "', " + "'" + email + "', " + "'" + role +"')"; 
    }
    public Akun(){}
    public void daftarAkun(DbController dbController){
        System.out.println("Username : ");
        this.username = scanner.nextLine();
        System.out.println("Pasword : ");
        this.password = scanner.nextLine();
        System.out.println("Nama : ");
        this.nama = scanner.nextLine();
        System.out.println("Nomor Telepon : ");
        this.phoneNum = scanner.nextLine();
        System.out.println("Email : ");
        this.email = scanner.nextLine();
        this.dbController = dbController;
        if ("Admin".equals(this.getClass().getSimpleName())){
            this.role = "admin";
            System.out.println(this.role);
        }
        else if ("User".equals(this.getClass().getSimpleName())){
            this.role = "user";
            System.out.println(this.role);
        }
        this.value = "(" + "'"+ username + "', " + "'" + password + "', " + "'" + nama + "', " + "'" + phoneNum + "', " + "'" + email + "', " + "'" + role +"')"; 
    }
    
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }
    
    public String getValue(){
        return value;
    }
    
    public void setValue(String username, String password, String phoneNum, String nama, String email, String role){
        this.value = "(" + "'"+ username + "', " + "'" + password + "', " + "'" + nama + "', " + "'" + phoneNum + "', " + "'" + email + "', " + "'" + role +"')"; 
    }
    
    public void addAkun (){
        dbController.insert("akun", PROPERTIES, value);
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void login(){
        String usn;
        ResultSet resultSet;
        System.out.println("Username : ");
        usn = scanner.nextLine();
        //mengecek apakah username sudah didaftarkan atau belum pada database
        resultSet = dbController.select("username","akun", username);
        try {
            if ("null".equals(resultSet.getString("username"))){
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Akun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
