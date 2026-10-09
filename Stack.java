class Stack {
    Node top;

    // Constructor untuk membuat Stack
    public Stack() {
        top = null;
    }

    // Menambahkan transaksi ke atas Stack
    public void push(Node pelanggan) {

        // Menghubungkan transaksi baru dengan transaksi sebelumnya
        pelanggan.next = top;

        // Menjadikan transaksi baru sebagai transaksi paling atas
        top = pelanggan;
    }

    // Menampilkan riwayat transaksi dari terbaru ke lama
    public void tampilkanRiwayat() {

        // Jika Stack kosong
        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }

        Node current = top;

        System.out.println("Riwayat Transaksi:");

        while (current != null) {
            System.out.println(
                "Kode: " + current.kode
                + " | Nama: " + current.nama
                + " | Total: " + current.total
            );

            current = current.next;
        }
    }
}