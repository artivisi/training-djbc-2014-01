/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.importer;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Pegawai;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CEISA13
 */
public class PegawaiExporter {
    public static void exportToCsv(List<Pegawai> data, File tujuan){
        PrintWriter output = null;
        try {
            output = new PrintWriter(tujuan);
            output.println("id,nama,divisi");
            for (Pegawai pegawai : data) {
                output.print(pegawai.getId());
                output.print(",");
                output.print(pegawai.getNama());
                output.print(",");
                output.println(pegawai.getDivisi());
                output.flush();
            }   output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PegawaiExporter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(output != null){
                output.close();
            }
        }
    }
    
}
