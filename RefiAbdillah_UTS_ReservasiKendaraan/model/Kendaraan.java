package model;

public class Kendaraan implements CetakData {
    private String nopol;
    private String merk;
    private String tipe;
    private int hargaSewa;

    public Kendaraan(String nopol, String merk, String tipe, int hargaSewa) {
        this.nopol = nopol;
        this.merk = merk;
        this.tipe = tipe;
        this.hargaSewa = hargaSewa;
    }

    public String getNopol() {
        return nopol;
    }

    public int getHargaSewa() {
        return hargaSewa;
    }

    @Override
    public void tampilkanData() {
        System.out.printf("| %-10s | %-15s | %-15s | Rp%-10d |\n", nopol, merk, tipe, hargaSewa);
    }
}