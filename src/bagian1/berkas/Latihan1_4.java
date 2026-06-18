package bagian1.berkas;
import java.io.File;
import java.io.IOException;

public class Latihan1_4 {
    public static void main(String[] args) {
        // Soal 1: Cek keberadaan dan ukuran laporan.txt
        File berkas = new File("laporan.txt");
        if (berkas.exists()) {
            System.out.println("Berkas ada, ukuran: " + berkas.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ditemukan.");
        }

        // Soal 2: Buat folder arsip
        File folder = new File("arsip");
        if (folder.mkdir()) {
            System.out.println("Folder arsip berhasil dibuat.");
        } else {
            System.out.println("Folder arsip gagal dibuat atau sudah ada.");
        }

        // Soal 3: Buat lalu hapus sementara.txt
        File sementara = new File("sementara.txt");
        try {
            sementara.createNewFile();
            System.out.println("Sebelum dihapus, ada? " + sementara.exists());
            sementara.delete();
            System.out.println("Sesudah dihapus, ada? " + sementara.exists());
        } catch (IOException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }
}