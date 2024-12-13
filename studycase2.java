import java.util.Scanner;

public class studycase2 {
    static String[][] pesanan = new String[100][5]; 
    static int jumlahPesanan = 0; 
    static String[] menu = {"Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng"};

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
}