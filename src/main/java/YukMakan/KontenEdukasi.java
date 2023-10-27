package YukMakan;
import java.sql.*;
import DatabaseController.DbController;
import java.util.Scanner;

public class KontenEdukasi {
    
    private Scanner scanner = new Scanner(System.in);
    
    private DbController dbController;

    private static final String PROPERTIES = "(admin_username, judul, konten, tanggal, imagepath)";
    private String imagePath;
    private String judul;
    private String content;
    private String tanggal;
    private Admin uploader;

    public KontenEdukasi(String judul, String content, String tanggal, Admin uploader, String imagePath, DbController dbController){
        this.judul = judul;
        this.content = content;
        this.tanggal = tanggal;
        this.imagePath = imagePath;
        this.dbController = dbController;
    }
   
    public KontenEdukasi(DbController dbController){
        this.dbController = dbController;
    }
    
    public void createKontenEdukasi (Admin uploader) {
        this.uploader = uploader;
        String value =  "('" + uploader.getUsername() + "', '" + getJudul() + "', '" + 
                    getContent() + "', current_date, '" + getImagePath() + "')";
        System.out.println("Judul konten edukasi: ");
        setJudul(scanner.nextLine());
        System.out.println("Konten edukasi : ");
        setContent(scanner.nextLine());
        dbController.insert("kontenedukasi", getProperties(), value);
    }
    
    public void printKontenEdukasi(){
        System.out.println("~~~~~ Konten Edukasi ~~~~~");
        
    }
    
    public String getImagePath(){
        return imagePath;
    }
    public String getJudul(){
        return judul;
    }
    public String getContent(){
        return content;
    }
    public String getUploader(){
        return uploader.getNama();
    }
    public String getTanggal(){
        return tanggal;
    }

    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }
    public void setJudul(String judul){
        this.judul = judul;
    }
    public void setUploader(Admin uploader){
        this.uploader = uploader;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }
    public String getProperties(){
        return PROPERTIES;
    }


}
