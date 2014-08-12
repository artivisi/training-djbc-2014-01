/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.domain;

/**
 *
 * @author CEISA13
 */
public class Pegawai {
     // class variable -> static
    private static Integer jumlahPegawai = 0;
    
    
    // instance variable
    private Integer id;
    private String nama;
    private String divisi;
    
    // static method
    public static Integer getJumlahPegawai(){
        // id = 100; // instance variabel tidak bisa dipakai dalam static method
        return jumlahPegawai;
    }
    
    // instance method
    public void tambahPegawai(){
        // static variabel boleh dipakai dalam instance method
        jumlahPegawai = jumlahPegawai + 1;
    }
    public Integer getId() {
        return this.id;
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

    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }
}

