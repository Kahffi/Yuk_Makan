package YukMakan;
import DatabaseController.DbController;
import java.util.ArrayList;
import java.util.Scanner;

public class Campaign {
    private String imagePath;
    private String judul;
    private Admin creator;
    private String deskripsi;
    private ArrayList <User> donatur = new ArrayList<User>();
    private int targetDonasi;
    private int currentDonasi;
    private DbController dbcontroller;
    private Scanner input = new Scanner(System.in);

    public Campaign (String judul, Admin creator, String deskripsi){
        this.judul = judul;
        this.creator = creator;
        this.deskripsi = deskripsi;
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

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
    
    public void createCampaign(Admin Creator){
        this.creator = creator;
        System.out.println("Masukkan Judul Campaign");
        setJudul(input.nextLine());
        
        
    }
}
