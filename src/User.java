import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String phoneNum;
    private String nama;

    // arraylist digunakan untuk mempermudah proses modifikasi array
    ArrayList <Resep> daftarFavorit = new ArrayList<Resep>();

    public User (String username, String password, String phoneNum, String nama){
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.nama = nama;
    } 

    String getUserNama(){
        return nama;
    }
    String getUserUsername(){
        return username;
    }
    String getUserPassword(){
        return password;
    }
    String getAlamat(){
        return phoneNum;
    }

    void setUserPassword(String password){
        this.password = password;
    }
    void setUserNama(String nama){
        this.nama = nama;
    }
    void setUserAlamat(String phoneNum){
        this.phoneNum = phoneNum;
    }

    //method untuk menambahkan resep kedalam daftar favorit
    void addToFav(Resep resep){
        //menambahkan resep ke dalam daftar favorit
        daftarFavorit.add(resep);
    }
    void delFav(int index){
        daftarFavorit.remove(index);
    }


}
