/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.domain;

/**
 *
 * @author CEISA7
 */
public class Vendor {
    private static Integer barangDatang = 0;
    
    private Integer id;
    private String nama;
    private String alamat;
    private String produk;

    public static Integer getBarangDatang() {
    return barangDatang;}
    
    
    public void total(){
    barangDatang = barangDatang + 1 ;}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }
    
    
    


    
}
