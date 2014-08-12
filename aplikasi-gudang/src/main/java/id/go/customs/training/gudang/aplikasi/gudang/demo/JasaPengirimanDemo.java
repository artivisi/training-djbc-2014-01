/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.domain.JasaPengiriman;

/**
 *
 * @author CEISA3
 */
public class JasaPengirimanDemo {
    public static void main (String[] args){
       
        System.out.println("Jumlah Jasa Pengiriman (Awal): "+JasaPengiriman.getJumlahJasaPengiriman());
       
        JasaPengiriman jp = new JasaPengiriman();
        
        jp.setId(1);
        jp.setKodeJasaPengiriman("JP001");
        jp.setNamaJasaPengiriman("JNE");
        jp.setTipePengiriman("Express");
        jp.setKeterangan("1-2hari");
        jp.tambahJasaPengiriman();
        
        System.out.println("ID: "+jp.getId());
        System.out.println("Kode Jasa Pengiriman: "+jp.getKodeJasaPengiriman());
        System.out.println("Nama Jasa Pengiriman: "+jp.getNamaJasaPengiriman());
        System.out.println("Tipe Pengiriman: "+jp.getTipePengiriman());
        System.out.println("Keterangan: "+jp.getKeterangan());
        System.out.println("Jumlah Jasa Pengiriman (Saat Ini): "+jp.getJumlahJasaPengiriman());

    }
}
