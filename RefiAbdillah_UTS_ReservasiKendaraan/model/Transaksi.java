package model;

public class Transaksi {
    private Kendaraan kendaraan;
    private Penyewa penyewa;
    private int lamaSewa; // hari

    public Transaksi(Kendaraan kendaraan, Penyewa penyewa, int lamaSewa) {
        this.kendaraan = kendaraan;
        this.penyewa = penyewa;
        this.lamaSewa = lamaSewa;
    }

    public int hitungTotal() {
        return kendaraan.getHargaPerHari() * lamaSewa;
    }

public void tampilkanData() {
    System.out.printf("| %-20s | %-10s | %-15s | %3d hari | Rp%-10d |\n",
        penyewa.NamaPenyewa(), kendaraan.getNopol(), kendaraan.getMerk(),
        lamaSewa, hitungTotal()
    );
}


    public Kendaraan getKendaraan() { 
        return kendaraan; 
    }
    public Penyewa getPenyewa() { 
        return penyewa; 
    }
}
