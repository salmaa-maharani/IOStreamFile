// Nama : Salmaa Dzakirah Maharani
// NPM  : 2410010104
package tugas;

public class MainTugas {
    public static void main(String[] args) {
        // Array kategori
        String[] kategori = {"Elektronik", "Makanan", "Pakaian"};
        System.out.println("== Kategori Barang ==");
        for (String k : kategori) {
            System.out.println("- " + k);
        }
        System.out.println();

        // Membuat gudang dan menambah barang
        Gudang gudang = new Gudang("barang.txt");
        gudang.tambahBarang(new Barang("Laptop", 8000000, 5));
        gudang.tambahBarang(new Barang("Mouse", 150000, 20));
        gudang.tambahBarang(new Barang("Keyboard", 300000, 15));
        gudang.tambahBarang(new Barang("Monitor", 2500000, 8));
        gudang.tambahBarang(new Barang("Headset", 200000, 12));

        gudang.tampilkanSemua();
        gudang.simpanKeBerkas();
        gudang.totalNilai();

        System.out.println();

        // Objek baru, muat dari berkas
        Gudang gudangBaru = new Gudang("barang.txt");
        gudangBaru.muatDariBerkas();
        gudangBaru.tampilkanSemua();
        gudangBaru.totalNilai();
    }
}