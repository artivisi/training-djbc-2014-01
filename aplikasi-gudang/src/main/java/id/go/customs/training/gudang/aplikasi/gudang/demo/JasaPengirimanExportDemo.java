/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.JasaPengirimanDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.JasaPengiriman;
import id.go.customs.training.gudang.aplikasi.gudang.importer.JasaPengirimanExporter;
import java.io.File;
import java.util.List;

/**
 *
 * @author CEISA3
 */
public class JasaPengirimanExportDemo {
    public static void main(String[] args) {
        File tujuan = new File("target/jasa.csv");
        JasaPengirimanDao jpd = new JasaPengirimanDao();
        List<JasaPengiriman> data = jpd.allJasa();
        JasaPengirimanExporter.exportToCsv(data, tujuan);
    }
}
