package YukMakan;
import java.util.ArrayList;
import DatabaseController.DbController;
import java.sql.*;
import java.util.Scanner;

public class Campaign {
    private static final String PROPERTIES = "(admin_username, donatur_username, judul, tanggal, imagepath, deskripsi, "
            + "target_donasi, current_donasi)";
    private int id;
    private String imagePath;
    private String judul;
    private Admin creator;
    private String deskripsi;
    private ArrayList <User> donatur = new ArrayList<User>();
    private int targetDonasi;
    private int currentDonasi;
    private DbController dbController;
    private Scanner scanner = new Scanner(System.in);

    public Campaign (String judul, Admin creator, String deskripsi, DbController dbController){
        this.judul = judul;
        this.creator = creator;
        this.deskripsi = deskripsi;
        this.dbController = dbController;
    }
    
    public Campaign (DbController dbController){
        this.dbController = dbController;
    }
    
    public Campaign(Admin creator){
        this.creator = creator;
    }
    public void printCampaign(){
        System.out.println("---- Campaign ----");
        
    }

    public int getTargetDonasi() {
        return targetDonasi;
    }

    public int getCurrentDonasi() {
        return currentDonasi;
    }

    
    public String getJudul (){
        return judul;
    }
    public String getCreatorName(){
        return creator.getUsername();
    }
    public String getDeskripsi()
    {
        return deskripsi;
    }
    public String getDonaturName (int index){
        return donatur.get(index).getUsername();
    }
    public String getImagePath(){
        return imagePath;
    }
    public int getId(){
        return id;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setCreator(Admin creator) {
        this.creator = creator;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    public void setDonatur(User donatur) {
        this.donatur.add(donatur);
    }
    public void setCurrentDonasi(int nominalDonasi){
        this.currentDonasi += nominalDonasi;
    }
    public void setTargetDonasi(int targetDonasi){
        this.targetDonasi = targetDonasi;
    }
    
    public String getProperties(){
        return PROPERTIES;
    }
    public void updateJudul(int id){
        System.out.println("Masukkan judul baru : ");
        String newJudul = scanner.nextLine();
        dbController.update("campaign", "judul", newJudul, "id", Integer.toString(id));
        System.out.println("Update judul berhasil");
    }
    public void updateDeskripsi(int id){
        System.out.println("Masukkan deskripsi baru : ");
        String newDeskripsi = scanner.nextLine();
        dbController.update("campaign", "deskripsi", newDeskripsi, "id", Integer.toString(id));
        System.out.println("Update deskripsi berhasil");
    }
    public void updateTargetDonasi(int id){
        System.out.println("Masukkan target donasi baru : ");
        String newTargetDonasi = scanner.nextLine();
        dbController.update("campaign", "deskripsi", newTargetDonasi, "id", Integer.toString(id));
        System.out.println("Update deskripsi berhasil");
    }
}
