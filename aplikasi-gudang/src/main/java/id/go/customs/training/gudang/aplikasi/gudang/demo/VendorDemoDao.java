package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.VendorDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Vendor;
import java.util.List;
import java.util.Random;

public class VendorDemoDao {

    public static void main(String[] args) {
        VendorDao vd = new VendorDao();

        Vendor v1 = new Vendor();

        v1.setNama("Axio" + String.format("%6d", new Random().nextInt(100000)));
        v1.setAlamat("Korea");
        v1.setProduk("Tablet");

        vd.simpan(v1);
        System.out.println("ID yang baru saja di insert :" + v1.getId());

        v1.setNama("Acer" + String.format("%4d", new Random().nextInt(100)));
        vd.simpan(v1);
        List<Vendor> hasilQuery = vd.semuaVendor();
        System.out.println("Jumlah barang dalam database : " + hasilQuery.size());
        System.out.println("===== Hasil Query =======");

        for (Vendor vendor : hasilQuery) {
            System.out.println("ID : " + vendor.getId());
            System.out.println("Nama : " + vendor.getNama());
            System.out.println("Alamat : " + vendor.getAlamat());
            System.out.println("Produk : " + vendor.getProduk());
            System.out.println("---------------------");
        }
        System.out.println("Vendor yang di hapus : ");
        Vendor bx = vd.cariById(v1.getId());
        System.out.println("ID : " + bx.getId());
        System.out.println("Nama : " + bx.getNama());
        System.out.println("Alamat : " + bx.getAlamat());
        System.out.println("Produk : " + bx.getProduk());
        
        vd.hapus(bx);
    }
}
