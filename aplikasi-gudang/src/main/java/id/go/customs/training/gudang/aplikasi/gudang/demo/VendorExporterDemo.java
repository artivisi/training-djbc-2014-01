package id.go.customs.training.gudang.aplikasi.gudang.demo;


import id.go.customs.training.gudang.aplikasi.gudang.dao.VendorDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Vendor;
import id.go.customs.training.gudang.aplikasi.gudang.importer.VendorExporter;
import java.io.File;
import java.util.List;

public class VendorExporterDemo {
public static void main(String[] args) {
  File tujuan = new File("target/vendor.csv");
        VendorDao bd = new VendorDao();
        List<Vendor> data = bd.semuaVendor();
        VendorExporter.exportToCsv(data, tujuan);
    }
}
    

