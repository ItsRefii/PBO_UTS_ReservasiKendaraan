package model;

public class Transaksi implements CetakData {
    private Penyewa penyewa;
    private Kendaraan kendaraan;
    private int lamaSewa;
    private int totalBiaya;

    public Transaksi(Penyewa penyewa, Kendaraan kendaraan, int lamaSewa) {
        this.penyewa = penyewa;
        this.kendaraan = kendaraan;
        this.lamaSewa = lamaSewa;
        this.totalBiaya = kendaraan.getHargaSewa() * lamaSewa;
    }

    @Override
    public void tampilkanData() {
        System.out.printf("| %-15s | %-10s | %5d hari | Rp%-10d |\n",
                penyewa.getNama(), kendaraan.getNopol(), lamaSewa, totalBiaya);
    }
}
