import java.util.ArrayList;
import java.util.List;

public class RiwayatPeminjaman {
    private List<Peminjaman> riwayat = new ArrayList<>();

    public void tambahkanRiwayat(Peminjaman peminjaman) {
        riwayat.add(peminjaman);
    }

    public void tampilkanRiwayat() {
        System.out.println("\n=== Riwayat Peminjaman ===");
        for (Peminjaman peminjaman : riwayat) {
            peminjaman.tampilkanInfoPeminjaman();
        }
    }

    public void hapusRiwayat(String nim, String judulBuku) {
        riwayat.removeIf(peminjaman ->
                peminjaman.getNimMahasiswa().equals(nim) && peminjaman.getJudulBuku().equals(judulBuku)
        );
    }
}
