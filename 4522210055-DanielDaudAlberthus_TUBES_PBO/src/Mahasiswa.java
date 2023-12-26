import java.util.Scanner;

public class Mahasiswa implements Inputtable {
    private String nim;
    private String nama;

    public Mahasiswa() {
        inputData();
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NIM: ");
        this.nim = scanner.nextLine();
        System.out.print("Masukkan nama mahasiswa: ");
        this.nama = scanner.nextLine();
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }
}
