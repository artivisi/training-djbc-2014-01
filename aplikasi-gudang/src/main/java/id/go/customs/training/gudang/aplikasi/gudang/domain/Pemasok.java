/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.domain;

/**
     *
 * @author Admin
 */
public class Pemasok {
    private static Integer jumlahPemasok = 0;
    
      
    private String kodePemasok;
    private String namaPemasok;
    private String telepon;
    private String alamat;

 public static Integer getjumlahPemasok(){
     return jumlahPemasok;
 }
  public void tambahPemasok(){
        jumlahPemasok = jumlahPemasok+1;
    }
    
    
    public String getKodePemasok() {
        return kodePemasok;
    }

    public void setKodePemasok(String kodePemasok) {
        this.kodePemasok = kodePemasok;
    }

    public String getNamaPemasok() {
        return namaPemasok;
    }

    public void setNamaPemasok(String namaPemasok) {
        this.namaPemasok = namaPemasok;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

   
}
