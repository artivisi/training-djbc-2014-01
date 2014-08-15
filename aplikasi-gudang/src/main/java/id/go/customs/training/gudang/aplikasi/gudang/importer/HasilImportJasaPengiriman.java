/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.importer;

import id.go.customs.training.gudang.aplikasi.gudang.domain.JasaPengiriman;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CEISA3
 */
public class HasilImportJasaPengiriman {
    private List<JasaPengiriman> suksesImport = new ArrayList<JasaPengiriman>();
    private List<ImportError> gagalImport = new ArrayList<ImportError>();

    public List<JasaPengiriman> getSuksesImport() {
        return suksesImport;
    }

    public void setSuksesImport(List<JasaPengiriman> suksesImport) {
        this.suksesImport = suksesImport;
    }

    public List<ImportError> getGagalImport() {
        return gagalImport;
    }

    public void setGagalImport(List<ImportError> gagalImport) {
        this.gagalImport = gagalImport;
    }
}
