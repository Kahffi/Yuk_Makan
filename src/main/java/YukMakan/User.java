package YukMakan;

import java.util.ArrayList;
import DatabaseController.DbController;

public class User extends Akun {
    // arraylist digunakan untuk mempermudah proses modifikasi array
    ArrayList <Resep> daftarFavorit = new ArrayList<Resep>();

    public User(String username, String password, String phoneNum, String nama, String email, String role, DbController dbController) {
        super(username, password, phoneNum, nama, email, role, dbController);
    }

    public User(){}

    //method untuk menambahkan resep kedalam daftar favorit
    public void addToFav(Resep resep){
        //menambahkan resep ke dalam daftar favorit
        daftarFavorit.add(resep);
    }
    public void delFav(int index){
        daftarFavorit.remove(index);
    }

   


}
