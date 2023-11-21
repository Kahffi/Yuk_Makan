package YukMakan;
import java.util.ArrayList;
import java.util.Scanner;
import DatabaseController.DbController;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin extends Akun{
    
    private Resep resep;
    private KontenEdukasi kontenEdukasi;
    private Campaign campaign;
    private Scanner scanner = new Scanner(System.in);

    public Admin(String username, String password, String phoneNum, String nama, String email, String role, DbController dbController) {
        super(username, password, phoneNum, nama, email, role, dbController);
        this.resep = new Resep (dbController);
        this.kontenEdukasi = new KontenEdukasi (dbController);
        this.campaign = new Campaign (dbController);
       
    }
    public Admin(DbController dbController){
        super(dbController);
        this.resep = new Resep (dbController);
        this.kontenEdukasi = new KontenEdukasi (dbController);
        this.campaign = new Campaign(dbController);
    }
  
    public void mainMenu(){
        int start = 1;
        int menu;
        while(start != 0){
            System.out.println("1. Edit Profile\n2. Buat konten edukasi\n3. Buat resep makanan baru\n4. Daftar admin baru\n5. Lihat resep\n6. Kembali");
            menu = Integer.parseInt(scanner.nextLine());
            if (menu == 1){
                super.editProfile();
            }          
            else if (menu == 2){
                createKontenEdukasi();
            }          
            else if (menu == 3){
                createResep();
            }
            else if (menu == 4){
                createCampaign();
            }
            else if (menu == 5){
                daftarAkun();
            }
            else if (menu == 6){
                menuResep();
            }
            else if (menu == 7){
                start = 0;
            }
            else {
                printInputError();
            }
        }
    }
    
    public void createKontenEdukasi () {
        KontenEdukasi k;
        k = new KontenEdukasi (this);
        System.out.println("Judul konten edukasi: ");
        k.setJudul(scanner.nextLine());
        System.out.println("Konten edukasi : ");
        k.setContent(scanner.nextLine());
        String value =  "('" + getUsername() + "', '" + k.getJudul() + "', '" + 
                    k.getContent() + "', current_date, '" + k.getImagePath() + "')";
        dbController.insert("kontenedukasi", k.getProperties(), value);
    }
    
    public void createResep(){
        Resep r = new Resep (this);
        System.out.println("Masukkan judul : ");
        r.setJudul(scanner.nextLine());
        System.out.println("deskripsi : ");
        r.setDeskripsi(scanner.nextLine());
        System.out.println("langkah : ");
        r.setLangkah(scanner.nextLine());
        System.out.println("kandungan gizi : ");
        r.setKandunganGizi(scanner.nextLine());
        System.out.println("sumber gambar : ");
        r.setImagePath(scanner.nextLine());
        System.out.println("bahan: ");
        r.setBahan(scanner.nextLine());
        String value =  "('" + getUsername() + "', '" + r.getJudul() + "', "  + "current_date, '" 
                + r.getDeskripsi() + "', '" + r.getLangkah() + "', '" + r.getKandunganGizi() + "', '"+ r.getImagePath() + "', '" +
                r.getBahan() + "')";
        // Method insertGetId akan memasukkan data ke dalam database, dan me-return auto generated ID dari mysql
        r.setId (dbController.insertGetId(r.getProperties(), "resep",value));
        System.out.println(r.getId());
        
    }
    
    public void createCampaign(){
        Campaign c = new Campaign(this);
        System.out.println("Masukkan judul campaign");
        c.setJudul(scanner.nextLine());
        System.out.println("deskripsi");
        c.setDeskripsi(scanner.nextLine());
        System.out.println("target donasi");
        c.setTargetDonasi(scanner.nextInt());
        String value = "('" + getUsername() + "', '" + c.getJudul() + "', "  + "current_date, '" 
                + c.getDeskripsi() + "', '" + c.getTargetDonasi() + "')";
        dbController.insertGetId(c.getProperties(), "campaign", value);
    }
    
    public void printCampaign(int id){
        ResultSet resultSet = dbController.select("id", "campaign", Integer.toString(id));
         try {
            if(resultSet.first()){
                System.out.println("[1] " + resultSet.getString("judul campaign") + "\n" + resultSet.getString("deskripsi")
                + "\n" + resultSet.getInt("target donasi"));
            }
            else{
                System.out.println("Belum ada campaign");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campaign.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateCampaign(int id){
        Campaign cmpgn = new Campaign(this);
        int start = 1;
        int menu;
        while (start != 0){
            ResultSet rs = dbController.select("id", "resep", Integer.toString(id));
            printCampaign(id);
            System.out.println("1. Ubah judul\n2. Ubah deskripsi\n3. Ubah target donasi\n0. Kembali");
            
            menu = Integer.parseInt(scanner.nextLine());
            
            switch (menu) {
                case 1:
                    cmpgn.updateJudul(id);
                    break;
                case 2:
                    cmpgn.updateDeskripsi(id);
                    break;
                case 3:
                    cmpgn.updateTargetDonasi(id);
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
    
    public void menuCampaign(){
        ResultSet rs = null;
        int start = 1;
        int id;
        int menu;
        while (start != 0){
            rs = resep.printResep(rs);
            System.out.println("1. Sebelumnya\n2. Selanjutnya\n3. Edit\n0. Keluar");
            menu = Integer.parseInt(scanner.nextLine());
            if(menu == 1){
                
            }
            else if(menu == 2){}
            else if (menu == 3){
                // memanggil method getId untuk mendapatkan Id dari resultSet
                id = dbController.getId(rs);
                updateCampaign(id);
            }
            else if (menu == 0){start = 0;}
            else{printInputError();}
        }   
    }
    
    
    public void menuResep(){
        ResultSet resultSet = null;
        int start = 1;
        int id;
        int menu;
        while (start != 0){
            resultSet = resep.printResep(resultSet);
            System.out.println("1. Sebelumnya\n2. Selanjutnya\n3. Edit\n0. Keluar");
            menu = Integer.parseInt(scanner.nextLine());
            if(menu == 1){
                
            }
            else if(menu == 2){}
            else if (menu == 3){
                // memanggil method getId untuk mendapatkan Id dari resultSet
                id = dbController.getId(resultSet);
                resep.updateResep(id);
            }
            else if (menu == 0){start = 0;}
            else{printInputError();}
        }   
    }
    
    

}
