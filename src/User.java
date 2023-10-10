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

    public String getUserNama(){
        return nama;
    }
    public String getUserUsername(){
        return username;
    }
    public String getUserPassword(){
        return password;
    }
    public String getAlamat(){
        return phoneNum;
    }

    public void setUserPassword(String password){
        this.password = password;
    }
    public void setUserNama(String nama){
        this.nama = nama;
    }
    public void setUserAlamat(String phoneNum){
        this.phoneNum = phoneNum;
    }

    //method untuk menambahkan resep kedalam daftar favorit
    public void addToFav(Resep resep){
        //menambahkan resep ke dalam daftar favorit
        daftarFavorit.add(resep);
    }
    public void delFav(int index){
        daftarFavorit.remove(index);
    }


}
