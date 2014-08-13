/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.importer;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Pegawai;
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
            
            if(data == null){
                System.out.println("File kosong");
                return hasil;
            }
            
            data = reader.readLine(); // skip satu baris, header tidak perlu diproses
            Integer noBaris = 1;
            
            while(data != null){
                noBaris++;
                System.out.println("Memproses data : "+data);
                String[] baris = data.split(",");
                
                if(baris.length != 2){
                    ImportError error = new ImportError();
                    error.setKeterangan("Data harusnya ada 2 field, tapi ternyata ada "+baris.length+" field");
                    error.setBaris(noBaris);
                    error.setData(data);
                    hasil.getGagalImport().add(error);
                    data = reader.readLine();
                    continue;
                }
                
                Pegawai p = new Pegawai();
                p.setNama(baris[0]);
                p.setDivisi(baris[1]);
                hasil.getSuksesImport().add(p);
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
