package rumahSakit;

public class Pasien extends Orang {
    private String idPasien;
    private String keluhan;
    private String diagnosa;

    public Pasien(String idPasien, String nama, int umur, String nomorTelepon, String gender, String alamat,
                  String keluhan, String diagnosa) {
        super(nama, umur, nomorTelepon, gender, alamat);
        this.idPasien = idPasien;
        this.keluhan = keluhan;
        this.diagnosa = diagnosa;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("ID Pasien: " + idPasien);
        System.out.println("Keluhan: " + keluhan);
        System.out.println("Diagnosa: " + diagnosa);
    }
}

