import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerpustakaanApp {
    private static final String PASSWORD = "pancasila2022"; // Password untuk login

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi buku contoh dengan stok
        List<Buku> daftarBuku = inisialisasiDaftarBuku();

        // Menu login
        boolean loginBerhasil = false;
        while (!loginBerhasil) {
            System.out.println("=== Login ===");
            System.out.print("Masukkan NIM: ");
            String nimInput = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String passwordInput = scanner.nextLine();
            loginBerhasil = login(nimInput, passwordInput);

            if (!loginBerhasil) {
                System.out.println("Login gagal. Silakan coba lagi.");
            }
        }

        // Mahasiswa login
        Mahasiswa mahasiswa = new Mahasiswa();

        // Riwayat peminjaman
        RiwayatPeminjaman riwayatPeminjaman = new RiwayatPeminjaman();

        int pilihan;
        do {
            System.out.println("\n=== Menu Perpustakaan ===");
            System.out.println("1. Lihat Daftar Buku");
            System.out.println("2. Lakukan Peminjaman");
            System.out.println("3. Lakukan Pengembalian");
            System.out.println("4. Riwayat Peminjaman");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    // Lihat Daftar Buku
                    tampilkanDaftarBuku(daftarBuku);
                    break;
                case 2:
                    // Lakukan Peminjaman
                    System.out.print("Masukkan kode buku yang dipinjam: ");
                    int kodeBukuDipinjam = scanner.nextInt();
                    Buku bukuDipinjam = getBukuByKode(daftarBuku, kodeBukuDipinjam);

                    if (bukuDipinjam != null) {
                        // Pengecekan stok buku sebelum melakukan peminjaman
                        if (bukuDipinjam.getJumlahStok() > 0) {
                            System.out.print("Masukkan jumlah buku yang dipinjam: ");
                            int jumlahDipinjam = scanner.nextInt();

                            // Pengecekan jumlah yang dipinjam tidak melebihi stok
                            if (jumlahDipinjam <= bukuDipinjam.getJumlahStok()) {
                                Peminjaman peminjaman = new Peminjaman(mahasiswa, bukuDipinjam, jumlahDipinjam);
                                peminjaman.tampilkanInfoPeminjaman();
                                riwayatPeminjaman.tambahkanRiwayat(peminjaman);
                                bukuDipinjam.kurangiStok(jumlahDipinjam);
                                System.out.println("Peminjaman berhasil dilakukan.");
                            } else {
                                System.out.println("Maaf, jumlah buku yang dipinjam melebihi stok yang tersedia.");
                            }
                        } else {
                            System.out.println("Maaf, stok buku habis.");
                        }
                    } else {
                        System.out.println("Kode buku tidak valid.");
                    }
                    break;
                case 3:
                    // Lakukan Pengembalian
                    System.out.print("Masukkan kode buku yang dikembalikan: ");
                    int kodeBukuDikembalikan = scanner.nextInt();
                    Buku bukuDikembalikan = getBukuByKode(daftarBuku, kodeBukuDikembalikan);
                    if (bukuDikembalikan != null) {
                        riwayatPeminjaman.hapusRiwayat(mahasiswa.getNim(), bukuDikembalikan.getJudulBuku());
                        bukuDikembalikan.kurangiStok(-1); // Mengembalikan stok
                        System.out.println("Pengembalian berhasil dilakukan.");
                    } else {
                        System.out.println("Kode buku tidak valid.");
                    }
                    break;
                case 4:
                    // Tampilkan Riwayat Peminjaman
                    riwayatPeminjaman.tampilkanRiwayat();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi perpustakaan UP.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu 1-5.");
                    break;
            }
        } while (pilihan != 5);
    }

    private static boolean login(String nim, String password) {
        return PASSWORD.equals(password); // Sederhana: cek apakah password sesuai dengan nilai konstan
    }

    private static List<Buku> inisialisasiDaftarBuku() {
        List<Buku> daftarBuku = new ArrayList<>();
        daftarBuku.add(new Buku("The Pragmatic Programmer: Your Journey to Mastery", "Andrew Hunt, David Thomas", 5, 1));
        daftarBuku.add(new Buku("Code Complete: A Practical Handbook of Software Construction", "Steve McConnel", 7, 2));
        daftarBuku.add(new Buku("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", 10, 3));
        daftarBuku.add(new Buku("Peopleware: Productive Projects and Teams", "Tom DeMarco, Tim Lister", 3, 4));
        daftarBuku.add(new Buku("Rapid Development: Taming Wild Software Schedules", "Steve McConnel", 8, 5));
        return daftarBuku;
    }

    private static void tampilkanDaftarBuku(List<Buku> daftarBuku) {
        System.out.println("\n=== Daftar Buku ===");
        for (int i = 0; i < daftarBuku.size(); i++) {
            tampilkanInfoBuku(i + 1, daftarBuku.get(i));
        }
    }

    private static Buku getBukuByKode(List<Buku> daftarBuku, int kodeBuku) {
        for (Buku buku : daftarBuku) {
            if (buku.getKodeBuku() == kodeBuku) {
                return buku;
            }
        }
        return null;
    }

    private static void tampilkanInfoBuku(int kodeBuku, Buku buku) {
        System.out.println("Kode Buku: " + kodeBuku);
        buku.tampilkanInfoBuku();
        System.out.println("---------------------------");
    }
}
