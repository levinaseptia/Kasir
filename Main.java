import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Queue antrian = new Queue();
        Stack riwayat = new Stack();

        int pilihan;

        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    // Menambahkan pelanggan ke antrian
                    if (antrian.jumlah >= 5) {
                        System.out.println(
                            "Antrian sudah penuh. Maksimal 5 pelanggan."
                        );
                        break;
                    }

                    System.out.print("Masukkan Nomor Antrian: ");
                    String kode = input.nextLine();

                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = input.nextLine();

                    System.out.print("Masukkan Total Belanja: ");
                    double total = input.nextDouble();
                    input.nextLine();

                    antrian.enqueue(kode, nama, total);

                    System.out.println(
                        "Data pelanggan ditambahkan ke antrian!"
                    );
                    break;

                case 2:
                    // Melayani pelanggan dari depan antrian
                    Node pelanggan = antrian.dequeue();

                    if (pelanggan == null) {
                        System.out.println(
                            "Tidak ada pelanggan dalam antrian."
                        );
                    } else {
                        System.out.println(
                            "Melayani pelanggan "
                            + pelanggan.kode
                            + " (" + pelanggan.nama + ")"
                        );

                        // Menyimpan transaksi ke Stack
                        riwayat.push(pelanggan);

                        System.out.println(
                            "Transaksi disimpan ke riwayat."
                        );
                    }
                    break;

                case 3:
                    // Menampilkan antrian pelanggan
                    antrian.tampilkanAntrian();
                    break;

                case 4:
                    // Menampilkan riwayat transaksi
                    riwayat.tampilkanRiwayat();
                    break;

                case 5:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid.");
            }

        } while (pilihan != 5);

        input.close();
    }
}