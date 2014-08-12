/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Pegawai;

/**
 *
 * @author CEISA13
 */
public class PegawaiDemo {
    public static void main(String[] args) {
        // untuk memanggil static method, tidak perlu ada instance
                
        Pegawai p1; // deklarasi variabel
        p1 = new Pegawai();  // inisialisasi variabel
                
        Pegawai p2 = new Pegawai(); // deklarasi + inisialisasi
                
        Pegawai p3 = new Pegawai();
        
        // isi data b1
        p1.setId(100);
        p1.setNama("Cecep");
        p1.setDivisi("HRD");
        p1.tambahPegawai();
        
        // isi data b2
        p2.setId(200);
        p2.setNama("Ucup");
        p2.setDivisi("Pengawasan");
        p2.tambahPegawai();
        
        // isi data b2
        p3.setId(300);
        p3.setNama("Tono");
        p3.tambahPegawai();
        
        
        
        // tampilkan data
        System.out.println("DAFTAR PEGAWAI GUDANG :");
        System.out.println("ID Pegawai p1 : "+p1.getId());
        System.out.println("Nama Pegawai p1 : "+p1.getNama());
        System.out.println("Divisi Pegawai p1 : "+p1.getDivisi());

        System.out.println("ID Pegawai p2 : "+p2.getId());
        System.out.println("Nama Pegawai p2 : "+p2.getNama());
        System.out.println("Divisi Pegawai p2 : "+p2.getDivisi());
        
        System.out.println("ID Pegawai p3 : "+p3.getId());
        System.out.println("Nama Pegawai p3 : "+p3.getNama());
        System.out.println("Divisi Pegawai p3 : "+p3.getDivisi());
        System.out.println("Jumlah Pegawai : "+p3.getJumlahPegawai());
    }
    
}
