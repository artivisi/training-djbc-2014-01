/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.VendorDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Vendor;
import id.go.customs.training.gudang.aplikasi.gudang.importer.HasilImportVendor;
import id.go.customs.training.gudang.aplikasi.gudang.importer.ImportError;
import id.go.customs.training.gudang.aplikasi.gudang.importer.VendorImporter;
import java.io.File;
import java.util.List;
import java.util.Random;

/**
 *
 * @author CEISA7
 */
public class VendorImportirDemo {

    public static void main(String[] args) {
        File vendorCsv = new File("src/main/resources/vendor.csv");
        HasilImportVendor hasil = VendorImporter.importCsv(vendorCsv);

        List<ImportError> daftarError = hasil.getGagalImport();
        System.out.println("======= Jumlah Error : " + daftarError.size() + " =========");

        for (ImportError importError : daftarError) {
            System.out.println("Baris : " + importError.getBaris());
            System.out.println("Data : " + importError.getData());
            System.out.println("Keterangan : " + importError.getKeterangan());
            System.out.println("-------------------------------------");
        }
        
        VendorDao vd = new VendorDao();
        List<Vendor> vendorDariCsv = hasil.getSuksesImport();
        System.out.println("======= Jumlah Data : " + vendorDariCsv.size() + " =========");
        for (Vendor barang : vendorDariCsv) {


            Vendor v1 = new Vendor();

            v1.setNama(barang.getNama() + String.format("%6d", new Random().nextInt(100000)));
            v1.setAlamat(barang.getAlamat());
            v1.setProduk(barang.getProduk());

            vd.simpan(v1);

        }

 

    }
}
