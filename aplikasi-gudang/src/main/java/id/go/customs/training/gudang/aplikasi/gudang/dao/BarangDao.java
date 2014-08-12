package id.go.customs.training.gudang.aplikasi.gudang.dao;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarangDao {
    
    private static final String SQL_INSERT = "insert into t_barang (id, kode, nama, keterangan) "
            + "values (barang_id_seq.nextval,?,?,?)";
    
    public void simpan(Barang b){
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            ps.setString(1, b.getKode());
            ps.setString(2, b.getNama());
            ps.setString(3, b.getKeterangan());
            ps.executeUpdate();
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
