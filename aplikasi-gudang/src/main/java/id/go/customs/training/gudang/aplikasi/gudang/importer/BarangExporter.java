package id.go.customs.training.gudang.aplikasi.gudang.importer;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarangExporter {
    public static void exportToCsv(List<Barang> data, File tujuan){
        PrintWriter output = null;
        try {
            output = new PrintWriter(tujuan);
            output.println("id,kode,nama,keterangan");
            for (Barang barang : data) {
                output.print(barang.getId());
                output.print(",");
                output.print(barang.getKode());
                output.print(",");
                output.print(barang.getNama());
                output.print(",");
                output.println(barang.getKeterangan());
                output.flush();
            }   output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BarangExporter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(output != null){
                output.close();
            }
        }
    }
}
