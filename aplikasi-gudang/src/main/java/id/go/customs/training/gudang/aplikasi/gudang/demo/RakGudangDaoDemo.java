/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.BarangDao;
import id.go.customs.training.gudang.aplikasi.gudang.dao.RakGudangDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import id.go.customs.training.gudang.aplikasi.gudang.domain.RakGudang;

/**
 *
 * @author CEISA22
 */
public class RakGudangDaoDemo {
    public static void main(String[] args) {
        RakGudangDao bd = new RakGudangDao();
        
        RakGudang b1 = new RakGudang();
        b1.setNamarak("Makanan");
        b1.setNorak("A10");
        b1.setKeterangan("Semua Jenis Makanan");
       
        
        bd.simpan(b1);
    }
}
