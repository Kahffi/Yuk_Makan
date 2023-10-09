public class Admin {
    private String username;
    private String password;
    private String nama;
    private String phoneNum;

    String getAdminNama(){
        return nama;
    }
    String getAdminUsername(){
        return username;
    }
    String getAdminPassword(){
        return password;
    }

    void setAdminPassword(String password){
        this.password = password;
    }
    void setAdminNama(String nama){
        this.nama = nama;
    }
    void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

}
