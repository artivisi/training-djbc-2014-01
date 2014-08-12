/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.dao;

import id.go.customs.training.gudang.aplikasi.gudang.domain.JasaPengiriman;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CEISA3
 */
public class JasaPengirimanDao {
    private static final String SQL_INSERT = "insert into t_jasaPengiriman (id, kodeJasaPengiriman, namaJasaPengiriman, tipePengiriman, keterangan) "
            + "values (jasaPengiriman_id_seq.nextval,?,?,?,?)";
    
    public void simpan(JasaPengiriman jp){
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            ps.setString(1, jp.getKodeJasaPengiriman());
            ps.setString(2, jp.getNamaJasaPengiriman());
            ps.setString(3, jp.getTipePengiriman());
            ps.setString(4, jp.getKeterangan());
            ps.executeUpdate();
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(JasaPengirimanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
