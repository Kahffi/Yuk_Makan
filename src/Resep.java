import java.util.ArrayList;

public class Resep {

    private String judul;
    private String uploader;
    private String datePosted;
    private String deskripsi;
    private String langkah;
    private String bahan;
    private String imagePath;

    //ArrayList untuk menampung ulasan-ulasan dari user
    private ArrayList <Ulasan> ulasan = new ArrayList<Ulasan>();

    public String getJudul(){
        return judul;
    }
    public String getUploader(){
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

    public void setJudul(String judul){
        this.judul = judul;
    }
    public void setUploader(String uploader){
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



}
