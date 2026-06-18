package tugas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gudang {
    private ArrayList<Barang> daftar = new ArrayList<>();
    private String namaBerkas;

    public Gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void tambahBarang(Barang barang) {
        daftar.add(barang);
    }

    public void tampilkanSemua() {
        System.out.println("== Daftar Barang ==");
        for (int i = 0; i < daftar.size(); i++) {
            Barang b = daftar.get(i);
            System.out.println((i + 1) + ". " + b.info());
        }
    }

    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftar) {
                penulis.println(b.keBaris());
            }
            System.out.println("Data disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    daftar.add(new Barang(bagian[0], Double.parseDouble(bagian[1]), Integer.parseInt(bagian[2])));
                }
            }
            System.out.println("Data dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    public void totalNilai() {
        double total = 0;
        for (Barang b : daftar) {
            total += b.getHarga() * b.getStok();
        }
        System.out.printf("Total nilai persediaan: Rp %.0f%n", total);
    }
}