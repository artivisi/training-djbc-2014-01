package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import id.go.customs.training.gudang.aplikasi.gudang.importer.BarangImporter;
import id.go.customs.training.gudang.aplikasi.gudang.importer.HasilImportBarang;
import id.go.customs.training.gudang.aplikasi.gudang.importer.ImportError;
import java.io.File;
import java.util.List;

public class BarangImporterDemo {
    public static void main(String[] args) {
        
        File barangCsv = new File("src/main/resources/barang.csv");
        HasilImportBarang hasil = BarangImporter.importCsv(barangCsv);
        
        List<ImportError> daftarError = hasil.getGagalImport();
        System.out.println("======= Jumlah Error : "+daftarError.size()+" =========");
        
        for (ImportError importError : daftarError) {
            System.out.println("Baris : "+importError.getBaris());
            System.out.println("Data : "+importError.getData());
            System.out.println("Keterangan : "+importError.getKeterangan());
            System.out.println("-------------------------------------");
        }
        
        List<Barang> barangDariCsv = hasil.getSuksesImport();
        System.out.println("======= Jumlah Data : "+barangDariCsv.size()+" =========");
        for (Barang barang : barangDariCsv) {
            System.out.println("Kode : "+barang.getKode());
            System.out.println("Nama : "+barang.getNama());
            System.out.println("Keterangan : "+barang.getKeterangan());
            System.out.println("-------------------------------------");
        }
    }
}
