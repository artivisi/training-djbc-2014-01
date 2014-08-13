/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.dao;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Pegawai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CEISA13
 */
public class PegawaiDao {
    private static final String SQL_INSERT = "insert into t_pegawai (id, nama, divisi) "
            + "values (pegawai_id_seq.nextval,?,?)";
    
    public void simpan(Pegawai p){
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            ps.setString(1, p.getNama());
            ps.setString(2, p.getDivisi());
            ps.executeUpdate();
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
