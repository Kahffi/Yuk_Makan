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
    private static final String TABLE = "akun";
    
    private String username;
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
    public Akun(DbController dbController){
        this.dbController = dbController;
    }
    public void daftarAkun(){
        int x = 1;
        ResultSet resultSet;
        String usn, pass, phone, e_mail, name, accRole;
        
        while (x != 0){
            System.out.println("Username : ");
            usn = scanner.nextLine();
            resultSet = dbController.select("username", TABLE, usn);
            try {
                // jika tidak ada username yang ingin didaftarkan, maka program akan berlanjut
                if (!resultSet.first()){
                    System.out.println("Pasword : ");
                    pass = scanner.nextLine();
                    System.out.println("Nama : ");
                    name = scanner.nextLine();
                    System.out.println("Nomor Telepon : ");
                    phone = scanner.nextLine();
                    while (x == 1){
                        System.out.println("Email : ");
                        e_mail = scanner.nextLine();
                        ResultSet resultSet2 = dbController.select("username", TABLE, e_mail);
                        if (!resultSet2.first()){
                            // jika class yang mengakses method ini adalah admin, maka role = admin
                            if ("Admin".equals(this.getClass().getSimpleName())){
                                accRole = "admin";
                            }
                            // jika class yang mengakses method ini adalah user, maka role = user
                            else {
                                accRole = "user";
                            }
                            // value digunakan untuk query insert pada sql
                            this.value = "(" + "'"+ usn + "', " + "'" + pass + "', " + "'" + name + "', " + "'" + phone + "', " + "'" + e_mail + "', " + "'" + accRole +"')";
                            dbController.insert(TABLE, PROPERTIES, value);
                            // fungsi daftar akun juga berfungsi sebagai constructor
                            this.username = username; this.password = pass; this.phoneNum = phone; this.role = accRole;
                            this.email = e_mail; this.nama = name;
                            // keluar dari nested loop dan loop utama
                            x = 0;
                        }
                        else {
                            System.out.println("Email sudah didaftarkan, pilih Email lain");
                        }
                    }
                }
                // jika username sudah didaftarkan program akan meminta memasukkan email kembali
                else{
                    System.out.println("Username sudah ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Akun.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
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
    
    // return true jika login berhasil false jika login gagal
    public ResultSet login(){
        int start = 1;
        String usn;
        String pass;
        ResultSet resultSet;
        while (start != 0){
            System.out.println("Username : ");
            usn = scanner.nextLine();
            //mengecek apakah username sudah didaftarkan atau belum pada database
            resultSet = dbController.select("username","akun", usn);
            try {
                if (resultSet.first()){
                    while(start != 2){
                        System.out.println("Password : ");
                        pass = scanner.nextLine();
                        // mendapatkan password dari database dan membandingkan dengan input
                        if (pass.equals(resultSet.getString("password"))){
                            System.out.println("Login Success");
                            return dbController.select("username","akun", usn);
                        }
                        //bila gagal 2 kali maka loop akan selesai
                        start++;
                    }
                }
                else{
                    System.out.println("Username " + usn + "belum didaftarkan");
                    return null;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Akun.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Login gagal");
        return null;
    }
    
    
}
