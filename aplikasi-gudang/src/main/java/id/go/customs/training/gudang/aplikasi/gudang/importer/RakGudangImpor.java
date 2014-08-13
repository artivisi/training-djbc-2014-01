/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.importer;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import id.go.customs.training.gudang.aplikasi.gudang.domain.RakGudang;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CEISA22
 */
public class RakGudangImpor {
      public static HasilImporRakGudang importCsv(File fileCsv){
        BufferedReader reader = null;
        HasilImporRakGudang hasil = new HasilImporRakGudang();
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
                
                if(baris.length != 3){
                    ImportError error = new ImportError();
                    error.setKeterangan("Data harusnya ada 3 field, tapi ternyata ada "+baris.length+" field");
                    error.setBaris(noBaris);
                    error.setData(data);
                    hasil.getGagalImport().add(error);
                    data = reader.readLine();
                    continue;
                }
                
                RakGudang b = new RakGudang();
                b.setNamarak(baris[0]);
                b.setNorak(baris[1]);
                b.setKeterangan(baris[2]);
                hasil.getSuksesImport().add(b);
                
                data = reader.readLine();
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RakGudangImpor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RakGudangImpor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(reader != null){
                    reader.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(BarangImporter.class.getName()).log(Level.SEVERE, null, ex);
            }
            return hasil;
        }
    }
    
}
