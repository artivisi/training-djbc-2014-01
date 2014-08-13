/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.dao;


import id.go.customs.training.gudang.aplikasi.gudang.domain.RakGudang;
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
 * @author CEISA22
 */
public class RakGudangDao {
    private static final String SQL_INSERT = "insert into rakgudang (id, namarak, norak, keterangan) "
            + "values (rakgudang_id_seq.nextval,?,?,?)";
     private static final String SQL_UPDATE = "update rakgudang set "
            + "namarak = ?, "
            + "norak = ?, "
            + "keterangan = ? "
            + "where id = ?";
    private static final String SQL_DELETE_BY_ID = "delete from rakgudang where id = ?";
    private static final String SQL_SELECT_BY_ID = "select * from rakgudang where id = ?";
    private static final String SQL_SELECT_ALL = "select * from rakgudang order by norak";
    private static final String SQL_SELECT_GENERATED_ID = "select rakgudang_id_seq.currval from rakgudang";
    
    public void simpan(RakGudang b){
       
        try {
            Connection koneksi = DatabaseHelper.connect();
            if(b.getId() == null){
                insert(koneksi, b);
            } else {
                update(koneksi, b);
            }
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(RakGudangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void insert(Connection koneksi, RakGudang b) throws SQLException {
        PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
        ps.setString(1, b.getNamarak());
        ps.setString(2, b.getNorak());
        ps.setString(3, b.getKeterangan());
        int recordBaru = ps.executeUpdate();
        if(recordBaru > 0){
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
    
    
    private void update(Connection koneksi, RakGudang b) throws SQLException {
        PreparedStatement ps = koneksi.prepareStatement(SQL_UPDATE);
        ps.setString(1, b.getNamarak());
        ps.setString(2, b.getNorak());
        ps.setString(3, b.getKeterangan());
        ps.setInt(4, b.getId());
        ps.executeUpdate();
    }
    
    public List<RakGudang> semuaBarang(){
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            
            List<RakGudang> hasil = new ArrayList<>();
         //   List<RakGudang> hasil = new ArrayList<>();
            while(rs.next()){
                RakGudang b = new RakGudang();
                b.setId(rs.getInt("id"));
                b.setNamarak(rs.getString("namarak"));
                b.setNorak(rs.getString("norak"));
                b.setKeterangan(rs.getString("keterangan"));
                hasil.add(b);
            }
            
            DatabaseHelper.disconnect(koneksi);
            
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(RakGudangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void hapus(RakGudang b){
        try {
            if(b.getId() == null){
                return;
            }
            
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, b.getId());
            ps.executeUpdate();
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(RakGudangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public RakGudang cariById(Integer id){
        if(id == null){
            return null;
        }
        
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(!rs.next()){
                return null;
            }

            RakGudang b = new RakGudang();
            b.setId(rs.getInt("id"));
            b.setNamarak(rs.getString("namarak"));
            b.setNorak(rs.getString("norak"));
            b.setKeterangan(rs.getString("keterangan"));
            
            DatabaseHelper.disconnect(koneksi);
            
            return b;
        } catch (SQLException ex) {
            Logger.getLogger(RakGudangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
