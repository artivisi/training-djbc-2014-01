/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.importer;

import id.go.customs.training.gudang.aplikasi.gudang.domain.JasaPengiriman;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CEISA3
 */
public class JasaPengirimanExporter {
    public static void exportToCsv(List<JasaPengiriman> data, File tujuan){
        PrintWriter output = null;
        try {
            output = new PrintWriter(tujuan);
            output.println("id,kode,nama,tipe,keterangan");
            for (JasaPengiriman jp : data) {
                output.print(jp.getId());
                output.print(",");
                output.print(jp.getKodeJasaPengiriman());
                output.print(",");
                output.print(jp.getNamaJasaPengiriman());
                output.print(",");
                output.print(jp.getTipePengiriman());
                output.print(",");
                output.println(jp.getKeterangan());
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
