/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.GedungDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Gedung;

/**
 *
 * @author Admin
 */
public class GedungDaoDemo {
    public static void main(String[] args) {
        GedungDao gedungDao = new GedungDao();
        Gedung newGedung = new Gedung();
        newGedung.setKode("G0003");
        newGedung.setNama("Gedung A");
        gedungDao.simpan(newGedung);
    }
}
