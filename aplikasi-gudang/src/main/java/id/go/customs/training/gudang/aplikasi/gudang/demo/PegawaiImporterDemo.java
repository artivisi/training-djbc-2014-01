/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Pegawai;
import id.go.customs.training.gudang.aplikasi.gudang.importer.HasilImportPegawai;
import id.go.customs.training.gudang.aplikasi.gudang.importer.ImportError;
import id.go.customs.training.gudang.aplikasi.gudang.importer.PegawaiImporter;
import java.io.File;
import java.util.List;

/**
 *
 * @author CEISA13
 */
public class PegawaiImporterDemo {
     public static void main(String[] args) {
        
        File pegawaiCsv = new File("src/main/resources/pegawai.csv");
        HasilImportPegawai hasil = PegawaiImporter.importCsv(pegawaiCsv);
        
        List<ImportError> daftarError = hasil.getGagalImport();
        System.out.println("======= Jumlah Error : "+daftarError.size()+" =========");
        
        for (ImportError importError : daftarError) {
            System.out.println("Baris : "+importError.getBaris());
            System.out.println("Data : "+importError.getData());
            System.out.println("Keterangan : "+importError.getKeterangan());
            System.out.println("-------------------------------------");
        }
        
        List<Pegawai> pegawaiDariCsv = hasil.getSuksesImport();
        System.out.println("======= Jumlah Data : "+pegawaiDariCsv.size()+" =========");
        for (Pegawai pegawai : pegawaiDariCsv) {
            System.out.println("Nama : "+pegawai.getNama());
            System.out.println("Divisi : "+pegawai.getDivisi());
            System.out.println("-------------------------------------");
        }
    }
    
}
