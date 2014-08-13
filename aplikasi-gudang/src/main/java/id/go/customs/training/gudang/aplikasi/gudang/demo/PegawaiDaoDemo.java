/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.PegawaiDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Pegawai;

/**
 *
 * @author CEISA13
 */
public class PegawaiDaoDemo {
    public static void main(String[] args) {
        PegawaiDao pd = new PegawaiDao();
        
        Pegawai p1 = new Pegawai();
        p1.setNama("Juki");
        p1.setDivisi("Pengawasan");
        
        pd.simpan(p1);
        
        Pegawai p2 = new Pegawai();
        p2.setNama("Udin");
        p2.setDivisi("Kebersihan");
        
        pd.simpan(p2);
    }
    
}
