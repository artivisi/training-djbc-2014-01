package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.BarangDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import id.go.customs.training.gudang.aplikasi.gudang.importer.BarangExporter;
import java.io.File;
import java.util.List;

public class BarangExporterDemo {
    public static void main(String[] args) {
        File tujuan = new File("target/barang.csv");
        BarangDao bd = new BarangDao();
        List<Barang> data = bd.semuaBarang();
        BarangExporter.exportToCsv(data, tujuan);
    }
}
