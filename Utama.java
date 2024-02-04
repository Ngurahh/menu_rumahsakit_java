package rumahSakit;

import java.util.Scanner;

public class Utama {
    private static final int MAX_SIZE = 100;
    private static Dokter[] dokterList = new Dokter[MAX_SIZE];
    private static Pasien[] pasienList = new Pasien[MAX_SIZE];
    private static Perawat[] perawatList = new Perawat[MAX_SIZE];
    private static InfoRS[] infoRSList = new InfoRS[MAX_SIZE];
    private static Kunjungan[] kunjunganList = new Kunjungan[MAX_SIZE];

    private static int dokterCount = 0;
    private static int pasienCount = 0;
    private static int perawatCount = 0;
    private static int infoRSCount = 0;
    private static int kunjunganCount = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Dokter");
            System.out.println("2. Pasien");
            System.out.println("3. Perawat");
            System.out.println("4. InfoRS");
            System.out.println("5. Kunjungan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    menuDokter();
                    break;
                case 2:
                    menuPasien();
                    break;
                case 3:
                    menuPerawat();
                    break;
                case 4:
                    menuInfoRS();
                    break;
                case 5:
                    menuKunjungan();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan coba lagi.");
                    break;
            }

        } while (choice != 0);
    }

    private static void menuDokter() {
        int choice;
        do {
            System.out.println("\n=== Menu Dokter ===");
            System.out.println("1. Tambah Data Dokter");
            System.out.println("2. Edit Data Dokter");
            System.out.println("3. Hapus Data Dokter");
            System.out.println("4. Lihat Data Dokter");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tambahDataDokter();
                    break;
                case 2:
                    editDataDokter();
                    break;
                case 3:
                    hapusDataDokter();
                    break;
                case 4:
                    lihatDataDokter();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n======================================");
                    System.out.println("Menu tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (choice != 0);
    }

    private static void tambahDataDokter() {
        if (dokterCount < MAX_SIZE) {
            System.out.println("\n=== Tambah Data Dokter ===");
            System.out.print("Masukkan ID Dokter: ");
            String idDokter = scanner.next();
            scanner.nextLine();
            System.out.print("Masukkan Nama Dokter: ");
            String nama = scanner.nextLine();
            boolean umurValid = false;
            int umur = 0;
            while (!umurValid) {
                System.out.print("Masukkan Umur Dokter: ");
                umur = scanner.nextInt();
                if (umur >= 21 && umur <= 65) {
                    umurValid = true;
                } else {
                    System.out.println("Umur harus antara 21 sampai 65.");
                }
            }
            scanner.nextLine();
            String nomorTelepon = null;
            while (nomorTelepon == null) {
                System.out.print("Masukkan Nomor Telepon Dokter: ");
                String inputTelepon = scanner.next();
                if (inputTelepon.matches("^[0-9]{8,15}$")) {
                    nomorTelepon = inputTelepon;
                } else {
                    System.out.println("Nomor telepon harus antara 8 sampai 15 digit dan hanya berisi angka.");
                }
            }
            String gender = null;
            while (gender == null) {
                System.out.print("Masukkan Gender Dokter: ");
                String inputGender = scanner.next();
                if (inputGender.equalsIgnoreCase("Laki-laki") || inputGender.equalsIgnoreCase("Perempuan")) {
                    gender = inputGender;
                } else {
                    System.out.println("Gender hanya dapat memiliki nilai 'Laki-laki' atau 'Perempuan'.");
                }
            }
            System.out.print("Masukkan Alamat Dokter: ");
            String alamat = scanner.next();
            System.out.print("Masukkan Spesialisasi Dokter: ");
            String spesialisasi = scanner.next();
            System.out.print("Masukkan Waktu Praktek Dokter: ");
            String waktuPraktek = scanner.next();

            dokterList[dokterCount++] = new Dokter(idDokter, nama, umur, nomorTelepon, gender, alamat, spesialisasi,
                    waktuPraktek);

            boolean idDokterSudahAda = cekDuplikatidDokter(dokterList, dokterCount - 1, idDokter);
            if (idDokterSudahAda) {
                System.out.println("\n============================");
                System.out.println("Maaf, ID Dokter sudah ada.");
                dokterCount--;
            } else {
                System.out.println("\n===================================");
                System.out.println("Data Dokter berhasil ditambahkan.");
            }
        } else {
            System.out.println("\n=======================================================");
            System.out.println("Data Dokter penuh. Tidak dapat menambahkan data lagi.");
        }
    }

    private static boolean cekDuplikatidDokter(Dokter[] daftarDokter, int index, String idDokterBaru) {
        for (int i = 0; i < index; i++) {
            if (daftarDokter[i] != null && daftarDokter[i].getIdDokter().equals(idDokterBaru)) {
                return true;
            }
        }
        return false;
    }

    private static void editDataDokter() {
        if (dokterCount > 0) {
            System.out.println("\n=== Edit Data Dokter ===");
            System.out.print("Masukkan ID Dokter yang ingin diedit: ");
            String idDokter = scanner.next();
            int index = -1;
            for (int i = 0; i < dokterCount; i++) {
                if (dokterList[i].getIdDokter().equals(idDokter)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                System.out.println("\nData Saat Ini:");
                dokterList[index].tampilkanData();

                System.out.println("\n=== Masukkan Data Baru ===");
                System.out.print("Masukkan Nama Baru: ");
                String nama = scanner.next();
                boolean umurValid = false;
                int umur = 0;
                while (!umurValid) {
                    System.out.print("Masukkan Umur Baru: ");
                    umur = scanner.nextInt();
                    if (umur >= 21 && umur <= 65) {
                        umurValid = true;
                    } else {
                        System.out.println("Umur harus antara 21 sampai 65.");
                    }
                }
                scanner.nextLine();
                String nomorTelepon = null;
                while (nomorTelepon == null) {
                    System.out.print("Masukkan Nomor Telepon Baru: ");
                    String inputTelepon = scanner.next();
                    if (inputTelepon.matches("^[0-9]{8,15}$")) {
                        nomorTelepon = inputTelepon;
                    } else {
                        System.out.println("Nomor telepon harus antara 8 sampai 15 digit dan hanya berisi angka.");
                    }
                }
                String gender = null;
                while (gender == null) {
                    System.out.print("Masukkan Gender Baru: ");
                    String inputGender = scanner.next();
                    if (inputGender.equalsIgnoreCase("Laki-laki") || inputGender.equalsIgnoreCase("Perempuan")) {
                        gender = inputGender;
                    } else {
                        System.out.println("Gender hanya dapat memiliki nilai 'Laki-laki' atau 'Perempuan'.");
                    }
                }
                System.out.print("Masukkan Alamat Baru: ");
                String alamat = scanner.next();
                System.out.print("Masukkan Spesialisasi Baru: ");
                String spesialisasi = scanner.next();
                System.out.print("Masukkan Waktu Praktek Baru: ");
                String waktuPraktek = scanner.next();

                dokterList[index] = new Dokter(idDokter, nama, umur, nomorTelepon, gender, alamat, spesialisasi,
                        waktuPraktek);
                System.out.println("\n==============================");
                System.out.println("Data Dokter berhasil diubah.");
            } else {
                System.out.println("\n============================");
                System.out.println("ID Dokter tidak ditemukan.");
            }
        } else {
            System.out.println("\n================================================");
            System.out.println("Data Dokter kosong. Tidak dapat mengedit data.");
        }
    }

    private static void hapusDataDokter() {
        if (dokterCount > 0) {
            System.out.println("\n=== Hapus Data Dokter ===");
            System.out.print("Masukkan ID Dokter yang ingin dihapus: ");
            String idDokter = scanner.next();
            int index = -1;
            for (int i = 0; i < dokterCount; i++) {
                if (dokterList[i].getIdDokter().equals(idDokter)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                for (int i = index; i < dokterCount - 1; i++) {
                    dokterList[i] = dokterList[i + 1];
                }
                dokterCount--;
                System.out.println("\n===============================");
                System.out.println("Data Dokter berhasil dihapus.");
            } else {
                System.out.println("\n============================");
                System.out.println("ID Dokter tidak ditemukan.");
            }
        } else {
            System.out.println("\n=================================================");
            System.out.println("Data Dokter kosong. Tidak dapat menghapus data.");
        }
    }

    private static void lihatDataDokter() {
        if (dokterCount > 0) {
            System.out.println("\n=== Data Dokter ===");
            for (int i = 0; i < dokterCount; i++) {
                dokterList[i].tampilkanData();
                System.out.println("-------------------");
            }
        } else {
            System.out.println("\n=====================");
            System.out.println("Data Dokter kosong.");
        }
    }

    private static void menuPasien() {
        int choice;
        do {
            System.out.println("\n=== Menu Pasien ===");
            System.out.println("1. Tambah Data Pasien");
            System.out.println("2. Edit Data Pasien");
            System.out.println("3. Hapus Data Pasien");
            System.out.println("4. Lihat Data Pasien");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tambahDataPasien();
                    break;
                case 2:
                    editDataPasien();
                    break;
                case 3:
                    hapusDataPasien();
                    break;
                case 4:
                    lihatDataPasien();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n======================================");
                    System.out.println("Menu tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (choice != 0);
    }

    private static void tambahDataPasien() {
        if (pasienCount < MAX_SIZE) {
            System.out.println("\n=== Tambah Data Pasien ===");
            System.out.print("Masukkan ID Pasien: ");
            String idPasien = scanner.next();
            scanner.nextLine();
            System.out.print("Masukkan Nama Pasien: ");
            String nama = scanner.nextLine();
            boolean umurValid = false;
            int umur = 0;
            while (!umurValid) {
                System.out.print("Masukkan Umur Pasien: ");
                umur = scanner.nextInt();
                if (umur >= 1 && umur <= 120) {
                    umurValid = true;
                } else {
                    System.out.println("Umur harus antara 1 sampai 120.");
                }
            }
            scanner.nextLine();
            String nomorTelepon = null;
            while (nomorTelepon == null) {
                System.out.print("Masukkan Nomor Telepon Pasien: ");
                String inputTelepon = scanner.next();
                if (inputTelepon.matches("^[0-9]{8,15}$")) {
                    nomorTelepon = inputTelepon;
                } else {
                    System.out.println("Nomor telepon harus antara 8 sampai 15 digit dan hanya berisi angka.");
                }
            }
            String gender = null;
            while (gender == null) {
                System.out.print("Masukkan Gender Pasien: ");
                String inputGender = scanner.next();
                if (inputGender.equalsIgnoreCase("Laki-laki") || inputGender.equalsIgnoreCase("Perempuan")) {
                    gender = inputGender;
                } else {
                    System.out.println("Gender hanya dapat memiliki nilai 'Laki-laki' atau 'Perempuan'.");
                }
            }
            System.out.print("Masukkan Alamat Pasien: ");
            String alamat = scanner.next();
            System.out.print("Masukkan Keluhan Pasien: ");
            String keluhan = scanner.next();
            System.out.print("Masukkan Diagnosa Pasien: ");
            String diagnosa = scanner.next();
    
            boolean idPasienSudahAda = cekDuplikatIdPasien(pasienList, pasienCount, idPasien);
            if (idPasienSudahAda) {
    
                System.out.println("\n=============================");
                System.out.println("Maaf, ID Pasien sudah ada.");
            } else {
                pasienList[pasienCount++] = new Pasien(idPasien, nama, umur, nomorTelepon, gender, alamat, keluhan,
                        diagnosa);
                System.out.println("\n===================================");
                System.out.println("Data Pasien berhasil ditambahkan.");
            }
        } else {
            System.out.println("\n=======================================================");
            System.out.println("Data Pasien penuh. Tidak dapat menambahkan data lagi.");
        }
    }

    private static boolean cekDuplikatIdPasien(Pasien[] daftarPasien, int index, String idPasienBaru) {
        for (int i = 0; i < index; i++) {
            if (daftarPasien[i] != null && daftarPasien[i].getIdPasien().equals(idPasienBaru)) {
                return true;
            }
        }
        return false;
    }

    private static void editDataPasien() {
        if (pasienCount > 0) {
            System.out.println("\n=== Edit Data Pasien ===");
            System.out.print("Masukkan ID Pasien yang ingin diedit: ");
            String idPasien = scanner.next();
            int index = -1;
            for (int i = 0; i < pasienCount; i++) {
                if (pasienList[i].getIdPasien().equals(idPasien)) {
                    index = i;
                    break;
                }
            }
    
            if (index != -1) {
    
                System.out.println("\nData Saat Ini:");
                pasienList[index].tampilkanData();
    
                System.out.println("\n=== Masukkan Data Baru ===");
                System.out.print("Masukkan Nama Baru: ");
                String nama = scanner.next();
                boolean umurValid = false;
                int umur = 0;
                while (!umurValid) {
                    System.out.print("Masukkan Umur Baru: ");
                    umur = scanner.nextInt();
                    if (umur >= 1 && umur <= 120) {
                        umurValid = true;
                    } else {
                        System.out.println("Umur harus antara 1 sampai 120.");
                    }
                }
                scanner.nextLine();
                String nomorTelepon = null;
                while (nomorTelepon == null) {
                    System.out.print("Masukkan Nomor Telepon Baru: ");
                    String inputTelepon = scanner.next();
                    if (inputTelepon.matches("^[0-9]{8,15}$")) {
                        nomorTelepon = inputTelepon;
                    } else {
                        System.out.println("Nomor telepon harus antara 8 sampai 15 digit dan hanya berisi angka.");
                    }
                }
                String gender = null;
                while (gender == null) {
                    System.out.print("Masukkan Gender Baru: ");
                    String inputGender = scanner.next();
                    if (inputGender.equalsIgnoreCase("Laki-laki") || inputGender.equalsIgnoreCase("Perempuan")) {
                        gender = inputGender;
                                  } else {
                        System.out.println("Gender hanya dapat memiliki nilai 'Laki-laki' atau 'Perempuan'.");
                    }
                }
                System.out.print("Masukkan Alamat Baru: ");
                String alamat = scanner.next();
                System.out.print("Masukkan Keluhan Baru: ");
                String keluhan = scanner.next();
                System.out.print("Masukkan Diagnosa Baru: ");
                String diagnosa = scanner.next();
    
                pasienList[index] = new Pasien(idPasien, nama, umur, nomorTelepon, gender, alamat, keluhan, diagnosa);
                System.out.println("\n==============================");
                System.out.println("Data Pasien berhasil diubah.");
    
            } else {
                System.out.println("\n============================");
                System.out.println("ID Pasien tidak ditemukan.");
            }
        } else {
            System.out.println("\n================================================");
            System.out.println("Data Pasien kosong. Tidak dapat mengedit data.");
        }
    }

    private static void hapusDataPasien() {
        if (pasienCount > 0) {
            System.out.println("\n=== Hapus Data Pasien ===");
            System.out.print("Masukkan ID Pasien yang ingin dihapus: ");
            String idPasien = scanner.next();
            int index = -1;
            for (int i = 0; i < pasienCount; i++) {
                if (pasienList[i].getIdPasien().equals(idPasien)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                for (int i = index; i < pasienCount - 1; i++) {
                    pasienList[i] = pasienList[i + 1];
                }
                pasienCount--;
                System.out.println("\n===============================");
                System.out.println("Data Pasien berhasil dihapus.");
            } else {
                System.out.println("\n============================");
                System.out.println("ID Pasien tidak ditemukan.");
            }
        } else {
            System.out.println("\n=================================================");
            System.out.println("Data Pasien kosong. Tidak dapat menghapus data.");
        }
    }

    private static void lihatDataPasien() {
        if (pasienCount > 0) {
            System.out.println("\n=== Data Pasien ===");
            for (int i = 0; i < pasienCount; i++) {
                pasienList[i].tampilkanData();
                System.out.println("-------------------");
            }
        } else {
            System.out.println("\n=====================");
            System.out.println("Data Pasien kosong.");
        }
    }

    private static void menuPerawat() {
        int choice;
        do {
            System.out.println("\n=== Menu Perawat ===");
            System.out.println("1. Tambah Data Perawat");
            System.out.println("2. Edit Data Perawat");
            System.out.println("3. Hapus Data Perawat");
            System.out.println("4. Lihat Data Perawat");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tambahDataPerawat();
                    break;
                case 2:
                    editDataPerawat();
                    break;
                case 3:
                    hapusDataPerawat();
                    break;
                case 4:
                    lihatDataPerawat();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n==========================================");
                    System.out.println("Menu tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (choice != 0);
    }

    private static void tambahDataPerawat() {
        if (perawatCount < MAX_SIZE) {
            System.out.println("\n=== Tambah Data Perawat ===");
            System.out.print("Masukkan ID Perawat: ");
            String idPerawat = scanner.next();
            scanner.nextLine();
            System.out.print("Masukkan Nama Perawat: ");
            String nama = scanner.nextLine();
            boolean umurValid = false;
            int umur = 0;
            while (!umurValid) {
                System.out.print("Masukkan Umur Perawat: ");
                umur = scanner.nextInt();
                if (umur >= 21 && umur <= 55) {
                    umurValid = true;
                } else {
                    System.out.println("Umur harus antara 21 sampai 55.");
                }
            }
            scanner.nextLine();
            String nomorTelepon = null;
            while (nomorTelepon == null) {
                System.out.print("Masukkan Nomor Telepon Perawat: ");
                String inputTelepon = scanner.next();
                if (inputTelepon.matches("^[0-9]{8,15}$")) {
                    nomorTelepon = inputTelepon;
                } else {
                    System.out.println("Nomor telepon harus antara 8 sampai 15 digit dan hanya berisi angka.");
                }
            }
            String gender = null;
            while (gender == null) {
                System.out.print("Masukkan Gender Perawat: ");
                String inputGender = scanner.next();
                if (inputGender.equalsIgnoreCase("Laki-laki") || inputGender.equalsIgnoreCase("Perempuan")) {
                    gender = inputGender;
                } else {
                    System.out.println("Gender hanya dapat memiliki nilai 'Laki-laki' atau 'Perempuan'.");
                }
            }
            System.out.print("Masukkan Alamat Perawat: ");
            String alamat = scanner.next();
            System.out.print("Masukkan Waktu Jaga Perawat: ");
            String waktuJaga = scanner.next();
    
            boolean idPerawatSudahAda = cekDuplikatIdPerawat(perawatList, perawatCount, idPerawat);
            if (idPerawatSudahAda) {
                System.out.println("\n=============================");
                System.out.println("Maaf, ID Perawat sudah ada.");
            } else {
                perawatList[perawatCount++] = new Perawat(idPerawat, nama, umur, nomorTelepon, gender, alamat,
                        waktuJaga);
                System.out.println("\n====================================");
                System.out.println("Data Perawat berhasil ditambahkan.");
            }
        } else {
            System.out.println("\n========================================================");
            System.out.println("Data Perawat penuh. Tidak dapat menambahkan data lagi.");
        }
    }

    private static boolean cekDuplikatIdPerawat(Perawat[] daftarPerawat, int index, String idPerawatBaru) {
        for (int i = 0; i < index; i++) {
            if (daftarPerawat[i] != null && daftarPerawat[i].getIdPerawat().equals(idPerawatBaru)) {
                return true;
            }
        }
        return false;
    }

    private static void editDataPerawat() {
        if (perawatCount > 0) {
            System.out.println("\n=== Edit Data Perawat ===");
            System.out.print("Masukkan ID Perawat yang ingin diedit: ");
            String idPerawat = scanner.next();
            int index = -1;
            for (int i = 0; i < perawatCount; i++) {
                if (perawatList[i].getIdPerawat().equals(idPerawat)) {
                    index = i;
                    break;
                }
            }
    
            if (index != -1) {
    
                System.out.println("\nData Saat Ini:");
                perawatList[index].tampilkanData();
    
                System.out.println("\n=== Masukkan Data Baru ===");
                System.out.print("Masukkan Nama Baru: ");
                String nama = scanner.next();
                boolean umurValid = false;
                int umur = 0;
                while (!umurValid) {
                    System.out.print("Masukkan Umur Baru: ");
                    umur = scanner.nextInt();
                    if (umur >= 21 && umur <= 55) {
                        umurValid = true;
                    } else {
                        System.out.println("Umur harus antara 21 sampai 55.");
                    }
                }
                scanner.nextLine();
                String nomorTelepon = null;
                while (nomorTelepon == null) {
                    System.out.print("Masukkan Nomor Telepon Baru: ");
                    String inputTelepon = scanner.next();
                    if (inputTelepon.matches("^[0-9]{8,15}$")) {
                        nomorTelepon = inputTelepon;
                    } else {
                        System.out.println("Nomor telepon harus antara 8 sampai 15 digit dan hanya berisi angka.");
                    }
                }
                String gender = null;
                while (gender == null) {
                    System.out.print("Masukkan Gender Baru: ");
                    String inputGender = scanner.next();
                    if (inputGender.equalsIgnoreCase("Laki-laki") || inputGender.equalsIgnoreCase("Perempuan")) {
                        gender = inputGender;
                    } else {
                        System.out.println("Gender hanya dapat memiliki nilai 'Laki-laki' atau 'Perempuan'.");
                    }
                }
                System.out.print("Masukkan Alamat Baru: ");
                String alamat = scanner.next();
                System.out.print("Masukkan Waktu Jaga Baru: ");
                String waktuJaga = scanner.next();
    
                perawatList[index] = new Perawat(idPerawat, nama, umur, nomorTelepon, gender, alamat, waktuJaga);
                System.out.println("\n===============================");
                System.out.println("Data Perawat berhasil diubah.");
    
            } else {
                System.out.println("\n=============================");
                System.out.println("ID Perawat tidak ditemukan.");
            }
        } else {
            System.out.println("\n=================================================");
            System.out.println("Data Perawat kosong. Tidak dapat mengedit data.");
        }
    }

    private static void hapusDataPerawat() {
        if (perawatCount > 0) {
            System.out.println("\n=== Hapus Data Perawat ===");
            System.out.print("Masukkan ID Perawat yang ingin dihapus: ");
            String idPerawat = scanner.next();
            int index = -1;
            for (int i = 0; i < perawatCount; i++) {
                if (perawatList[i].getIdPerawat().equals(idPerawat)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                for (int i = index; i < perawatCount - 1; i++) {
                    perawatList[i] = perawatList[i + 1];
                }
                perawatCount--;
                System.out.println("\n================================");
                System.out.println("Data Perawat berhasil dihapus.");
            } else {
                System.out.println("\n=============================");
                System.out.println("ID Perawat tidak ditemukan.");
            }
        } else {
            System.out.println("\n==================================================");
            System.out.println("Data Perawat kosong. Tidak dapat menghapus data.");
        }
    }

    private static void lihatDataPerawat() {
        if (perawatCount > 0) {
            System.out.println("\n=== Data Perawat ===");
            for (int i = 0; i < perawatCount; i++) {
                perawatList[i].tampilkanData();
                System.out.println("-------------------");
            }
        } else {
            System.out.println("\n======================");
            System.out.println("Data Perawat kosong.");
        }
    }

    private static void menuInfoRS() {
        int choice;
        do {
            System.out.println("\n=== Menu InfoRS ===");
            System.out.println("1. Tambah Data InfoRS");
            System.out.println("2. Edit Data InfoRS");
            System.out.println("3. Hapus Data InfoRS");
            System.out.println("4. Lihat Data InfoRS");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tambahDataInfoRS();
                    break;
                case 2:
                    editDataInfoRS();
                    break;
                case 3:
                    hapusDataInfoRS();
                    break;
                case 4:
                    lihatDataInfoRS();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n======================================");
                    System.out.println("Menu tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (choice != 0);
    }

    private static void tambahDataInfoRS() {
        if (infoRSCount < MAX_SIZE) {
            System.out.println("\n=== Tambah Data InfoRS ===");
            System.out.print("Masukkan ID RS: ");
            String idRS = scanner.next();
            scanner.nextLine();
            System.out.print("Masukkan Nama RS: ");
            String namaRS = scanner.nextLine();
            System.out.print("Masukkan Alamat RS: ");
            String alamat = scanner.nextLine();
            System.out.print("Masukkan Nomor Telepon RS: ");
            String nomorTelepon = scanner.next();
            boolean nomorTeleponValid = false;
            while (!nomorTeleponValid) {
                if (nomorTelepon.matches("^[0-9]{8,15}$")) {
                    nomorTeleponValid = true;
                } else {
                    System.out.println("Nomor telepon harus antara 8 sampai 15 digit dan hanya berisi angka.");
                    System.out.print("Masukkan Nomor Telepon RS: ");
                    nomorTelepon = scanner.next();
                }
            }
            System.out.print("Masukkan Jumlah Dokter RS: ");
            int jumlahDokter = scanner.nextInt();
            System.out.print("Masukkan Jumlah Perawat RS: ");
            int jumlahPerawat = scanner.nextInt();
            System.out.print("Masukkan Jumlah Pasien RS: ");
            int jumlahPasien = scanner.nextInt();
    
            boolean idRSSudahAda = cekDuplikatIdRS(infoRSList, infoRSCount, idRS);
            if (idRSSudahAda) {
                System.out.println("\n========================");
                System.out.println("Maaf, ID RS sudah ada.");
            } else {
                InfoRS newInfoRS = new InfoRS(idRS, namaRS, alamat, nomorTelepon, jumlahDokter, jumlahPerawat,
                        jumlahPasien);
                infoRSList[infoRSCount++] = newInfoRS;
                System.out.println("\n===================================");
                System.out.println("Data InfoRS berhasil ditambahkan.");
            }
        } else {
            System.out.println("\n=======================================================");
            System.out.println("Data InfoRS penuh. Tidak dapat menambahkan data lagi.");
        }
    }

    private static boolean cekDuplikatIdRS(InfoRS[] daftarInfoRS, int index, String idRSBaru) {
        for (int i = 0; i < index; i++) {
            if (daftarInfoRS[i] != null && daftarInfoRS[i].getIdRS().equals(idRSBaru)) {
                return true;
            }
        }
        return false;
    }

    private static void editDataInfoRS() {
        if (infoRSCount > 0) {
            System.out.println("\n=== Edit Data InfoRS ===");
            System.out.print("Masukkan ID RS yang ingin diedit: ");
            String idRS = scanner.next();
            int index = -1;
            for (int i = 0; i < infoRSCount; i++) {
                if (infoRSList[i].getIdRS().equals(idRS)) {
                    index = i;
                    break;
                }
            }
    
            if (index != -1) {
    
                System.out.println("\nData Saat Ini:");
                infoRSList[index].tampilkanData();
    
                System.out.println("\n=== Masukkan Data Baru ===");
                System.out.print("Masukkan Nama RS Baru: ");
                String namaRS = scanner.next();
                System.out.print("Masukkan Alamat Baru: ");
                String alamat = scanner.next();
                System.out.print("Masukkan Nomor Telepon Baru: ");
                String nomorTelepon = scanner.next();
                boolean nomorTeleponValid = false;
                while (!nomorTeleponValid) {
                    if (nomorTelepon.matches("^[0-9]{8,15}$")) {
                        nomorTeleponValid = true;
                    } else {
                        System.out.println("Nomor telepon harus antara 8 sampai 15 digit dan hanya berisi angka.");
                        System.out.print("Masukkan Nomor Telepon Baru: ");
                        nomorTelepon = scanner.next();
                    }
                }
                System.out.print("Masukkan Jumlah Dokter Baru: ");
                int jumlahDokter = scanner.nextInt();
                System.out.print("Masukkan Jumlah Perawat Baru: ");
                int jumlahPerawat = scanner.nextInt();
                System.out.print("Masukkan Jumlah Pasien Baru: ");
                int jumlahPasien = scanner.nextInt();
    
                infoRSList[index] = new InfoRS(idRS, namaRS, alamat, nomorTelepon, jumlahDokter, jumlahPerawat,
                        jumlahPasien);
                System.out.println("\n==============================");
                System.out.println("Data InfoRS berhasil diubah.");
    
            } else {
                System.out.println("\n========================");
                System.out.println("ID RS tidak ditemukan.");
            }
        } else {
            System.out.println("\n================================================");
            System.out.println("Data InfoRS kosong. Tidak dapat mengedit data.");
        }
    }

    private static void hapusDataInfoRS() {
        if (infoRSCount > 0) {
            System.out.println("\n=== Hapus Data InfoRS ===");
            System.out.print("Masukkan ID RS yang ingin dihapus: ");
            String idRS = scanner.next();
            int index = -1;
            for (int i = 0; i < infoRSCount; i++) {
                if (infoRSList[i].getIdRS().equals(idRS)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                for (int i = index; i < infoRSCount - 1; i++) {
                    infoRSList[i] = infoRSList[i + 1];
                }
                infoRSCount--;
                System.out.println("\n===============================");
                System.out.println("Data InfoRS berhasil dihapus.");
            } else {
                System.out.println("\n========================");
                System.out.println("ID RS tidak ditemukan.");
            }
        } else {
            System.out.println("\n=================================================");
            System.out.println("Data InfoRS kosong. Tidak dapat menghapus data.");
        }
    }

    private static void lihatDataInfoRS() {
        if (infoRSCount > 0) {
            System.out.println("\n=== Data InfoRS ===");
            for (int i = 0; i < infoRSCount; i++) {
                infoRSList[i].tampilkanData();
                System.out.println("-------------------");
            }
        } else {
            System.out.println("\n=====================");
            System.out.println("Data InfoRS kosong.");
        }
    }

    private static void menuKunjungan() {
        int choice;
        do {
            System.out.println("\n=== Menu Kunjungan ===");
            System.out.println("1. Tambah Data Kunjungan");
            System.out.println("2. Edit Data Kunjungan");
            System.out.println("3. Hapus Data Kunjungan");
            System.out.println("4. Lihat Data Kunjungan");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tambahDataKunjungan();
                    break;
                case 2:
                    editDataKunjungan();
                    break;
                case 3:
                    hapusDataKunjungan();
                    break;
                case 4:
                    lihatDataKunjungan();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n==========================================");
                    System.out.println("Menu tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (choice != 0);
    }

    private static void tambahDataKunjungan() {
        if (kunjunganCount < MAX_SIZE) {
            System.out.println("\n=== Tambah Data Kunjungan ===");
            System.out.print("Masukkan ID Kunjungan: ");
            String idKunjungan = scanner.next();
            scanner.nextLine();
            System.out.print("Masukkan Nama RS Kunjungan: ");
            String namaRS = scanner.nextLine();
            System.out.print("Masukkan Alamat RS Kunjungan: ");
            String alamat = scanner.nextLine();
            System.out.print("Masukkan Nomor Telepon RS Kunjungan: ");
            String nomorTelepon = scanner.next();
            boolean nomorTeleponValid = false;
            while (!nomorTeleponValid) {
                if (nomorTelepon.matches("^[0-9]{8,15}$")) {
                    nomorTeleponValid = true;
                } else {
                    System.out.println("Nomor telepon harus antara 8 sampai 15 digit dan hanya berisi angka.");
                    System.out.print("Masukkan Nomor Telepon RS Kunjungan: ");
                    nomorTelepon = scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Masukkan Nama Pasien Kunjungan: ");
            String namaPasien = scanner.nextLine();
            System.out.print("Masukkan Nama Dokter Kunjungan: ");
            String namaDokter = scanner.nextLine();
            System.out.print("Masukkan Tujuan Kunjungan: ");
            String tujuan = scanner.nextLine();
            System.out.print("Masukkan Tanggal Kunjungan: ");
            String tanggalKunjungan = scanner.nextLine();
    
            boolean idKunjunganSudahAda = cekDuplikatIdKunjungan(kunjunganList, kunjunganCount, idKunjungan);
            if (idKunjunganSudahAda) {
                System.out.println("\n===============================");
                System.out.println("Maaf, ID Kunjungan sudah ada.");
            } else {
                kunjunganList[kunjunganCount++] = new Kunjungan(idKunjungan, namaRS, alamat, nomorTelepon, namaPasien,
                        namaDokter, tujuan, tanggalKunjungan);
                System.out.println("\n======================================");
                System.out.println("Data Kunjungan berhasil ditambahkan.");
            }
        } else {
            System.out.println("\n==========================================================");
            System.out.println("Data Kunjungan penuh. Tidak dapat menambahkan data lagi.");
        }
    }

    private static boolean cekDuplikatIdKunjungan(Kunjungan[] daftarKunjungan, int index, String idKunjunganBaru) {
        for (int i = 0; i < index; i++) {
            if (daftarKunjungan[i] != null && daftarKunjungan[i].getIdKunjungan().equals(idKunjunganBaru)) {
                return true;
            }
        }
        return false;
    }

    private static void editDataKunjungan() {
        if (kunjunganCount > 0) {
            System.out.println("\n=== Edit Data Kunjungan ===");
            System.out.print("Masukkan ID Kunjungan yang ingin diedit: ");
            String idKunjungan = scanner.next();
            int index = -1;
            for (int i = 0; i < kunjunganCount; i++) {
                if (kunjunganList[i].getIdKunjungan().equals(idKunjungan)) {
                    index = i;
                    break;
                }
            }
    
            if (index != -1) {
                System.out.println("\nData Saat Ini:");
                kunjunganList[index].tampilkanData();
    
                System.out.println("\n=== Masukkan Data Baru ===");
                System.out.print("Masukkan Nama RS Baru Kunjungan: ");
                String namaRS = scanner.next();
                System.out.print("Masukkan Alamat Baru Kunjungan: ");
                String alamat = scanner.next();
                String nomorTelepon = "";
                boolean nomorTeleponValid = false;
                while (!nomorTeleponValid) {
                    System.out.print("Masukkan Nomor Telepon Baru Kunjungan: ");
                    nomorTelepon = scanner.next();
                    nomorTeleponValid = nomorTelepon.matches("^[0-9]{8,15}$");
                    if (!nomorTeleponValid) {
                        System.out.println("Nomor telepon harus antara 8 sampai 15 digit dan hanya berisi angka.");
                    }
                }
    
                System.out.print("Masukkan Nama Pasien Baru Kunjungan: ");
                String namaPasien = scanner.next();
                System.out.print("Masukkan Nama Dokter Baru Kunjungan: ");
                String namaDokter = scanner.next();
                System.out.print("Masukkan Tujuan Baru Kunjungan: ");
                String tujuan = scanner.next();
                System.out.print("Masukkan Tanggal Baru Kunjungan: ");
                String tanggalKunjungan = scanner.next();
    
                kunjunganList[index] = new Kunjungan(idKunjungan, namaRS, alamat,
                        nomorTelepon, namaPasien, namaDokter, tujuan, tanggalKunjungan);
                System.out.println("\n=================================");
                System.out.println("Data Kunjungan berhasil diubah.");
            } else {
                System.out.println("\n===============================");
                System.out.println("ID Kunjungan tidak ditemukan.");
            }
        } else {
            System.out.println("\n===================================================");
            System.out.println("Data Kunjungan kosong. Tidak dapat mengedit data.");
        }
    }

    private static void hapusDataKunjungan() {
        if (kunjunganCount > 0) {
            System.out.println("\n=== Hapus Data Kunjungan ===");
            System.out.print("Masukkan ID Kunjungan yang ingin dihapus: ");
            String idKunjungan = scanner.next();
            int index = -1;
            for (int i = 0; i < kunjunganCount; i++) {
                if (kunjunganList[i].getIdKunjungan().equals(idKunjungan)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                for (int i = index; i < kunjunganCount - 1; i++) {
                    kunjunganList[i] = kunjunganList[i + 1];
                }
                kunjunganCount--;
                System.out.println("\n==================================");
                System.out.println("Data Kunjungan berhasil dihapus.");
            } else {
                System.out.println("\n===============================");
                System.out.println("ID Kunjungan tidak ditemukan.");
            }
        } else {
            System.out.println("\n====================================================");
            System.out.println("Data Kunjungan kosong. Tidak dapat menghapus data.");
        }
    }

    private static void lihatDataKunjungan() {
        if (kunjunganCount > 0) {
            System.out.println("\n=== Data Kunjungan ===");
            for (int i = 0; i < kunjunganCount; i++) {
                kunjunganList[i].tampilkanData();
                System.out.println("-------------------");
            }
        } else {
            System.out.println("\n========================");
            System.out.println("Data Kunjungan kosong.");
        }
    }
}