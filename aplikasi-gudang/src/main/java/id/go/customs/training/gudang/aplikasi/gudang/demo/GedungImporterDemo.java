package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.GedungDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Gedung;
import id.go.customs.training.gudang.aplikasi.gudang.importer.GedungImporter;
import id.go.customs.training.gudang.aplikasi.gudang.importer.HasilImportGedung;
import id.go.customs.training.gudang.aplikasi.gudang.importer.ImportError;
import java.io.File;
import java.util.List;
import java.util.Random;

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
        
        GedungDao gedungDao = new GedungDao();
        List<Gedung> barangDariCsv = hasil.getSuksesImport();
        System.out.println("======= Jumlah Data : "+barangDariCsv.size()+" =========");
        for (Gedung barang : barangDariCsv) {
            Gedung newGedung = new Gedung();
            newGedung.setKode("G" + String.format("%6d", new Random().nextInt(100000)));
            newGedung.setNama(barang.getNama());
            newGedung.setAlamat(barang.getAlamat());
            newGedung.setKeterangan(barang.getKeterangan());
            gedungDao.simpan(newGedung);
        }
    }
}
