import java.util.Scanner;

public class Buku implements Inputtable {
    private String judulBuku;
    private String pengarang;
    private int jumlahStok;
    private int kodeBuku;

    public Buku(String judulBuku, String pengarang, int jumlahStok, int kodeBuku) {
        this.judulBuku = judulBuku;
        this.pengarang = pengarang;
        this.jumlahStok = jumlahStok;
        this.kodeBuku = kodeBuku;
    }

    public int getKodeBuku() {
        return kodeBuku;
    }

    @Override
    public void inputData() {
        // Input tidak diperlukan karena judulBuku, pengarang, dan jumlahStok sudah diinisialisasi pada konstruktor
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public String getPengarang() {
        return pengarang;
    }

    public int getJumlahStok() {
        return jumlahStok;
    }

    public void kurangiStok(int jumlah) {
        jumlahStok -= jumlah;
    }

    public void tampilkanInfoBuku() {
        System.out.println("Judul Buku: " + judulBuku);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Jumlah Stok: " + jumlahStok);
    }
}
