package YukMakan;

import java.util.ArrayList;
import DatabaseController.DbController;
import java.sql.ResultSet;

public class User extends Akun {
    // arraylist digunakan untuk mempermudah proses modifikasi array
    ArrayList <Resep> daftarFavorit = new ArrayList<Resep>();
    private Resep resep;
    private KontenEdukasi kontenEdukasi;

    public User(String username, String password, String phoneNum, String nama, String email, String role, DbController dbController) {
        super(username, password, phoneNum, nama, email, role,dbController);
        this.resep = new Resep (dbController);
        this.kontenEdukasi = new KontenEdukasi (dbController);
    }

    public User(DbController dbController){
        super(dbController);
        this.resep = new Resep (dbController);
        this.kontenEdukasi = new KontenEdukasi (dbController);
    }

    //method untuk menambahkan resep kedalam daftar favorit
    public void addToFav(Resep resep){
        //menambahkan resep ke dalam daftar favorit
        daftarFavorit.add(resep);
    }
    public void delFav(int index){
        daftarFavorit.remove(index);
    }
    public void mainMenu(){
        int start = 1;
        int menu;
        while(start != 0){
            System.out.println("1. Edit Profile\n2. Lihat Resep");
            menu = Integer.parseInt(scanner.nextLine());
            if (menu == 1){
                editProfile();
            }
            
            else if (menu == 2){
                menuResep();
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
            System.out.println("1. Sebelumnya\n2. Selanjutnya\n3. Tambahkan Ulasan\n0. Keluar");
            menu = Integer.parseInt(scanner.nextLine());
            if(menu == 1){
                
            }
            else if(menu == 2){}
            else if (menu == 3){
                // memanggil method getId untuk mendapatkan Id dari resultSet
                id = dbController.getId(resultSet);
                Ulasan ulasan = buatUlasan();
            }
            else if (menu == 0){start = 0;}
            else{printInputError();}
        }   
    }

    public Ulasan buatUlasan(){
        Ulasan newUlasan = new Ulasan (this);
        System.out.println("Masukkan Ulasan anda : ");
        newUlasan.setUlasan(scanner.nextLine());
        newUlasan.setTanggalUlasan(newUlasan.getDate());
        
        return newUlasan;
    }
    

}
