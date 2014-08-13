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
import java.util.List;
import java.util.Random;

/**
 *
 * @author CEISA22
 */
public class RakGudangDaoDemo {

    public static void main(String[] args) {
        RakGudangDao bd = new RakGudangDao();

        RakGudang b1 = new RakGudang();
        b1.setNamarak("Makanan");
        b1.setNorak("A10" + (String.format("%6d", new Random().nextInt(100000))));
        b1.setKeterangan("Semua Jenis Makanan");

        bd.simpan(b1);
        System.out.println("ID yang baru saja diinsert = " + b1.getId());

        b1.setNamarak("Smartphone");
        b1.setNorak("A10" + (String.format("%6d", new Random().nextInt(100000))));
        bd.simpan(b1); // update

        List<RakGudang> hasilQuery = bd.semuaBarang();
        System.out.println("Jumlah barang dalam database : " + hasilQuery.size());
        System.out.println("===== Hasil Query =======");

        for (RakGudang barang : hasilQuery) {
            System.out.println("ID : " + barang.getId());
            System.out.println("nama : " + barang.getNamarak());
            System.out.println("norak : " + barang.getNorak());
            System.out.println("Keterangan : " + barang.getKeterangan());
            System.out.println("---------------------");
        }

        System.out.println("ID : "+b1.getId());
        RakGudang bx = bd.cariById(b1.getId());
        System.out.println("ID : " + bx.getId());
        System.out.println("namarak : " + bx.getNamarak());
        System.out.println("norak : " + bx.getNorak());
        System.out.println("Keterangan : " + bx.getKeterangan());

        bd.hapus(bx);

    }
}
