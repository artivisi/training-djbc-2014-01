/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.importer;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Vendor;
import java.util.ArrayList;
import java.util.List;


public class HasilImportVendor {
     private List<Vendor> suksesImport = new ArrayList<Vendor>();
    private List<ImportError> gagalImport = new ArrayList<ImportError>();

    public List<Vendor> getSuksesImport() {
        return suksesImport;
    }

    public void setSuksesImport(List<Vendor> suksesImport) {
        this.suksesImport = suksesImport;
    }

    public List<ImportError> getGagalImport() {
        return gagalImport;
    }

    public void setGagalImport(List<ImportError> gagalImport) {
        this.gagalImport = gagalImport;
    }
}
