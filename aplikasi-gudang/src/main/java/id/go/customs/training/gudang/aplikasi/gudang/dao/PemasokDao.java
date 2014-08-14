/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.dao;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Pemasok;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PemasokDao {
 private static final String SQL_INSERT = "insert into t_pemasok (id, kdpemasok, nmpemasok, tlp, alamat) "
            + "values (pemasok_id_seq.nextval ,?,?,?,?)";
  private static final String SQL_UPDATE = "update into t_pemasok set"
                 + "kdpemasok = ?, "
          + "nmpemasok = ?, "
             + "tlp = ?, "
             + "alamat = ?, "
             + "where id = ?";
  private static final String SQL_SELECT_ALL = "select * from t_pemasok order by kdpemasok";
  private static final String SQL_GENERATED_ID = "select * from t_pemasok order by kdpemasok";
    private String SQL_SELECT_GENERATED_ID = "select pemasok_id_seq.currval from dual";
 
 
 
    
    public void simpan(Pemasok b){
        try {
            Connection koneksi = DatabaseHelper.connect();
        if (b.getId()== null ){
            insert (koneksi,b);
        }else{
           update(koneksi, b);
        }
                
                
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            System.out.println("Terjadi error");
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insert (Connection koneksi, Pemasok b) throws SQLException {
    PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
        ps.setString(1, b.getKodePemasok());
        ps.setString(2, b.getNamaPemasok());
        ps.setString(3, b.getTelepon());
        ps.setString(4, b.getAlamat());
        int recordBaru = ps.executeUpdate();
        if (recordBaru >0){
  
            ResultSet generatedKeys = koneksi
                    .prepareStatement(SQL_SELECT_GENERATED_ID)
                    .executeQuery();
            if(generatedKeys == null || !generatedKeys.next()){
                System.out.println("Tidak berhasil generate ID");
                return;
            }
            
            Integer idBaru = generatedKeys.getInt(1);
            b.setId(idBaru);
     }
            }

    
    
     private void update(Connection koneksi, Pemasok b) throws SQLException {
        PreparedStatement ps = koneksi.prepareStatement(SQL_UPDATE);
        ps.setString(1, b.getKodePemasok());
        ps.setString(2, b.getNamaPemasok());
        ps.setString(3, b.getTelepon());
        ps.setString(3, b.getAlamat());
        ps.setInt(4, b.getId());
        ps.executeUpdate();
    }
    
    public List<Pemasok> semuaPemasok(){
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps;
            ps = koneksi.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            
            List<Pemasok> hasil = new ArrayList<Pemasok>();
            while(rs.next()){
                Pemasok b = new Pemasok();
                b.setId(rs.getInt("id"));
                b.setKodePemasok(rs.getString("kdpemasok"));
                b.setNamaPemasok(rs.getString("nmpemasok"));
                b.setAlamat(rs.getString("alamat"));
                    b.setTelepon(rs.getString("telepon"));
                hasil.add(b);
            }
            
            DatabaseHelper.disconnect(koneksi);
            
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(PemasokDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}
