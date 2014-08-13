package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.importer.BarangImporter;
import id.go.customs.training.gudang.aplikasi.gudang.importer.HasilImportBarang;
import java.io.File;

public class BarangImporterDemo {
    public static void main(String[] args) {
        
        File barangCsv = new File("src/main/resources/barang.csv");
        HasilImportBarang hasil = BarangImporter.importCsv(barangCsv);
    }
}
