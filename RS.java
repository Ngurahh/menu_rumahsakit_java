package rumahSakit;

public class RS {
    private String namaRS;
    private String alamatRS;
    private String nomorTeleponRS;

    public RS(String namaRS, String alamatRS, String nomorTeleponRS) {
        this.namaRS = namaRS;
        this.alamatRS = alamatRS;
        this.nomorTeleponRS = nomorTeleponRS;
    }

    public String getNamaRS() {
        return namaRS;
    }

    public String getAlamatRS() {
        return alamatRS;
    }

    public String getNomorTeleponRS() {
        return nomorTeleponRS;
    }

    public void tampilkanData() {
        System.out.println("Nama RS: " + namaRS);
        System.out.println("Alamat RS: " + alamatRS);
        System.out.println("Nomor Telepon RS: " + nomorTeleponRS);
    }
}
