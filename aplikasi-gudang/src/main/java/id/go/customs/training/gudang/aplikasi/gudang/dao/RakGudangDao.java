/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.dao;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import id.go.customs.training.gudang.aplikasi.gudang.domain.RakGudang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CEISA22
 */
public class RakGudangDao {
    private static final String SQL_INSERT = "insert into rakgudang (id, namarak, norak, keterangan) "
            + "values (rakgudang_id_seq.nextval,?,?,?)";
    
    public void simpan(RakGudang b){
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            ps.setString(1, b.getNamarak());
            ps.setString(2,b.getNorak());
            ps.setString(3, b.getKeterangan());
            ps.executeUpdate();
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(RakGudangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
