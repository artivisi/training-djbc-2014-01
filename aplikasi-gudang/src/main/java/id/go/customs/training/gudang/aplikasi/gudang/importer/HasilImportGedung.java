package id.go.customs.training.gudang.aplikasi.gudang.importer;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Gedung;
import java.util.ArrayList;
import java.util.List;

public class HasilImportGedung {
    private List<Gedung> suksesImport = new ArrayList<>();
    private List<ImportError> gagalImport = new ArrayList<>();

    public List<Gedung> getSuksesImport() {
        return suksesImport;
    }

    public void setSuksesImport(List<Gedung> suksesImport) {
        this.suksesImport = suksesImport;
    }

    public List<ImportError> getGagalImport() {
        return gagalImport;
    }

    public void setGagalImport(List<ImportError> gagalImport) {
        this.gagalImport = gagalImport;
    }
}
