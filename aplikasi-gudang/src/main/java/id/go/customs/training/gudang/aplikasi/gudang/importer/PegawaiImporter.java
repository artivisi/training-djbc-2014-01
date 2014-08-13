/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.importer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CEISA13
 */
public class PegawaiImporter {
    public static HasilImportPegawai importCsv(File fileCsv){
        BufferedReader reader = null;
        HasilImportPegawai hasil = new HasilImportPegawai();
        try {
            reader = new BufferedReader(new FileReader(fileCsv));
            String data = reader.readLine();
            while(data != null){
                System.out.println("Memproses data : "+data);
                data = reader.readLine();
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PegawaiImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PegawaiImporter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(reader != null){
                    reader.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(PegawaiImporter.class.getName()).log(Level.SEVERE, null, ex);
            }
            return hasil;
        }
    }
    
}
