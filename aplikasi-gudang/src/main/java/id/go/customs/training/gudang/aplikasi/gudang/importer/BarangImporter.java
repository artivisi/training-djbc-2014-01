package id.go.customs.training.gudang.aplikasi.gudang.importer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarangImporter {
    public static HasilImportBarang importCsv(File fileCsv){
        BufferedReader reader = null;
        HasilImportBarang hasil = new HasilImportBarang();
        try {
            reader = new BufferedReader(new FileReader(fileCsv));
            String data = reader.readLine();
            while(data != null){
                System.out.println("Memproses data : "+data);
                data = reader.readLine();
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BarangImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BarangImporter.class.getName()).log(Level.SEVERE, null, ex);
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
