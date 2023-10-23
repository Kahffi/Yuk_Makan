package YukMakan;
import java.util.ArrayList;
import java.util.Scanner;
import DatabaseController.DbController;

public class Admin extends Akun{
    
    private KontenEdukasi kontenEdukasi;
    private Scanner scanner = new Scanner(System.in);
    private DbController dbController = getDbController();

    public Admin(String username, String password, String phoneNum, String nama, String email, String role, DbController dbController) {
        super(username, password, phoneNum, nama, email, role, dbController);
        this.kontenEdukasi = new KontenEdukasi(dbController);
    }
    public Admin(DbController dbController){
        super(dbController);
        this.kontenEdukasi = new KontenEdukasi(dbController);
    }
    
    @Override
    public void mainMenu(){
        int start = 1;
        int menu;
        while(start != 0){
            System.out.println("1. Edit Profile\n2. Buat konten edukasi\n3. Kembali");
            menu = Integer.parseInt(scanner.nextLine());
            if (menu == 1){
                editProfile();
            }
            
            else if (menu == 2){
                kontenEdukasi.createKontenEdukasi(this);
            }
            
            else if (menu == 3){
                start = 0;
            }
            else {
                printInputError();
            }
        }
        
    }

}
