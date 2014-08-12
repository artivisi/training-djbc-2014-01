/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;


import id.go.customs.training.gudang.aplikasi.gudang.domain.BarangMasuk;

/**
 *
 * @author CEISA18
 */
public class BarangMasukDemo {
    public static void main(String[] args) {
        System.out.println("Total barang masuk: " + BarangMasuk.getTotalBarangMasuk());
        
        BarangMasuk b1; // deklarasi variabel
        b1 = new BarangMasuk();  // inisialisasi variabel
        b1.tambahBarang();
        
        BarangMasuk b2 = new BarangMasuk(); // deklarasi + inisialisasi
        String nama = "Eva";
        b1.tambahBarang();
        
        // isi data b1
        b1.setId(100);
       // b1.getTgl("12 Agustus 2014");
        b1.setKode("H-001");
        b1.setNama("Handphone");
        b1.setKeterangan("Handphone Android");
        b1.setJumlah(20);
       
        // isi data b2
        b2.setId(200);
        b2.setKode("H-002");
        b2.setNama("Camera");
        b1.setKeterangan("Camera Samsung");
        
        BarangMasuk b3 = new BarangMasuk();
        
        // tampilkan data
        System.out.println("ID Barang b1 : "+b1.getId());
        System.out.println("Kode Barang b1 : "+b1.getKode());
        System.out.println("Nama Barang b1 : "+b1.getNama());
        System.out.println("Jumlah Barang : "+BarangMasuk.getTotalBarangMasuk());

        System.out.println("ID Barang b2 : "+b2.getId());
        System.out.println("Kode Barang b2 : "+b2.getKode());
        System.out.println("Nama Barang b2 : "+b2.getNama());
        System.out.println("Jumlah Barang : "+BarangMasuk.getTotalBarangMasuk());
       
    }
    }
    
