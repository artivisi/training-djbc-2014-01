/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.RakGudangDao;
import id.go.customs.training.gudang.aplikasi.gudang.dao.VendorDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.RakGudang;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Vendor;
import id.go.customs.training.gudang.aplikasi.gudang.importer.BarangImporter;
import id.go.customs.training.gudang.aplikasi.gudang.importer.HasilImporRakGudang;
import id.go.customs.training.gudang.aplikasi.gudang.importer.HasilImportBarang;
import id.go.customs.training.gudang.aplikasi.gudang.importer.ImportError;
import id.go.customs.training.gudang.aplikasi.gudang.importer.RakGudangImpor;
import java.io.File;
import java.util.List;
import java.util.Random;

/**
 *
 * @author CEISA22
 */
public class RakBarangImporDemo {
    public static void main(String[] args) {
        
        File barangCsv = new File("src/main/resources/rakgudang.csv");
        HasilImporRakGudang hasil = RakGudangImpor.importCsv(barangCsv);
        
        List<ImportError> daftarError = hasil.getGagalImport();
        System.out.println("======= Jumlah Error : "+daftarError.size()+" =========");
        
        for (ImportError importError : daftarError) {
            System.out.println("Baris : "+importError.getBaris());
            System.out.println("Data : "+importError.getData());
            System.out.println("Keterangan : "+importError.getKeterangan());
            System.out.println("-------------------------------------");
        }   
       
        List<RakGudang> barangDariCsv = hasil.getSuksesImport();
        System.out.println("======= Jumlah Data : "+barangDariCsv.size()+" =========");
        for (RakGudang barang : barangDariCsv) {
            System.out.println("Kode : "+barang.getNamarak());
            System.out.println("Nama : "+barang.getNorak());
            System.out.println("Keterangan : "+barang.getKeterangan());
            System.out.println("-------------------------------------");
        }
         RakGudangDao vd = new RakGudangDao();
        List<RakGudang> vendorDariCsv = hasil.getSuksesImport();
        System.out.println("======= Jumlah Data : " + vendorDariCsv.size() + " =========");
        for (RakGudang barang : vendorDariCsv) {


            RakGudang v1 = new RakGudang();

            v1.setNorak(barang.getNorak() + String.format("%6d", new Random().nextInt(100000)));
            v1.setNamarak(barang.getNamarak());
            v1.setKeterangan(barang.getKeterangan());

            vd.simpan(v1);
    }
    
}
}
