package model;

public class Kendaraan {
    private String nopol;
    private String merk;
    private int hargaPerHari;
    private boolean tersedia;

    public Kendaraan(String nopol, String merk, int hargaPerHari) {
        this.nopol = nopol;
        this.merk = merk;
        this.hargaPerHari = hargaPerHari;
        this.tersedia = true;
    }

    public String getNopol() { 
        return nopol; 
    }
    public String getMerk() { 
        return merk; 
    }
    public int getHargaPerHari() { 
        return hargaPerHari; 
    }
    public boolean isTersedia() { 
        return tersedia; 
    }
    public void setTersedia(boolean tersedia) { 
        this.tersedia = tersedia; 
    }

    public void tampilkanData() {
        System.out.printf("| %-10s | %-15s | Rp%-10d |\n", nopol, merk, hargaPerHari);
    }

}
