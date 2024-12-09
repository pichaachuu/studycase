import java.util.Scanner;
public class daspro {
    
    public static void inputDataKrs(Scanner sc) {
       System.out.print("Nama Mahasiswa: ");
       sc.nextLine();
       String namaMhs = sc.nextLine();
       System.out.print("NIM: ");
       String NIM = sc.nextLine();

       char tambah = 'y';

       while (tambah == 'y' || tambah == 'Y') {
        System.out.print("Kode Mata Kuliah: ");
        String KodeMatkul = sc.nextLine();
        System.out.print("Nama Mata Kuliah: ");
        String NamaMatkul = sc.nextLine();
        System.out.print("Jumlah SKS (1-3): ");
        int SKS = sc.nextInt();
        System.out.println("Data mata kuliah berhasil ditambahkan.");
        System.out.print("Tambah mata kuliah lain? (y/t): ");
        tambah = sc.next().charAt(0);
        sc.nextLine();

       }
    }

    public static void tampildata(){
        System.out.println("tampil data");
    }

    public static void analisisdata(){
        System.out.println("analisis");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        int pilihmenu;
        
        do {
            System.out.println("=== Sistem Pemantauan KRS Mahasiswa ===");
            System.out.println("1. Tambah Data KRS");
            System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
            System.out.println("3. Analisis Data KRS");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihmenu = sc.nextInt();

            switch (pilihmenu) {
                case 1:
                    inputDataKrs(sc);
                    break;
                case 2:
                    tampildata();
                    break;
                case 3: 
                    analisisdata();
                    break;
                case 4:
                    System.out.println("Terima Kasih!");
                     break;
                default:
                System.out.println("Pilihan tidak valid. Silahkan coba lag. ");
            }
        } while (pilihmenu != 4); {
            
        sc.close();
    }
}
}
