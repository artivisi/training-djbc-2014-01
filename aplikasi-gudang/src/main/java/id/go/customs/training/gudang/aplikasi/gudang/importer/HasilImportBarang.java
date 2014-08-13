package id.go.customs.training.gudang.aplikasi.gudang.importer;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import java.util.ArrayList;
import java.util.List;

public class HasilImportBarang {
    private List<Barang> suksesImport = new ArrayList<Barang>();
    private List<ImportError> gagalImport = new ArrayList<ImportError>();

    public List<Barang> getSuksesImport() {
        return suksesImport;
    }

    public void setSuksesImport(List<Barang> suksesImport) {
        this.suksesImport = suksesImport;
    }

    public List<ImportError> getGagalImport() {
        return gagalImport;
    }

    public void setGagalImport(List<ImportError> gagalImport) {
        this.gagalImport = gagalImport;
    }
}
