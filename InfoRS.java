package rumahSakit;

public class InfoRS extends RS {
    private String idRS;
    private int jumlahDokter;
    private int jumlahPerawat;
    private int jumlahPasien;

    public InfoRS(String idRS, String namaRS, String alamatRS, String nomorTeleponRS,
    int jumlahDokter, int jumlahPerawat, int jumlahPasien) {
        super(namaRS, alamatRS, nomorTeleponRS);
        this.idRS = idRS;
        this.jumlahDokter = jumlahDokter;
        this.jumlahPerawat = jumlahPerawat;
        this.jumlahPasien = jumlahPasien;
    }

    public String getIdRS() {
        return idRS;
    }

    public int getJumlahDokter() {
        return jumlahDokter;
    }

    public int getJumlahPerawat() {
        return jumlahPerawat;
    }

    public int getJumlahPasien() {
        return jumlahPasien;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("ID RS: " + idRS);
        System.out.println("Jumlah Dokter: " + jumlahDokter);
        System.out.println("Jumlah Perawat: " + jumlahPerawat);
        System.out.println("Jumlah Pasien: " + jumlahPasien);
    }
}

