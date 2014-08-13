package id.go.customs.training.gudang.aplikasi.gudang.importer;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Vendor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendorExporter {
public static void exportToCsv(List<Vendor> data, File tujuan){
        PrintWriter output = null;
        try {
            output = new PrintWriter(tujuan);
            output.println("id,nama,alamat,produk");
            for (Vendor barang : data) {
                output.print(barang.getId());
                output.print(",");
                output.print(barang.getNama());
                output.print(",");
                output.print(barang.getAlamat());
                output.print(",");
                output.println(barang.getProduk());
                output.flush();
            }   output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VendorExporter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(output != null){
                output.close();
            }
        }
    }    
}
