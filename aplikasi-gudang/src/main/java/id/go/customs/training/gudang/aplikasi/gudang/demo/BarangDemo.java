/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.demo;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author endy
 */
public class BarangDemo {
    public static void main(String[] args) {
        // untuk memanggil static method, tidak perlu ada instance
        System.out.println("Jumlah barang : " + Barang.getJumlahBarang());
        
        Barang b1; // deklarasi variabel
        b1 = new Barang();  // inisialisasi variabel
        b1.tambahBarang();
        
        Barang b2 = new Barang(); // deklarasi + inisialisasi
        String nama = "endy";
        b1.tambahBarang();
        
        // isi data b1
        b1.setId(100);
        b1.setKode("H-001");
        b1.setNama("Handphone");
        b1.setKeterangan("Handphone Android");
        b1.setHarga(new BigDecimal("150000.05"));
        
        // isi field dengan tipe data Date
        String tanggalString = "17-08-2014";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date tanggal = formatter.parse(tanggalString);
            b1.setTanggalProduksi(tanggal);
        } catch (ParseException ex) {
            System.out.println("Format tanggal salah, harusnya dd-MM-yyyy");
        }
        
        // isi data b2
        b2.setId(200);
        b2.setKode("");
        
        Barang b3 = new Barang();
        
        // tampilkan data
        System.out.println("ID Barang b1 : "+b1.getId());
        System.out.println("Kode Barang b1 : "+b1.getKode());
        System.out.println("Nama Barang b1 : "+b1.getNama());
        System.out.println("Tanggal Produksi Barang b1 : "+b1.getTanggalProduksi());
        
        // format tanggal
        Locale indonesia = new Locale("ID");
        SimpleDateFormat formatLengkap = new SimpleDateFormat("EEEE, dd MMMM yyyy", indonesia);
        System.out.println("Tanggal terformat : "+formatLengkap.format(b1.getTanggalProduksi()));
        NumberFormat formatAngka = DecimalFormat.getNumberInstance(indonesia);
        System.out.println("Harga Barang b1 : "+formatAngka.format(b1.getHarga()));
        
        System.out.println("Jumlah Barang : "+Barang.getJumlahBarang());

        System.out.println("ID Barang b2 : "+b2.getId());
        System.out.println("Kode Barang b2 : "+b2.getKode());
        System.out.println("Nama Barang b2 : "+b2.getNama());
        System.out.println("Jumlah Barang : "+Barang.getJumlahBarang());
        
        System.out.println("Jumlah Barang : "+Barang.getJumlahBarang());
    }
}
