/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.GedungDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Gedung;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class GedungDaoDemo {
    public static void main(String[] args) {
        GedungDao gedungDao = new GedungDao();
        Gedung newGedung = new Gedung();
        newGedung.setKode("G" + String.format("%6d", new Random().nextInt(100000)));
        newGedung.setNama("Gedung A");
        newGedung.setAlamat("Jl. Ahmad Yani");
        newGedung.setKeterangan("-");
        gedungDao.simpan(newGedung);
        
        System.out.println("ID yang baru saja diinsert = "+newGedung.getId());
        
        newGedung.setNama("Gedung Update");
        gedungDao.simpan(newGedung); // update
        
        List<Gedung> hasilQuery = gedungDao.semuaBarang();
        System.out.println("Jumlah barang dalam database : "+hasilQuery.size());
        System.out.println("===== Hasil Query =======");
        
        for (Gedung barang : hasilQuery) {
            System.out.println("ID : "+barang.getId());
            System.out.println("Kode : "+barang.getKode());
            System.out.println("Nama : "+barang.getNama());
            System.out.println("Alamat : "+barang.getAlamat());
            System.out.println("Keterangan : "+barang.getKeterangan());
            System.out.println("---------------------");
        }
        
        Gedung bx = gedungDao.cariById(newGedung.getId());
        System.out.println("ID : "+bx.getId());
        System.out.println("Kode : "+bx.getKode());
        System.out.println("Nama : "+bx.getNama());
        System.out.println("Keterangan : "+bx.getKeterangan());
        
        gedungDao.hapus(bx);
    }
}
