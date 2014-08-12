package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.VendorDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Vendor;

public class VendorDemoDao {
    public static void main(String[] args) {
        VendorDao vd = new VendorDao();
        
        Vendor v1 = new Vendor() ;
        v1.setId(001);
        v1.setNama("Samsung");
        v1.setAlamat("Korea");
        v1.setProduk("Tablet");
        
        vd.simpan(v1);
        
        
    }
}
