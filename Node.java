class Node {
    String kode;
    String nama;
    double total;
    Node next;

    // Constructor untuk membuat node pelanggan
    public Node(String kode, String nama, double total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }
}