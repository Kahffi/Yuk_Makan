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
    private int id;
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
        // Method insertGetId akan memasukkan data ke dalam database, dan me-return auto generated ID dari mysql
        setId (dbController.insertGetId(PROPERTIES, "resep",value));
        System.out.println(getId());
        
    }
    
    public ResultSet printResep(ResultSet resultSet){
        try {
            //method isClosed digunakan karena, jika tidak digunakan akan menghasilkan error ResultSet closed
            //maka disini resultSet di-inisialisasi ulang
            if (resultSet == null || resultSet.isClosed()){
                resultSet = dbController.selectAll("resep");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Resep.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(resultSet.next()){
                System.out.println("[1] " + resultSet.getString("judul") + "\n" + resultSet.getString("deskripsi")
                + "\n" + resultSet.getString("bahan") + "\n" + resultSet.getString("langkah") + "\n" + resultSet.getString("kandunganGizi")
                + "\n Uploaded by : " + resultSet.getString("admin_username") + " at : " + resultSet.getDate("datePosted") + "\n\n");
                return resultSet;
            }
            else{
                System.out.println("Belum ada resep");
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Resep.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void printResep(int id){
        // select row dengan id yang sedang dipilih
        ResultSet resultSet = dbController.select("id", "resep", Integer.toString(id));
        try {
            if(resultSet.first()){
                System.out.println("[1] " + resultSet.getString("judul") + "\n" + resultSet.getString("deskripsi")
                + "\n" + resultSet.getString("bahan") + "\n" + resultSet.getString("langkah") + "\n" + resultSet.getString("kandunganGizi")
                + "\n Uploaded by : " + resultSet.getString("admin_username") + " at : " + resultSet.getDate("datePosted"));
            }
            else{
                System.out.println("Belum ada resep");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Resep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void getResepNext(){
        
    }
    
    public void updateResep(int id){
        int start = 1;
        int menu;
        
        while (start != 0){
            ResultSet rs = dbController.select("id", "resep", Integer.toString(id));
            printResep(id);
            System.out.println("1. Ubah judul\n2. Ubah deskripsi\n3. Ubah langkah-langkah\n4. Ubah kandungan gizi"
                    + "\n5. Ubah foto\n6. Ubah bahan\n0. Kembali");
            
            menu = Integer.parseInt(scanner.nextLine());
            
            switch (menu) {
                case 1:
                    updateJudul(id);
                    break;
                case 2:
                    updateDeskripsi(id);
                    break;
                case 3:
                    updateLangkah(id);
                    break;
                case 4:
                    updateKandunganGizi(id);
                    break;
                case 5:
                    updateFoto(id);
                    break;
                case 6:
                    updateBahan(id);
                    break;
                case 0:
                    start = 0;
                    break;
                default:
                    System.out.println("input yang anda masukkan salah");
                    break;
            }
        } 
    }
    
    public void updateJudul(int id){
        System.out.println("Masukkan judul baru : ");
        String newJudul = scanner.nextLine();
        dbController.update("resep", "judul", newJudul, "id", Integer.toString(id));
        System.out.println("Update judul berhasil");
    }
    public void updateDeskripsi(int id){
        System.out.println("Masukkan deskripsi baru : ");
        String newDeskripsi = scanner.nextLine();
        dbController.update("resep", "deskripsi", newDeskripsi, "id", Integer.toString(id));
        System.out.println("Update deskripsi berhasil");
    }
    public void updateLangkah(int id){
        System.out.println("Masukkan langkah-langkah baru : ");
        String newLangkah = scanner.nextLine();
        dbController.update("resep", "langkah", newLangkah, "id", Integer.toString(id));
        System.out.println("Update langkah-langkah berhasil");
    }
    public void updateKandunganGizi(int id){
        System.out.println("Masukkan kandungan gizi baru : ");
        String newKandunganGizi = scanner.nextLine();
        dbController.update("resep", "kandungangizi", newKandunganGizi, "id", Integer.toString(id));
        System.out.println("Update kandungan gizi berhasil");
    }
    public void updateFoto(int id){
        System.out.println("Masukkan foto baru : ");
        String newFoto = scanner.nextLine();
        dbController.update("resep", "imagePath", newFoto, "id", Integer.toString(id));
        System.out.println("Update foto berhasil");
    }
    public void updateBahan(int id){
        System.out.println("Masukkan bahan-bahan baru : ");
        String newBahan = scanner.nextLine();
        dbController.update("resep", "bahan", newBahan, "id", Integer.toString(id));
        System.out.println("Update bahan berhasil");
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
