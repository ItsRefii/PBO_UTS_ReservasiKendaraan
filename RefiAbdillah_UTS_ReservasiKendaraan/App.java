import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class App {
    private static ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    private static ArrayList<Penyewa> daftarPenyewa = new ArrayList<>();
    private static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\n=======================================");
            System.out.println("     SISTEM RESERVASI KENDARAAN");
            System.out.println("=======================================");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tambah Penyewa");
            System.out.println("3. Catat Penyewaan");
            System.out.println("4. Lihat Daftar Kendaraan");
            System.out.println("5. Lihat Daftar Penyewa");
            System.out.println("6. Lihat Daftar Transaksi");
            System.out.println("0. Keluar");
            System.out.println("=======================================");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    System.out.println("\n--- Tambah Kendaraan ---");
                    System.out.print("Nomor Polisi       : ");
                    String nopol = input.nextLine();
                    System.out.print("Merk Kendaraan     : ");
                    String merk = input.nextLine();
                    System.out.print("Tipe Kendaraan     : ");
                    String tipe = input.nextLine();
                    System.out.print("Harga Sewa / Hari  : ");
                    int harga = input.nextInt();
                    input.nextLine();
                    daftarKendaraan.add(new Kendaraan(nopol, merk, tipe, harga));
                    System.out.println(">>> Data kendaraan berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\n--- Tambah Penyewa ---");
                    System.out.print("Nama Penyewa : ");
                    String nama = input.nextLine();
                    System.out.print("No. KTP      : ");
                    String ktp = input.nextLine();
                    System.out.print("Alamat       : ");
                    String alamat = input.nextLine();
                    daftarPenyewa.add(new Penyewa(nama, ktp, alamat));
                    System.out.println(">>> Data penyewa berhasil ditambahkan!");
                    break;

                case 3:
                    System.out.println("\n--- Catat Penyewaan ---");
                    if (daftarKendaraan.isEmpty() || daftarPenyewa.isEmpty()) {
                        System.out.println("!!! Data kendaraan/penyewa masih kosong!");
                        break;
                    }

                    System.out.print("Masukkan No. Polisi Kendaraan : ");
                    String cariNopol = input.nextLine();
                    Kendaraan pilihKendaraan = null;
                    for (Kendaraan k : daftarKendaraan) {
                        if (k.getNopol().equalsIgnoreCase(cariNopol)) {
                            pilihKendaraan = k;
                            break;
                        }
                    }
                    if (pilihKendaraan == null) {
                        System.out.println("!!! Kendaraan tidak ditemukan!");
                        break;
                    }

                    System.out.print("Masukkan No. KTP / Nama Penyewa : ");
                    String cariPenyewa = input.nextLine();
                    Penyewa pilihPenyewa = null;
                    for (Penyewa p : daftarPenyewa) {
                        if (p.getKtp().equalsIgnoreCase(cariPenyewa) || p.getNama().equalsIgnoreCase(cariPenyewa)) {
                            pilihPenyewa = p;
                            break;
                        }
                    }
                    if (pilihPenyewa == null) {
                        System.out.println("!!! Penyewa tidak ditemukan!");
                        break;
                    }

                    System.out.print("Lama Sewa (hari) : ");
                    int lama = input.nextInt();
                    input.nextLine();

                    daftarTransaksi.add(new Transaksi(pilihPenyewa, pilihKendaraan, lama));
                    System.out.println(">>> Transaksi berhasil dicatat!");
                    break;

                case 4:
                    System.out.println("\n=== DAFTAR KENDARAAN ===");
                    if (daftarKendaraan.isEmpty()) {
                        System.out.println("Belum ada data kendaraan!");
                    } else {
                        System.out.printf("%-12s %-15s %-15s %-12s\n", "No. Polisi", "Merk", "Tipe", "Harga/Hari");
                        System.out.println("----------------------------------------------------------");
                        for (Kendaraan k : daftarKendaraan) {
                            k.tampilkanData();
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n=== DAFTAR PENYEWA ===");
                    if (daftarPenyewa.isEmpty()) {
                        System.out.println("Belum ada data penyewa!");
                    } else {
                        System.out.printf("%-20s %-18s %-25s\n", "Nama", "No. KTP", "Alamat");
                        System.out.println("---------------------------------------------------------------");
                        for (Penyewa p : daftarPenyewa) {
                            p.tampilkanData();
                        }
                    }
                    break;

                case 6:
                    System.out.println("\n=== RIWAYAT TRANSAKSI ===");
                    if (daftarTransaksi.isEmpty()) {
                        System.out.println("Belum ada transaksi!");
                    } else {
                        System.out.printf("%-20s %-12s %-8s %-12s\n", "Nama Penyewa", "No. Polisi", "Hari", "Total Bayar");
                        System.out.println("---------------------------------------------------------------");
                        for (Transaksi t : daftarTransaksi) {
                            t.tampilkanData();
                        }
                    }
                    break;

                case 0:
                    System.out.println("\nTerima kasih sudah menggunakan sistem reservasi!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);

        input.close();
    }
}
