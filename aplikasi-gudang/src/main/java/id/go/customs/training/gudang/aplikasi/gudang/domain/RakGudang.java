/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.domain;

/**
 *
 * @author CEISA22
 */
public class RakGudang {
    private static Integer TotalBarang;
    
    private Integer id;
    private String namarak;
    private String norak;
    private Integer jumlahbarang;
    private String keterangan;
    
    
    
    public void Totalbarang(){
    TotalBarang = jumlahbarang++;
    }

    public static Integer getTotalBarang() {
        return TotalBarang;
    }

    public static void setTotalBarang(Integer TotalBarang) {
        RakGudang.TotalBarang = TotalBarang;
    }

    
    
    public Integer getJumlahbarang() {
        return jumlahbarang;
    }

    public void setJumlahbarang(Integer jumlahbarang) {
        this.jumlahbarang = jumlahbarang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamarak() {
        return namarak;
    }

    public void setNamarak(String namarak) {
        this.namarak = namarak;
    }

    public String getNorak() {
        return norak;
    }

    public void setNorak(String norak) {
        this.norak = norak;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    
    
}
