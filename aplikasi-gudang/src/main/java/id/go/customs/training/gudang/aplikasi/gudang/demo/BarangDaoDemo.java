package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.BarangDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;

public class BarangDaoDemo {
    public static void main(String[] args) {
        BarangDao bd = new BarangDao();
        
        Barang b1 = new Barang();
        b1.setId(100);
        b1.setKode("H-001");
        b1.setNama("Handphone");
        b1.setKeterangan("Handphone Android");
        
        bd.simpan(b1);
    }
    
}