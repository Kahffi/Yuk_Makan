public class KontenEdukasi {

    private String imagePath;
    private String judul;
    private String content;
    private String tanggal;
    Admin uploader = new Admin();

    String getImagePath(){
        return imagePath;
    }
    String getJudul(){
        return judul;
    }
    String getContent(){
        return content;
    }
    String getUploader(){
        return uploader.getAdminNama();
    }
    String getTanggal(){
        return tanggal;
    }

    void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }
    void setJudul(String judul){
        this.judul = judul;
    }
    void setUploader(Admin uploader){
        this.uploader = uploader;
    }
    void setContent(String content){
        this.content = content;
    }
    void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }

}
