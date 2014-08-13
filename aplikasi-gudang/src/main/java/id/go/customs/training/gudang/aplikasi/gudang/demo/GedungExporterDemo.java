package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.GedungDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Gedung;
import id.go.customs.training.gudang.aplikasi.gudang.importer.GedungExporter;
import java.io.File;
import java.util.List;

public class GedungExporterDemo {
    public static void main(String[] args) {
        File tujuan = new File("target/gedung.csv");
        GedungDao bd = new GedungDao();
        List<Gedung> data = bd.semuaGedung();
        GedungExporter.exportToCsv(data, tujuan);
    }
}
