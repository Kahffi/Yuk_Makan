package YukMakan;
import DatabaseController.DbController;
import java.sql.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Resep {

    static final String PROPERTIES = "(admin_username, judul, datePosted, deskripsi,"
            + " langkah, kandunganGizi, imagePath, bahan)";
    private String judul;
    private Admin uploader;
    private String datePosted;
    private String deskripsi;
    private String langkah;
    private String bahan;
    private String kandunganGizi;
    private String imagePath;
    private DbController dbController;
    
    private Scanner scanner = new Scanner(System.in);
    
    //ArrayList untuk menampung ulasan-ulasan dari user
    private ArrayList <Ulasan> ulasan = new ArrayList<Ulasan>();

    public Resep(String judul, Admin uploader, String datePosted, String deskripsi,
                 String langkah, String bahan, String imagePath, String kandunganGizi){
        this.judul = judul;
        this.uploader = uploader;
        this.datePosted = datePosted;
        this.deskripsi = deskripsi;
        this.langkah = langkah;
        this.bahan = bahan;
        this.imagePath = imagePath;
        this.kandunganGizi = kandunganGizi;
    }
    
    public Resep(DbController dbController){
        this.dbController = dbController;
    }
    
    public void createResep(Admin uploader){
        this.uploader = uploader;
        System.out.println("Masukkan judul : ");
        setJudul(scanner.nextLine());
        System.out.println("Masukkan deskripsi : ");
        setDeskripsi(scanner.nextLine());
        System.out.println("Masukkan langkah : ");
        setLangkah(scanner.nextLine());
        System.out.println("Masukkan kandungan gizi : ");
        setKandunganGizi(scanner.nextLine());
        System.out.println("Masukkan sumber gambar : ");
        setImagePath(scanner.nextLine());
        System.out.println("Masukkan bahan: ");
        setBahan(scanner.nextLine());
        String value =  "('" + uploader.getUsername() + "', '" + getJudul() + "', "  + "current_date, '" 
                + getDeskripsi() + "', '" + getLangkah() + "', '" + getKandunganGizi() + "', '"+ getImagePath() + "', '" +
                getBahan() + "')";
        dbController.insert("resep", PROPERTIES, value);
    }
    
    public void printResep(){
        ResultSet resultSet = dbController.selectAll("resep");
        try {
            while(resultSet.next()){
                System.out.println("[1] " + resultSet.getString("judul") + "\n" + resultSet.getString("deskripsi")
                + "\n" + resultSet.getString("bahan") + "\n" + resultSet.getString("langkah") + "\n" + resultSet.getString("kandunganGizi")
                + "\n Uploaded by : " + resultSet.getString("admin_username") + " at : " + resultSet.getDate("datePosted" + "\n\n"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Resep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String getJudul(){
        return judul;
    }
    public Admin getUploader(){
        return uploader;
    }
    public String getDatePosted(){
        return datePosted;
    }
    public String getDeskripsi(){
        return deskripsi;
    }
    public String getLangkah(){
        return langkah;
    }
    public String getBahan(){
        return bahan;
    }
    public String getImagePath(){
        return imagePath;
    }
    public String getKandunganGizi(){
        return kandunganGizi;
    }

    public void setJudul(String judul){
        this.judul = judul;
    }
    public void setUploader(Admin uploader){
        this.uploader = uploader;
    }
    public void setDatePosted(String datePosted){
        this.datePosted = datePosted;
    }
    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }
    public void setLangkah(String langkah){
        this.langkah = langkah;
    }
    public void setBahan(String bahan){
        this.bahan = bahan;
    }
    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }
    public void setUlasan(Ulasan ulasan){
        this.ulasan.add(ulasan);
    }
    public void setKandunganGizi(String kandunganGizi){
        this.kandunganGizi = kandunganGizi;
    }

    public String printUlasan(int index){
        return ulasan.get(index).printUlasan();
    }



}
