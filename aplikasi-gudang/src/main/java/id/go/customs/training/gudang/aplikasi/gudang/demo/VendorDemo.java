/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Vendor;

/**
 *
 * @author CEISA7
 */
public class VendorDemo {
    public static void main(String[] args) {
        
        Vendor v1;
        v1 = new Vendor ();
        
        Vendor v2;
        v2 = new Vendor();
        
        
        v1.setId(001);
        v1.setNama("Toshiba");
        v1.setAlamat("Japan");
        v1.setProduk("TV");
        v1.setJumlah(10);
        
        v2.setId(002);
        v2.setNama("Samsung");
        v2.setAlamat("South Korea");
        v2.setProduk("Tablet");
        v2.setJumlah(5);
        
        
        System.out.println("Id Vendor :" +v1.getId());
        System.out.println("Nama Vendor :" +v1.getNama());
        System.out.println("Alamat Vendor :" +v1.getAlamat());
        System.out.println("Produk :" +v1.getProduk());
        System.out.println("Jumlah Barang :" +v1.getJumlah());
        
        
        
        System.out.println("Id Vendor :" +v2.getId());
        System.out.println("Nama Vendor :" +v2.getNama());
        System.out.println("Alamat Vendor :" +v2.getAlamat());
        System.out.println("Produk :" +v2.getProduk());
        System.out.println("Jumlah Barang :" +v2.getJumlah());
        
        System.out.println("Total barang :" +v1.getBarangDatang());
        
    }
    
}
