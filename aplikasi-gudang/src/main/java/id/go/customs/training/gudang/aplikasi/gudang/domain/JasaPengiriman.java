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
    private Integer Id;
    private String KodeJasaPengiriman;
    private String NamaJasaPengiriman;
    private String TipePengiriman;
    private String Keterangan;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getKodeJasaPengiriman() {
        return KodeJasaPengiriman;
    }

    public void setKodeJasaPengiriman(String KodeJasaPengiriman) {
        this.KodeJasaPengiriman = KodeJasaPengiriman;
    }

    public String getNamaJasaPengiriman() {
        return NamaJasaPengiriman;
    }

    public void setNamaJasaPengiriman(String NamaJasaPengiriman) {
        this.NamaJasaPengiriman = NamaJasaPengiriman;
    }
    
    public String getTipePengiriman() {
        return TipePengiriman;
    }

    public void setTipePengiriman(String TipePengiriman) {
        this.TipePengiriman = TipePengiriman;
    }

    public String getKeterangan() {
        return Keterangan;
    }

    public void setKeterangan(String Keterangan) {
        this.Keterangan = Keterangan;
    }
    
    
}
