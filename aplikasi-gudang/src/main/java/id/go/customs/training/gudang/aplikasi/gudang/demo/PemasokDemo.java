/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Pemasok;


/**
 *
 * @author Admin
 */
public class PemasokDemo {
    public static void main (String[] args){
        System.out.println("Jumlah Pemasok:" + Pemasok.getjumlahPemasok());
        Pemasok p1;
        p1 = new  Pemasok();
        p1.tambahPemasok();
        
        Pemasok p2 = new  Pemasok();
        String nama = "PT ABADI";
        p1.tambahPemasok();
          
        p1.setId("");
         p1.setKodePemasok("P001");
         p1.setNamaPemasok("PT ABADI");
         p1.setTelepon("021545445");
         p1.setAlamat("JAKARTA");
              
          //print pemasok
        System.out.println("");
        System.out.println("Tambah Pemasok");
        System.out.println("Kode Pemasok       : " + p1.getKodePemasok());
        System.out.println("Nama Pemasok       :"+p1.getNamaPemasok());
        System.out.println ("Telepon Pemasok    :"+p1.getTelepon());
       System.out.println("Alamat Pemasok :"+p1.getAlamat());
                System.out.println("===================================");
    
        
        
        
    }
    
}
