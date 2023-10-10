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


    public String getAdminNama(){
        return nama;
    }
    public String getAdminUsername(){
        return username;
    }
    public String getAdminPassword(){
        return password;
    }

    public void setAdminPassword(String password){
        this.password = password;
    }
    public void setAdminNama(String nama){
        this.nama = nama;
    }
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

}
