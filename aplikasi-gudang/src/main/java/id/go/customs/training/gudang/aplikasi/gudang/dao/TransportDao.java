/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.customs.training.gudang.aplikasi.gudang.dao;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Transport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osp
 */
public class TransportDao {
    private static final String SQL_INSERT = "insert into t_transport (id_transport, jenis, tipe, plat, supir) "
            + "values (transport_id_seq.nextval,?,?,?,?)";
    
    public void Simpan(Transport t){
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            ps.setString(1, t.getJenis());
            ps.setString(2, t.getTipe());
            ps.setString(3, t.getPlat());
            ps.setString(4, t.getSupir());
            ps.executeUpdate();
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(TransportDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
