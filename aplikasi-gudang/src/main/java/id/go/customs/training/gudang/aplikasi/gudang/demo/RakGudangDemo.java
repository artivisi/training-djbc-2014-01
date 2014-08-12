/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.domain.RakGudang;

/**
 *
 * @author CEISA22
 */
public class RakGudangDemo {
    public static void main(String[] args){
    
    RakGudang r1 = new RakGudang();
    RakGudang r2 = new RakGudang();
    
    r1.setId(1);
    r1.setNamarak("Obat-obatan");
    r1.setNorak("001A");
    r1.setKeterangan("Semua Jenis Obat-obatan");
    r1.setJumlahbarang(20);
    
    r2.setId(2);
    r2.setNamarak("Makanan Ringan");
    r2.setNorak("001B");
    r2.setKeterangan("Semua Jenis makanan ringan");
    r2.setJumlahbarang(10);
    
    System.out.println("ID barang r1            ="+r1.getId());
    System.out.println("Nama Rak barang r1      ="+r1.getNamarak());
    System.out.println("no Rakbarang r1         ="+r1.getNorak());
    System.out.println("Keterangan barang r1    ="+r1.getKeterangan());
    System.out.println("Jumlah barang r1        ="+r1.getJumlahbarang());
    
    System.out.println("ID barang r2            ="+r2.getId());
    System.out.println("Nama Rak barang r2      ="+r2.getNamarak());
    System.out.println("no Rakbarang r2         ="+r2.getNorak());
    System.out.println("Keterangan barang r2    ="+r2.getKeterangan());
    System.out.println("Jumlah barang r2        ="+r2.getJumlahbarang());
    
    
    System.out.println("Total Jumlah barang r2  ="+RakGudang.getTotalBarang());
    
    
    }
    
    
}
