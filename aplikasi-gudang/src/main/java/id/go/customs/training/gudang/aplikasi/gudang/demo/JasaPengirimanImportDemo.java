/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.JasaPengirimanDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.JasaPengiriman;
import id.go.customs.training.gudang.aplikasi.gudang.importer.HasilImportJasaPengiriman;
import id.go.customs.training.gudang.aplikasi.gudang.importer.ImportError;
import id.go.customs.training.gudang.aplikasi.gudang.importer.JasaPengirimanImporter;
import java.io.File;
import java.util.List;
import java.util.Random;

/**
 *
 * @author CEISA3
 */
public class JasaPengirimanImportDemo {
     public static void main(String[] args) {
        
        File barangCsv = new File("src/main/resources/jasaPengiriman.csv");
        HasilImportJasaPengiriman hasil = JasaPengirimanImporter.importCsv(barangCsv);
        
        List<ImportError> daftarError = hasil.getGagalImport();
        System.out.println("======= Jumlah Error : "+daftarError.size()+" =========");
        
        for (ImportError importError : daftarError) {
            System.out.println("Baris : "+importError.getBaris());
            System.out.println("Data : "+importError.getData());
            System.out.println("Keterangan : "+importError.getKeterangan());
            System.out.println("-------------------------------------");
        }
        
        JasaPengirimanDao jpd = new JasaPengirimanDao();
        List<JasaPengiriman> jasaDariCsv = hasil.getSuksesImport();
        System.out.println("======= Jumlah Data : "+jasaDariCsv.size()+" =========");
        for (JasaPengiriman jp : jasaDariCsv) {
            JasaPengiriman j = new JasaPengiriman();
            
            j.setKodeJasaPengiriman(jp.getKodeJasaPengiriman());
            j.setNamaJasaPengiriman(jp.getNamaJasaPengiriman());
            j.setTipePengiriman(jp.getTipePengiriman());
            j.setKeterangan(jp.getKeterangan());
            jpd.simpan(j);
        }
    }
}
