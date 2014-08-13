/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.importer;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Pegawai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CEISA13
 */
public class HasilImportPegawai {
    private List<Pegawai> suksesImport = new ArrayList<Pegawai>();
    private List<ImportError> gagalImport = new ArrayList<ImportError>();

    public List<Pegawai> getSuksesImport() {
        return suksesImport;
    }

    public void setSuksesImport(List<Pegawai> suksesImport) {
        this.suksesImport = suksesImport;
    }

    public List<ImportError> getGagalImport() {
        return gagalImport;
    }

    public void setGagalImport(List<ImportError> gagalImport) {
        this.gagalImport = gagalImport;
    }
    
}
