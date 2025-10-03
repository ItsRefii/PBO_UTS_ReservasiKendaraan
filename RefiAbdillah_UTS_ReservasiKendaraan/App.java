import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
        ArrayList<Penyewa> daftarPenyewa = new ArrayList<>();
        ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

        int pilihan;

        do {
            System.out.println("\n=== SISTEM RENTAL KENDARAAN ===");
            System.out.println("1. Tambah Data Kendaraan");
            System.out.println("2. Tambah Data Penyewa");
            System.out.println("3. Catat Penyewaan");
            System.out.println("4. Lihat Daftar Kendaraan");
            System.out.println("5. Lihat Daftar Penyewa");
            System.out.println("6. Lihat Riwayat Penyewaan");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- Tambah Data Kendaraan ---");
                    System.out.print("Masukkan nomor polisi: ");
                    String nopol = input.nextLine();
                    System.out.print("Masukkan merk kendaraan: ");
                    String merk = input.nextLine();
                    System.out.print("Masukkan harga sewa per hari: ");
                    int harga = input.nextInt();
                    input.nextLine();

                    daftarKendaraan.add(new Kendaraan(nopol, merk, harga));
                    System.out.println("✅ Data kendaraan berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\n--- Tambah Data Penyewa ---");
                    System.out.print("Masukkan nama penyewa: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan nomor KTP: ");
                    String ktp = input.nextLine();

                    daftarPenyewa.add(new Penyewa(nama, ktp));
                    System.out.println("✅ Data penyewa berhasil ditambahkan!");
                    break;

                case 3:
                    if (daftarKendaraan.isEmpty() || daftarPenyewa.isEmpty()) {
                        System.out.println("❌ Data kendaraan atau penyewa belum ada!");
                    } else {
                        System.out.println("\n--- Form Penyewaan ---");

                        // cari kendaraan berdasarkan nopol
                        System.out.print("Masukkan nomor polisi kendaraan: ");
                        String cariNopol = input.nextLine();
                        Kendaraan pilihKendaraan = null;
                        for (Kendaraan k : daftarKendaraan) {
                            if (k.getNopol().equalsIgnoreCase(cariNopol)) {
                                pilihKendaraan = k;
                                break;
                            }
                        }
                        if (pilihKendaraan == null) {
                            System.out.println("❌ Kendaraan dengan nopol itu tidak ditemukan!");
                            break;
                        }

                        // cari penyewa berdasarkan KTP atau nama
                        System.out.print("Masukkan nomor KTP atau nama penyewa: ");
                        String cariPenyewa = input.nextLine();
                        Penyewa pilihPenyewa = null;
                        for (Penyewa p : daftarPenyewa) {
                            if (p.KtpPenyewa().equalsIgnoreCase(cariPenyewa) ||
                                p.NamaPenyewa().equalsIgnoreCase(cariPenyewa)) {
                                pilihPenyewa = p;
                                break;
                            }
                        }
                        if (pilihPenyewa == null) {
                            System.out.println(" Penyewa tidak ditemukan!");
                            break;
                        }

                        System.out.print("Masukkan lama sewa (hari): ");
                        int lama = input.nextInt();
                        input.nextLine();

                        Transaksi t = new Transaksi(pilihKendaraan, pilihPenyewa, lama);
                        daftarTransaksi.add(t);
                        System.out.println("✅ Penyewaan berhasil dicatat!");
                    }
                    break;

                case 4:
                    if (daftarKendaraan.isEmpty()) {
                        System.out.println("Belum ada kendaraan!");
                    } else {
                        System.out.println("\n--- Daftar Kendaraan ---");
                        System.out.println("+------------+-----------------+-------------+");
                        System.out.println("| No. Polisi | Merk Kendaraan  | Harga/Hari  |");
                        System.out.println("+------------+-----------------+-------------+");
                        for (Kendaraan k : daftarKendaraan) {
                            k.tampilkanData();
                        }
                        System.out.println("+------------+-----------------+-------------+");
                    }
                    break;

                case 5:
                    if (daftarPenyewa.isEmpty()) {
                        System.out.println("Belum ada penyewa!");
                    } else {
                        System.out.println("\n--- Daftar Penyewa ---");
                        System.out.println("+----------------------+-----------------+");
                        System.out.println("| Nama Penyewa         | No. KTP         |");
                        System.out.println("+----------------------+-----------------+");
                        for (Penyewa p : daftarPenyewa) {
                            p.tampilkanData();
                        }
                        System.out.println("+----------------------+-----------------+");
                    }
                    break;

                case 6:
                    if (daftarTransaksi.isEmpty()) {
                        System.out.println("Belum ada transaksi!");
                    } else {
                        System.out.println("\n--- Riwayat Penyewaan ---");
                        System.out.println("+----------------------+------------+-----------------+----------+-------------+");
                        System.out.println("| Nama Penyewa         | No. Polisi | Merk Kendaraan  | Lama     | Total Biaya |");
                        System.out.println("+----------------------+------------+-----------------+----------+-------------+");
                        for (Transaksi t : daftarTransaksi) {
                            t.tampilkanData();
                        }
                        System.out.println("+----------------------+------------+-----------------+----------+-------------+");
                    }
                    break;

                case 7:
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }

        } while (pilihan != 7);

        input.close();
    }
}
