package rumahSakit;

public class Dokter extends Orang {
    private String idDokter;
    private String spesialisasi;
    private String waktuPraktek;

    public Dokter(String idDokter, String nama, int umur, String nomorTelepon, String gender, String alamat,
                  String spesialisasi, String waktuPraktek) {
        super(nama, umur, nomorTelepon, gender, alamat);
        this.idDokter = idDokter;
        this.spesialisasi = spesialisasi;
        this.waktuPraktek = waktuPraktek;
    }

    public String getIdDokter() {
        return idDokter;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public String getWaktuPraktek() {
        return waktuPraktek;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("ID Dokter: " + idDokter);
        System.out.println("Spesialisasi: " + spesialisasi);
        System.out.println("Waktu Praktek: " + waktuPraktek);
    }
}

