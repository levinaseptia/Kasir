class Queue {
    Node front;
    Node rear;
    int jumlah;

    // Constructor untuk membuat Queue
    public Queue() {
        front = null;
        rear = null;
        jumlah = 0;
    }

    // Menambahkan pelanggan ke akhir antrian
    public void enqueue(String kode, String nama, double total) {

        // Mengecek apakah antrian sudah penuh
        if (jumlah >= 5) {
            System.out.println("Antrian sudah penuh. Maksimal 5 pelanggan.");
            return;
        }

        Node baru = new Node(kode, nama, total);

        // Jika antrian masih kosong
        if (front == null) {
            front = baru;
            rear = baru;
        } else {
            // Menambahkan node baru di belakang antrian
            rear.next = baru;
            rear = baru;
        }

        jumlah++;
    }

    // Menghapus pelanggan dari depan antrian
    public Node dequeue() {

        // Jika antrian kosong
        if (front == null) {
            return null;
        }

        // Menyimpan pelanggan yang akan dilayani
        Node pelanggan = front;

        // Memindahkan front ke pelanggan berikutnya
        front = front.next;

        // Jika antrian menjadi kosong
        if (front == null) {
            rear = null;
        }

        // Memutus hubungan node yang sudah diambil
        pelanggan.next = null;

        jumlah--;

        return pelanggan;
    }

    // Menampilkan semua pelanggan dalam antrian
    public void tampilkanAntrian() {

        // Jika antrian kosong
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }

        Node current = front;

        System.out.println("Antrian Pelanggan:");

        while (current != null) {
            System.out.println(
                "Kode: " + current.kode
                + " | Nama: " + current.nama
                + " | Total: " + current.total
            );

            current = current.next;
        }

        System.out.println("Jumlah pelanggan: " + jumlah);
    }
}