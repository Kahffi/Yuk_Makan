package YukMakan;
import java.util.ArrayList;
import java.util.Scanner;
import DatabaseController.DbController;

public class Admin extends Akun{
    
    ArrayList <KontenEdukasi> createdKontenEdukasi = new ArrayList <KontenEdukasi>();
    Scanner scanner = new Scanner(System.in);

    public Admin(String username, String password, String phoneNum, String nama, String email, String role, DbController dbController) {
        super(username, password, phoneNum, nama, email, role, dbController);
    }
    public Admin(DbController dbController){
        super(dbController);
    }
    
    public void createKontenEdukasi () {
        System.out.println("Masukkan judul konten edukasi: ");
        
    }

}
