package model;

public class Penyewa {
    private String nama;
    private String ktp;

    public Penyewa(String nama, String ktp) {
        this.nama = nama;
        this.ktp = ktp;
    }

    public String NamaPenyewa() { 
        return nama; 
    }
    public String KtpPenyewa() { 
        return ktp; 
    }

    public void tampilkanData() {
        System.out.printf("| %-20s | %-15s |\n", nama, ktp);
    }

}
