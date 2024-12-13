import java.util.Scanner;

public class studycase2 {
    static String[][] dataPelanggan = new String[100][2]; //nama pelanggan, no meja
    static int[][] dataMENU = new int[100][4]; //kopi hitam, latte, teh tarik, mie goreng
    static int jumlahPelanggan = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Tampilkan Daftar Pesanan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu : ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahPesanan(sc);
                    break;
                case 2:
                    tampilkanPesanan();
                    break;
                case 3:
                    System.out.println("Terima kasih! Sampai jumpa.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 3);
    }
    public static void tambahPesanan (Scanner sc) {
        int[] hargaMenu = {15000, 22000, 12000, 18000};
        String[] namaMenu = {"Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng"};
        
        if (jumlahPelanggan < 100) {
            
            System.out.print("Masukkan nama pelanggan: ");
            dataPelanggan[jumlahPelanggan][0] = sc.nextLine();
            System.out.print("Masukkan nomor meja: ");
            dataPelanggan[jumlahPelanggan][1] = sc.nextLine();

            System.out.println("===== MENU KAFE =====");
            for (int i = 0; i < namaMenu.length; i++) {
                System.out.println((i+1) + ". " + namaMenu[i] + " - Rp " + namaMenu[i]);
            }
            
            while (true) {
                System.out.print("Pilih menu (masukkan nomor menu, atau 0 untuk selesai): ");
                int pilihMenu = sc.nextInt();

                if (pilihMenu == 0) {
                    break;
                } else if (pilihMenu >= 1 && pilihMenu <=4) {
                    System.out.print("Masukkan jumlah item untuk " + namaMenu[pilihMenu-1] + ": ");
                    int jumlahItem = sc.nextInt();
                    dataMENU[jumlahPelanggan][pilihMenu-1] += jumlahItem;
                } else {
                    System.out.println("Pilihan tidak valid, coba lagi.");
                }
                
            }
            int totalHarga = 0;
            for (int i = 0; i < 4; i++) {
                totalHarga += dataMENU[jumlahPelanggan][i] * hargaMenu[i];
            }
            System.out.println("Pesanan berhasil ditambahkan.");
            System.out.println("Total harga pesanan: " + totalHarga);
            
            jumlahPelanggan++;
            
        } else {
            System.out.println("Data mahasiswa penuh. Tidak dapat menambahkan data lagi.");
        }

    }
}