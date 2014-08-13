package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Gedung;
import id.go.customs.training.gudang.aplikasi.gudang.importer.GedungImporter;
import id.go.customs.training.gudang.aplikasi.gudang.importer.HasilImportGedung;
import id.go.customs.training.gudang.aplikasi.gudang.importer.ImportError;
import java.io.File;
import java.util.List;

public class GedungImporterDemo {
    public static void main(String[] args) {
        
        File barangCsv = new File("src/main/resources/gedung.csv");
        HasilImportGedung hasil = GedungImporter.importCsv(barangCsv);
        
        List<ImportError> daftarError = hasil.getGagalImport();
        System.out.println("======= Jumlah Error : "+daftarError.size()+" =========");
        
        for (ImportError importError : daftarError) {
            System.out.println("Baris : "+importError.getBaris());
            System.out.println("Data : "+importError.getData());
            System.out.println("Keterangan : "+importError.getKeterangan());
            System.out.println("-------------------------------------");
        }
        
        List<Gedung> barangDariCsv = hasil.getSuksesImport();
        System.out.println("======= Jumlah Data : "+barangDariCsv.size()+" =========");
        for (Gedung barang : barangDariCsv) {
            System.out.println("Kode : "+barang.getKode());
            System.out.println("Nama : "+barang.getNama());
            System.out.println("Alamat : "+barang.getAlamat());
            System.out.println("Keterangan : "+barang.getKeterangan());
            System.out.println("-------------------------------------");
        }
    }
}
