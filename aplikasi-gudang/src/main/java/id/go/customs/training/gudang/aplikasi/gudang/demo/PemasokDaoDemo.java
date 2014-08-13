/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.PemasokDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Pemasok;

/**
 *
 * @author Admin
 */
public class PemasokDaoDemo {
  public static void main(String[] args) {
      PemasokDao bd = new PemasokDao();
      Pemasok p1 = new  Pemasok ();
      p1.setKodePemasok("5");
      p1.setNamaPemasok("PT ABADI");
      p1.setTelepon("1235465465");
      p1.setAlamat("jk");
      
      bd.simpan(p1);
        
          }
    
}

