/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;

/**
 *
 * @author endy
 */
public class BarangDemo {
    public static void main(String[] args) {
        // untuk memanggil static method, tidak perlu ada instance
        System.out.println("Jumlah barang : " + Barang.getJumlahBarang());
        
        Barang b1; // deklarasi variabel
        b1 = new Barang();  // inisialisasi variabel
        b1.tambahBarang();
        
        Barang b2 = new Barang(); // deklarasi + inisialisasi
        String nama = "endy";
        b1.tambahBarang();
        
        // isi data b1
        b1.setId(100);
        b1.setKode("H-001");
        b1.setNama("Handphone");
        b1.setKeterangan("Handphone Android");
        
        // isi data b2
        b2.setId(200);
        b2.setKode("");
        
        Barang b3 = new Barang();
        
        // tampilkan data
        System.out.println("ID Barang b1 : "+b1.getId());
        System.out.println("Kode Barang b1 : "+b1.getKode());
        System.out.println("Nama Barang b1 : "+b1.getNama());
        System.out.println("Jumlah Barang : "+b1.getJumlahBarang());

        System.out.println("ID Barang b2 : "+b2.getId());
        System.out.println("Kode Barang b2 : "+b2.getKode());
        System.out.println("Nama Barang b2 : "+b2.getNama());
        System.out.println("Jumlah Barang : "+b2.getJumlahBarang());
        
        System.out.println("Jumlah Barang : "+b3.getJumlahBarang());
    }
}
