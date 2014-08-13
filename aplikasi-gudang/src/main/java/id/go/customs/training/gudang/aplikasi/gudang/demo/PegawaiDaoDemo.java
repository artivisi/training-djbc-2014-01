/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.PegawaiDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Pegawai;
import java.util.List;

/**
 *
 * @author CEISA13
 */
public class PegawaiDaoDemo {
    public static void main(String[] args) {
        PegawaiDao pd = new PegawaiDao();
        
        Pegawai p1 = new Pegawai();
        p1.setNama("Gino");
        p1.setDivisi("Pengawasan");
        
        pd.simpan(p1);
        System.out.println("ID yang baru saja diinsert = "+p1.getId());
        
        Pegawai p2 = new Pegawai();
        p2.setNama("Tarno");
        p2.setDivisi("Kebersihan");
        
        pd.simpan(p2);
        System.out.println("ID yang baru saja diinsert = "+p2.getId());
        
        p1.setDivisi("HRD");
        pd.simpan(p1);
    
        List<Pegawai> hasilQuery = pd.semuaPegawai();
        System.out.println("Jumlah pegawai dalam database : "+hasilQuery.size());
        System.out.println("===== Hasil Query =======");
        
        for (Pegawai pegawai : hasilQuery) {
            System.out.println("ID : "+pegawai.getId());
            System.out.println("Nama : "+pegawai.getNama());
            System.out.println("Divisi : "+pegawai.getDivisi());
            System.out.println("---------------------");
        }
        
        System.out.println("=======================");
        System.out.println("Hasil Pencarian Pegawai");
        Pegawai px = pd.cariById(p2.getId());
        System.out.println("ID : "+px.getId());
        System.out.println("Nama : "+px.getNama());
        System.out.println("Keterangan : "+px.getDivisi());
        
        //pd.hapus(px);
        
    }
    
}
