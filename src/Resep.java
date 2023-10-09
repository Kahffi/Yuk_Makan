public class Resep {

    private String judul;
    private String uploader;
    private String datePosted;
    private String deskripsi;
    private String langkah;
    private String bahan;
    private String imagePath;

    String getJudul(){
        return judul;
    }
    String getUploader(){
        return uploader;
    }
    String getDatePosted(){
        return datePosted;
    }
    String getDeskripsi(){
        return deskripsi;
    }
    String getLangkah(){
        return langkah;
    }
    String getBahan(){
        return bahan;
    }
    String getImagePath(){
        return imagePath;
    }

    void setJudul(String judul){
        this.judul = judul;
    }
    void setUploader(String uploader){
        this.uploader = uploader;
    }
    void setDatePosted(String datePosted){
        this.datePosted = datePosted;
    }
    void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }
    void setLangkah(String langkah){
        this.langkah = langkah;
    }
    void setBahan(String bahan){
        this.bahan = bahan;
    }
    void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }



}
