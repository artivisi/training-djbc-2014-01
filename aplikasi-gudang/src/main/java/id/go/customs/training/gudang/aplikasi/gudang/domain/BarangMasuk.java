/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.domain;

/**
 *
 * @author CEISA18
 */
public class BarangMasuk {
    private static Integer jumlahBarangMasuk = 0;
    
    private Integer id;
    //private Long tgl;
    private String kode;
    private String nama;
    private Integer jumlah;
    private String keterangan;

    public static Integer getJumlahBarangMasuk() {
        return jumlahBarangMasuk;
    }

    public static void setJumlahBarangMasuk(Integer jumlahBarangMasuk) {
        BarangMasuk.jumlahBarangMasuk = jumlahBarangMasuk;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
        
  public static Integer getTotalBarangMasuk(){
        return jumlahBarangMasuk;
        }
  
  public void tambahBarang(){
      jumlahBarangMasuk = jumlahBarangMasuk +1;
  }
  
    public Integer getId() {
        return id;
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
