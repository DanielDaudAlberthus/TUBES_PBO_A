import java.util.Date;
import java.util.Scanner;

public class Peminjaman implements Inputtable {
    private Mahasiswa mahasiswa;
    private Buku buku;
    private int jumlah;
    private Date tanggalPinjam;

    public Peminjaman(Mahasiswa mahasiswa, Buku buku, int jumlah) {
        this.mahasiswa = mahasiswa;
        this.buku = buku;
        this.jumlah = jumlah;
        this.tanggalPinjam = new Date();
    }

    public String getNimMahasiswa() {
        return mahasiswa.getNim();
    }

    public String getNamaMahasiswa() {
        return mahasiswa.getNama();
    }


    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah buku yang dipinjam: ");
        this.jumlah = scanner.nextInt();
        this.tanggalPinjam = new Date();
    }

    public int getJumlah() {
        return jumlah;
    }

    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public String getJudulBuku() {
        return buku.getJudulBuku();
    }

    public void tampilkanInfoPeminjaman() {
        System.out.println("\n=== Info Peminjaman ===");
        System.out.println("NIM: " + getNimMahasiswa());

        System.out.println("Judul Buku: " + getJudulBuku());
        System.out.println("Jumlah Buku yang Dipinjam: " + getJumlah());
        System.out.println("Tanggal Pinjam: " + getTanggalPinjam());
        System.out.println("---------------------------");
    }
}
