/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.importer;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import id.go.customs.training.gudang.aplikasi.gudang.domain.RakGudang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CEISA22
 */
public class HasilImporRakGudang {
     private List<RakGudang> suksesImport = new ArrayList<RakGudang>();
    private List<ImportError> gagalImport = new ArrayList<ImportError>();

    public List<RakGudang> getSuksesImport() {
        return suksesImport;
    }

    public void setSuksesImport(List<RakGudang> suksesImport) {
        this.suksesImport = suksesImport;
    }

    public List<ImportError> getGagalImport() {
        return gagalImport;
    }

    public void setGagalImport(List<ImportError> gagalImport) {
        this.gagalImport = gagalImport;
    }
    
}
