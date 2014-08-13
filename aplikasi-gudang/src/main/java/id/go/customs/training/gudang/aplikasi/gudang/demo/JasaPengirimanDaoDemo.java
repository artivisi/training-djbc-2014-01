/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.JasaPengirimanDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import id.go.customs.training.gudang.aplikasi.gudang.domain.JasaPengiriman;
import java.util.List;

/**
 *
 * @author CEISA3
 */
public class JasaPengirimanDaoDemo {
    public static void main (String[] args){
        JasaPengirimanDao jpd = new JasaPengirimanDao();
        
        JasaPengiriman jp1 = new JasaPengiriman();
        
        jp1.setKodeJasaPengiriman("JP001");
        jp1.setNamaJasaPengiriman("JNE");
        jp1.setTipePengiriman("Express");
        jp1.setKeterangan("1-2hari");
        
        jpd.simpan(jp1);
        System.out.println("ID yang baru saja diinsert = "+jp1.getId());
        
        jp1.setNamaJasaPengiriman("POS");
        jp1.setTipePengiriman("Regular");
        jpd.simpan(jp1);
       
        List<JasaPengiriman> hasilQuery = jpd.allJasa();
        System.out.println("Jumlah Jasa Pengiriman dalam database : "+hasilQuery.size());
        System.out.println("===== Hasil Query Jasa Pengiriman =======");
        
        for (JasaPengiriman jp : hasilQuery) {
            System.out.println("ID : "+jp.getId());
            System.out.println("Kode : "+jp.getKodeJasaPengiriman());
            System.out.println("Nama : "+jp.getNamaJasaPengiriman());
            System.out.println("Tipe : "+jp.getTipePengiriman());
            System.out.println("Keterangan : "+jp.getKeterangan());
            System.out.println("---------------------");
        }
        
        JasaPengiriman jps = jpd.searchById(jp1.getId());
        
        System.out.println("ID : "+jps.getId());
        System.out.println("Kode : "+jps.getKodeJasaPengiriman());
        System.out.println("Nama : "+jps.getNamaJasaPengiriman());
        System.out.println("Tipe : "+jps.getTipePengiriman());
        System.out.println("Keterangan : "+jps.getKeterangan());
        
        jpd.delete(jp1);
        
    }
}
