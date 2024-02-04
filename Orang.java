package rumahSakit;

public class Orang {
    private String nama;
    private int umur;
    private String nomorTelepon;
    private String gender;
    private String alamat;

    public Orang(String nama, int umur, String nomorTelepon, String gender, String alamat) {
        this.nama = nama;
        this.umur = umur;
        this.nomorTelepon = nomorTelepon;
        this.gender = gender;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public String getGender() {
        return gender;
    }

    public String getAlamat() {
        return alamat;
    }

    public void tampilkanData() {
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
        System.out.println("Nomor Telepon: " + nomorTelepon);
        System.out.println("Gender: " + gender);
        System.out.println("Alamat: " + alamat);
    }
}
