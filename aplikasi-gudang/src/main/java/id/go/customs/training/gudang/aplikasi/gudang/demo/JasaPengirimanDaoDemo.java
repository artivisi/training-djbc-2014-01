/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.JasaPengirimanDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.JasaPengiriman;

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
        
        /*JasaPengiriman jp2 = new JasaPengiriman();
        
        jp2.setKodeJasaPengiriman("JP021");
        jp2.setNamaJasaPengiriman("FEDEX");
        jp2.setTipePengiriman("Regular");
        jp2.setKeterangan("7hari");
        
        jpd.simpan(jp2);
        System.out.println("ID yang baru saja diinsert = "+jp2.getId());*/
        
        jp1.setNamaJasaPengiriman("POST");
        jpd.simpan(jp1);
        
        
        //jpd.delete(jp1);
        
    }
}
