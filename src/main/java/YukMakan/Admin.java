package YukMakan;
import java.util.ArrayList;
import java.util.Scanner;
import DatabaseController.DbController;
import java.sql.*;

public class Admin extends Akun{
    
    private Resep resep;
    private KontenEdukasi kontenEdukasi;
    private Scanner scanner = new Scanner(System.in);

    public Admin(String username, String password, String phoneNum, String nama, String email, String role, DbController dbController) {
        super(username, password, phoneNum, nama, email, role, dbController);
        this.resep = new Resep (dbController);
        this.kontenEdukasi = new KontenEdukasi (dbController);
       
    }
    public Admin(DbController dbController){
        super(dbController);
        this.resep = new Resep (dbController);
        this.kontenEdukasi = new KontenEdukasi (dbController);
    }
  
    public void mainMenu(){
        int start = 1;
        int menu;
        while(start != 0){
            System.out.println("1. Edit Profile\n2. Buat konten edukasi\n3. Buat resep makanan baru\n4. Daftar admin baru\n5. Lihat resep\n6. Kembali");
            menu = Integer.parseInt(scanner.nextLine());
            if (menu == 1){
                super.editProfile();
            }
            
            else if (menu == 2){
                kontenEdukasi.createKontenEdukasi(this);
            }
            
            else if (menu == 3){
                resep.createResep(this);
            }
            
            else if (menu == 4){
                daftarAkun();
            }
            
            else if (menu == 5){
                menuResep();
            }
            
            else if (menu == 6){
                start = 0;
            }
            else {
                printInputError();
            }
        }
    }
    
    public void menuResep(){
        ResultSet resultSet = null;
        int start = 1;
        int id;
        int menu;
        while (start != 0){
            resultSet = resep.printResep(resultSet);
            System.out.println("1. Sebelumnya\n2. Selanjutnya\n3. Edit\n0. Keluar");
            menu = Integer.parseInt(scanner.nextLine());
            if(menu == 1){
                
            }
            else if(menu == 2){}
            else if (menu == 3){
                // memanggil method getId untuk mendapatkan Id dari resultSet
                id = dbController.getId(resultSet);
                resep.updateResep(id);
            }
            else if (menu == 0){start = 0;}
            else{printInputError();}
        }   
    }

}
