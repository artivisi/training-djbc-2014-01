/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.customs.training.gudang.aplikasi.gudang.domain;

/**
 *
 * @author osp
 */
public class Transport {
    //static variable
    private static Integer jumlahKendaraan = 0;
    
    //instance variable
    private String tipe;
    private String jenis;
    private String plat;
    private String supir;

    public static Integer getJumlahKendaraan(){
        return jumlahKendaraan;
    }
    
    public void tambahKendaraan(){
        jumlahKendaraan = jumlahKendaraan+1;
    }
    
    public void kurangKendaraan(){
        jumlahKendaraan = jumlahKendaraan-1;
    }
    
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getSupir() {
        return supir;
    }

    public void setSupir(String supir) {
        this.supir = supir;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
    
    
}
