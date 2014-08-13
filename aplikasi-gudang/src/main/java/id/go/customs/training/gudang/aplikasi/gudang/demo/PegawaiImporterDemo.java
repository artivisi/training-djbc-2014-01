/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.importer.HasilImportPegawai;
import id.go.customs.training.gudang.aplikasi.gudang.importer.PegawaiImporter;
import java.io.File;

/**
 *
 * @author CEISA13
 */
public class PegawaiImporterDemo {
     public static void main(String[] args) {
        
        File pegawaiCsv = new File("src/main/resources/pegawai.csv");
        HasilImportPegawai hasil = PegawaiImporter.importCsv(pegawaiCsv);
    }
    
}
