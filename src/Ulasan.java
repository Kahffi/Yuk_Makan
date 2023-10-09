public class Ulasan {
    User user = new User();
    String ulasan;
    String tanggalUlasan;

    String getUlasanUser(){
        return user.getUserUsername();
    }
    String getUlasan(){
        return ulasan;
    }
    String getTanggalUlasan(){
        return tanggalUlasan;
    }
    // menyimpan objek user yang memberikan ulasan
    void setUlasanUser(User user){
        this.user = user;
    }
    void setUlasan(String ulasan){
        this.ulasan = ulasan;
    }
    void setTanggalUlasan(String tanggalUlasan){
        this.tanggalUlasan = tanggalUlasan;
    }


}
