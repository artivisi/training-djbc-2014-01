package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.BarangDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import java.util.List;

public class BarangDaoDemo {
    public static void main(String[] args) {
        BarangDao bd = new BarangDao();
        
        Barang b1 = new Barang();
        b1.setKode("H-001");
        b1.setNama("Handphone");
        b1.setKeterangan("Handphone Android");
        
        bd.simpan(b1);
        
        
        List<Barang> hasilQuery = bd.semuaBarang();
        System.out.println("Jumlah barang dalam database : "+hasilQuery.size());
        System.out.println("===== Hasil Query =======");
        
        for (Barang barang : hasilQuery) {
            System.out.println("ID : "+barang.getId());
            System.out.println("Kode : "+barang.getKode());
            System.out.println("Nama : "+barang.getNama());
            System.out.println("Keterangan : "+barang.getKeterangan());
            System.out.println("---------------------");
        }
    }
    
}
