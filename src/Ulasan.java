public class Ulasan {
    private User user;
    private String ulasan;
    private String tanggalUlasan;



    public String getUlasanUser(){
        return user.getUserUsername();
    }
    public String getUlasan(){
        return ulasan;
    }
    public String getTanggalUlasan(){
        return tanggalUlasan;
    }
    public String getUlasanUsername(){
        return user.getUserUsername();
    }
    // menyimpan objek user yang memberikan ulasan
    public void setUlasanUser(User user){
        this.user = user;
    }
    public void setUlasan(String ulasan){
        this.ulasan = ulasan;
    }
    public void setTanggalUlasan(String tanggalUlasan){
        this.tanggalUlasan = tanggalUlasan;
    }



}
