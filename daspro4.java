import java.util.Scanner;

public class daspro4 {
    static String[][] dataMhs = new String[100][2]; // [NIM, Nama]
    static String[][] dataMatkul = new String[1000][4]; // [NIM, Kode MK, Nama MK, SKS] 
    static int jumlahMahasiswa = 0;
    static int jumlahMatkul = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== Sistem Pemantauan KRS Mahasiswa ===");
            System.out.println("1. Tambah Data KRS");
            System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
            System.out.println("3. Analisis Data KRS");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahData(sc);
                    break;
                case 2:
                    tampilkanDataByNIM(sc);
                    break;
                case 3:
                    analisisData();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan program!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    public static void tambahData(Scanner sc) {
        System.out.println("--- Tambah Data KRS ---");
        int totalSKS = 0;

        if (jumlahMahasiswa < 100) {
            System.out.print("Nama Mahasiswa: ");
            dataMhs[jumlahMahasiswa][1] = sc.nextLine();
            System.out.print("NIM: ");
            dataMhs[jumlahMahasiswa][0] = sc.nextLine();
            String nim = dataMhs[jumlahMahasiswa][0];

            while (true) {
                System.out.print("Kode Mata Kuliah: ");
                dataMatkul[jumlahMatkul][1] = sc.nextLine();
                System.out.print("Nama Mata Kuliah: ");
                dataMatkul[jumlahMatkul][2] = sc.nextLine();
                System.out.print("Jumlah SKS (1-3): ");
                int sks = sc.nextInt();
                sc.nextLine();

                if (sks >= 1 && sks <= 3) {
                    dataMatkul[jumlahMatkul][0] = nim; 
                    dataMatkul[jumlahMatkul][3] = Integer.toString(sks); 
                    totalSKS += sks;
                    jumlahMatkul++;
                } else {
                    System.out.println("Jumlah SKS tidak valid! SKS harus antara 1 dan 3.");
                    continue;
                }

                System.out.print("Tambah mata kuliah lain? (y/t): ");
                String choice = sc.nextLine();
                if (!choice.equalsIgnoreCase("y")) {
                    break;
                }
            }

            System.out.println("Total SKS yang diambil: " + totalSKS);
            jumlahMahasiswa++;
        } else {
            System.out.println("Data mahasiswa penuh. Tidak dapat menambahkan data lagi.");
        }
    }

    public static void tampilkanDataByNIM(Scanner sc) {
        System.out.print("Masukkan NIM mahasiswa: ");
        String inputNIM = sc.nextLine();
        boolean mahasiswaDitemukan = false; 
        int totalSKS = 0;

        System.out.println("Daftar KRS:");
        System.out.printf("%-10s %-15s %-10s %-30s %-5s\n", 
            "NIM", "Nama", "Kode MK", "Nama Mata Kuliah", "SKS");
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (dataMhs[i][0].equals(inputNIM)) { 
                mahasiswaDitemukan = true;
                String namaMhs = dataMhs[i][1];

                for (int j = 0; j < jumlahMatkul; j++) {
                    if (dataMatkul[j][0].equals(inputNIM)) {
                        System.out.printf("%-10s %-15s %-10s %-30s %-5s\n",
                                dataMatkul[j][0], 
                                namaMhs,           
                                dataMatkul[j][1],  
                                dataMatkul[j][2],  
                                dataMatkul[j][3]   
                        );
                        totalSKS += Integer.parseInt(dataMatkul[j][3]); 
                    }
                }
            
                System.out.println("-------------------------------------------------------------");
                System.out.println("Total SKS: " + totalSKS);
                System.out.println(); 
            }
        }

        if (!mahasiswaDitemukan) {
            System.out.println("Mahasiswa dengan NIM " + inputNIM + " tidak ditemukan.");
        }
    }
    
    public static void analisisData() {
        System.out.println("--- Analisis Data KRS ---"); 
        int count = 0; 
        for (int i = 0; i < jumlahMahasiswa; i++) { 
            int totalSKS = 0; 
            for (int j = 0; j < jumlahMatkul; j++) { 
                if (dataMatkul[j][0].equals(dataMhs[i][0])) { 
                    totalSKS += Integer.parseInt(dataMatkul[j][3]); 
                } 
            } 
            if (totalSKS < 20) { 
                count++; 
            } 
        }
        System.out.println("Jumlah mahasiswa yang mengambil SKS kurang dari 20: " + count);
    }
}

