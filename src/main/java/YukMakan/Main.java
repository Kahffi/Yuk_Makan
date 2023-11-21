package YukMakan;
import DatabaseController.DbController;
import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String... args){
        ResultSet resultSet;
        Scanner scanner = new Scanner(System.in);
        DbController dbController = new DbController("root","YukMakan", "123212321");
        Akun akun = new Akun
        (dbController);
        Admin admin = new Admin(dbController);
        User user = new User (dbController);
        //KontenEdukasi kontenEdukasi = new KontenEdukasi (dbController);
        Resep resep = new Resep (dbController);
        int start = 1;
        int menu;
        //loop untuk menu utama
        
        while (start != 0){
            System.out.println("Selamat Datang Di Aplikasi YukMakan");
            System.out.println("1. Login\n2. Daftar Akun");
            menu = Integer.parseInt(scanner.nextLine());
            switch (menu) {
                case 1:
                    resultSet = akun.login();
                    if (resultSet != null){
                        try {
                            if (resultSet.first()){
                                System.out.println("Login berhasil");
                                // Karena login user dan admin disatukan, maka inisialisasi harus dibuat di luar class akun dan child nya,
                                // karena kita tidak tahu siapa yang akan login dan akan menggunakan class yang mana.
                                
                                if ("admin".equals(resultSet.getString("role"))){
                                    admin = new Admin(resultSet.getString("username"), resultSet.getString("password"),
                                            resultSet.getString("phonenum"), resultSet.getString("nama"), resultSet.getString("email"),
                                            resultSet.getString("role"), dbController);
                                    
                                    admin.mainMenu();
                                }
                                
                                else if ("user".equals(resultSet.getString("role"))){
                                    user = new User(resultSet.getString("username"), resultSet.getString("password"),
                                            resultSet.getString("phonenum"), resultSet.getString("nama"), resultSet.getString("email"),
                                            resultSet.getString("role"), dbController);
                                    
                                    user.mainMenu();
                                }
                            }
                            else{
                                System.out.println("Login gagal");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else{
                        System.out.println("Username tidak dapat ditemukan");
                    }   break;
                case 2:
                    user.daftarAkun();
                    break;
                case 3:
                    start = 0;
                    break;
                default:
                    break;
            }
            
        }
        
        
        /*
        */
        
        
        
        /*
        admin.daftarAkun(dbController);
        admin.addAkun();
        */
        /*
        User user1 = new User("Fauzan47", "fauzanrossi", "05487548", "Fauzan", "fauzanRossi@upi.edun", "user", dbController);
        user1.addAkun();
        
        User user2 = new User("Nanda07", "nandasiuu", "50487548", "Nanda", "nanadaSiuu@upi.edun", "user", dbController);
        
        Resep resep1 = new Resep("Capcay Balado", admin1, "17 Agustus 1945", "Lezat nikmat bermanfaat",
                "1. Masukan ini\n2. Tambahkan itu\n3. Inikan itunya\n4. Capcay Balado siap disajikan",
                "1. Cabe\n2. Wortel\n3. Jagung\n4. DLL", "../someImage.png", "12mg Vitamin C\n5g Vitamin A");
        Ulasan ulasan1 = new Ulasan(user1, "Mantap gan", "17 Agustus 1945");
        Ulasan ulasan2 = new Ulasan(user2, "B aja gan", "17 Agustus 1945");
        
        resep1.setUlasan(ulasan1);
        resep1.setUlasan(ulasan2);
        System.out.println(resep1.printUlasan(0));
        System.out.println(resep1.printUlasan(1));
        System.out.println(admin1.getNama());
        System.out.println(admin1.login("rahmatMegumi", "megumiRahmat"));
        */
        
        



    }

}