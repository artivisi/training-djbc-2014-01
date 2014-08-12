/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.lisma.aplikasi_barang;

/**
 *
 * @author CEISA 30
 */
public class Gudang {
     private Integer id;
     private String kode;
     private String nama;
     private String alamat;
     private String keterangan;
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
     public String getAlamat() {
     return alamat;
     }
     public void setAlamat(String alamat) {
     this.alamat = alamat;
     }
     public String getKeterangan() {
     return keterangan;
     }
     public void setKeterangan(String keterangan) {
     this.keterangan = keterangan;
     }
}
