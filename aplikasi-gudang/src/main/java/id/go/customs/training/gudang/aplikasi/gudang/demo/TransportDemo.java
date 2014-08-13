/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.dao.TransportDao;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Transport;

/**
 *
 * @author osp
 */
public class TransportDemo {
    public static void main(String[] args){
        System.out.println("Jumlah Kendaraan di Gudang : " + Transport.getJumlahKendaraan());
        System.out.println("===================================");
        
        //tambah satu kendaraan
        Transport t1 = new Transport();
        t1.setTipe("Mobil");
        t1.setJenis("Bak terbuka");
        t1.setPlat("B 1456 CR");
        t1.setSupir("Michael");
        t1.tambahKendaraan();
        
        //print kendaraan
        System.out.println("");
        System.out.println("Tambah Kendaraan Masuk");
        System.out.println("Tipe        : " + t1.getTipe());
        System.out.println("Jenis       : " + t1.getJenis());
        System.out.println("Plat Nomor  : " + t1.getPlat());
        System.out.println("Driver      : " + t1.getSupir());
        System.out.println("Jumlah Kendaraan di Gudang : " + Transport.getJumlahKendaraan());
        System.out.println("===================================");
        
        //tambah satu kendaraan
        Transport t2 = new Transport();
        t2.setTipe("Container");
        t2.setJenis("20ft");
        t2.setPlat("B 1123 GO");
        t2.setSupir("Gorbacev");
        t2.tambahKendaraan();
        
        //print kendaraan
        System.out.println("");
        System.out.println("Tambah Kendaraan Masuk");
        System.out.println("Tipe        : " + t2.getTipe());
        System.out.println("Jenis       : " + t2.getJenis());
        System.out.println("Plat Nomor  : " + t2.getPlat());
        System.out.println("Driver      : " + t2.getSupir());
        System.out.println("Jumlah Kendaraan di Gudang : " + Transport.getJumlahKendaraan());
        System.out.println("===================================");
        
        //print kendaraan keluar
        System.out.println("");
        System.out.println("Kendaraan Keluar");
        System.out.println("Plat Nomor  : " + t1.getPlat());
        t1.kurangKendaraan();
        System.out.println("Jumlah Kendaraan di Gudang : " + Transport.getJumlahKendaraan());
        System.out.println("===================================");
        
        //Simpan data
        TransportDao td = new TransportDao();
        td.Simpan(t1);
    }
}
