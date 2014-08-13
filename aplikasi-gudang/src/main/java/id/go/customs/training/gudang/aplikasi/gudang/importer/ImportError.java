package id.go.customs.training.gudang.aplikasi.gudang.importer;

public class ImportError {
    private Integer baris;
    private String keterangan;
    private String data;

    public Integer getBaris() {
        return baris;
    }

    public void setBaris(Integer baris) {
        this.baris = baris;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
}
