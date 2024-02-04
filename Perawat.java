package rumahSakit;

public class Perawat extends Orang {
    private String idPerawat;
    private String waktuJaga;

    public Perawat(String idPerawat, String nama, int umur, String nomorTelepon, String gender, String alamat,
                   String waktuJaga) {
        super(nama, umur, nomorTelepon, gender, alamat);
        this.idPerawat = idPerawat;
        this.waktuJaga = waktuJaga;
    }

    public String getIdPerawat() {
        return idPerawat;
    }

    public String getWaktuJaga() {
        return waktuJaga;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("ID Perawat: " + idPerawat);
        System.out.println("Waktu Jaga: " + waktuJaga);
    }
}

