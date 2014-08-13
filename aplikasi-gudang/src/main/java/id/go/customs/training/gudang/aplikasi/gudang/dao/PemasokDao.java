/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.dao;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Pemasok;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PemasokDao {
 private static final String SQL_INSERT = "insert into pemasok (kdpemasok, nmpemasok, tlp, alamat) "
            + "values (?,?,?,?)";
    
    public void simpan(Pemasok b){
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            ps.setString(1, b.getKodePemasok());
            ps.setString(2, b.getNamaPemasok());
            ps.setString(3, b.getTelepon());
            ps.setString(4, b.getAlamat());
            int hasil = ps.executeUpdate();
            System.out.println(hasil + " row berhasil diinsert");
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            System.out.println("Terjadi error");
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
