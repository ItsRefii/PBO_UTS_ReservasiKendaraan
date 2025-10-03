package model;

public class Penyewa extends Orang implements CetakData {
    private String ktp;
    private String alamat;

    public Penyewa(String nama, String ktp, String alamat) {
        super(nama);
        this.ktp = ktp;
        this.alamat = alamat;
    }

    public String getKtp() {
        return ktp;
    }

    public String getAlamat() {
        return alamat;
    }

    @Override
    public void tampilkanData() {
        System.out.printf("| %-20s | %-15s | %-20s |\n", getNama(), ktp, alamat);
    }
}
