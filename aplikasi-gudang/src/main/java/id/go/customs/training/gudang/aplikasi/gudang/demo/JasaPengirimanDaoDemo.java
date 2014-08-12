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
    }
}
