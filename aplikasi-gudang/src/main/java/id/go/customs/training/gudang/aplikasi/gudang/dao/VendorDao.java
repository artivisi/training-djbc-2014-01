
package id.go.customs.training.gudang.aplikasi.gudang.dao;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Vendor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendorDao {
    private static final String SQL_INSERT = "insert into t_vendor (id, nama, alamat, produk)" +"values (vendor_id_seq.nextval,?,?,?)";
    
    public void simpan (Vendor b){
    try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
            
            ps.setString(1, b.getNama());
            ps.setString(2, b.getAlamat());
            ps.setString(3, b.getProduk());
            ps.executeUpdate();
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(VendorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
