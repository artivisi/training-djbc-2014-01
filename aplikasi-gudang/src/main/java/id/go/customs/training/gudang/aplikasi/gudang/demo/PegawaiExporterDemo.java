/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.PegawaiDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Pegawai;
import id.go.customs.training.gudang.aplikasi.gudang.importer.PegawaiExporter;
import java.io.File;
import java.util.List;

/**
 *
 * @author CEISA13
 */
public class PegawaiExporterDemo {
    public static void main(String[] args) {
        File tujuan = new File("target/pegawai.csv");
        PegawaiDao pd = new PegawaiDao();
        List<Pegawai> data = pd.semuaPegawai();
        PegawaiExporter.exportToCsv(data, tujuan);
    }
    
}
