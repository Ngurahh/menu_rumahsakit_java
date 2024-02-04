package rumahSakit;

public class Kunjungan extends RS {
    private String idKunjungan;
    private String namaPasien;
    private String namaDokter;
    private String tujuan;
    private String tanggalKunjungan;

    public Kunjungan(String idKunjungan,String namaRS, String alamatRS, String nomorTeleponRS,
    String namaPasien, String namaDokter, String tujuan, String tanggalKunjungan) {
        super(namaRS, alamatRS, nomorTeleponRS);
        this.idKunjungan = idKunjungan;
        this.namaPasien = namaPasien;
        this.namaDokter = namaDokter;
        this.tujuan = tujuan;
        this.tanggalKunjungan = tanggalKunjungan;
    }

    public String getIdKunjungan() {
        return idKunjungan;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public String getTujuan() {
        return tujuan;
    }

    public String getTanggalKunjungan() {
        return tanggalKunjungan;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("ID Kunjungan: " + idKunjungan);
        System.out.println("Nama Pasien: " + namaPasien);
        System.out.println("Nama Dokter: " + namaDokter);
        System.out.println("Tujuan: " + tujuan);
        System.out.println("Tanggal Kunjungan: " + tanggalKunjungan);
    }
}


