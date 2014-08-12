package id.go.customs.lisma.aplikasi_barang;

/**
 * Hello world!
 *
 */
public class Barang
{
    private static Integer jumlahBarang = 0;
    // instance variable
    private Integer id;
    private String kode;
    private String nama;
    private String keterangan;
    // static method
    public static Integer getJumlahBarang(){
    // id = 100; // instance variabel tidak bisa dipakai dalam static method
    return jumlahBarang;
    }
    // instance method
    public void tambahBarang(){
    // static variabel boleh dipakai dalam instance method
    jumlahBarang = jumlahBarang + 1;
    }
    public Integer getId() {
    return this.id;
    }
    public void setId(Integer id) {
    this.id = id;
    }
    public String getKode() {
    return kode;
    }
    public void setKode(String kode) {
    this.kode = kode;
    }
    public String getNama() {
    return nama;
    }
    public void setNama(String nama) {
    this.nama = nama;
    }
    public String getKeterangan() {
    return keterangan;
    }
    public void setKeterangan(String keterangan) {
    this.keterangan = keterangan;
    }
}
