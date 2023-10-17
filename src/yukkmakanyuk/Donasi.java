import java.util.ArrayList;

public class Donasi {
    private String judul;
    private Admin creator;
    private String deskripsi;
    private ArrayList <User> donatur = new ArrayList<User>();

    public Donasi (String judul, Admin creator, String deskripsi){
        this.judul = judul;
        this.creator = creator;
        this.deskripsi = deskripsi;
    }

    public String getJudul (){
        return judul;
    }
    public String getCreatorName(){
        return creator.getAdminUsername();
    }
    public String getDeskripsi()
    {
        return deskripsi;
    }
    public String getDonaturName (int index){
        return donatur.get(index).getUserUsername();
    }
}
