/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.domain;

/**
 *
 * @author CEISA3
 */
public class JasaPengiriman {
    private static Integer jumlahJasaPengiriman = 0;
    
    private Integer id;
    private String kodeJasaPengiriman;
    private String namaJasaPengiriman;
    private String tipePengiriman;
    private String keterangan;

    public static Integer getJumlahJasaPengiriman() {
        return jumlahJasaPengiriman;
    }
    
    public void tambahJasaPengiriman(){
        jumlahJasaPengiriman = jumlahJasaPengiriman+1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getKodeJasaPengiriman() {
        return kodeJasaPengiriman;
    }

    public void setKodeJasaPengiriman(String kodeJasaPengiriman) {
        this.kodeJasaPengiriman = kodeJasaPengiriman;
    }

    public String getNamaJasaPengiriman() {
        return namaJasaPengiriman;
    }

    public void setNamaJasaPengiriman(String namaJasaPengiriman) {
        this.namaJasaPengiriman = namaJasaPengiriman;
    }
    
    public String getTipePengiriman() {
        return tipePengiriman;
    }

    public void setTipePengiriman(String tipePengiriman) {
        this.tipePengiriman = tipePengiriman;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    
}
