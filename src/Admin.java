public class Admin {
    private String username;
    private String password;
    private String nama;
    private String phoneNum;


    public Admin(String username, String password, String nama, String phoneNum){
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.phoneNum = phoneNum;
    }


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
