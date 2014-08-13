/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.dao;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import id.go.customs.training.gudang.aplikasi.gudang.domain.JasaPengiriman;
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
 * @author CEISA3
 */
public class JasaPengirimanDao {
    private static final String SQL_INSERT = "insert into t_jasaPengiriman (id, kodeJasaPengiriman, namaJasaPengiriman, tipePengiriman, keterangan) "
            + "values (jasaPengiriman_id_seq.nextval,?,?,?,?)";
    private static final String SQL_UPDATE = "update t_jasaPengiriman set "
            + "kodeJasaPengiriman = ?, "
            + "namaJasaPengiriman = ?, "
            + "tipePengiriman = ?, "
            + "keterangan = ? "
            + "where id = ?";
    private static final String SQL_DELETE_BY_ID = "delete from t_jasaPengiriman where id = ?";
    private static final String SQL_SELECT_BY_ID = "select * from t_jasaPengiriman where id = ?";
    private static final String SQL_SELECT_ALL = "select * from t_jasaPengiriman order by kodeJasaPengiriman";
    private static final String SQL_SELECT_GENERATED_ID = "select jasaPengiriman_id_seq.currval from dual";
    
    public void simpan(JasaPengiriman jp){
        try {
            Connection koneksi = DatabaseHelper.connect();
            if (jp.getId()==null){
                insert(koneksi, jp);
            }
            else{
                update(koneksi, jp);
            }
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(JasaPengirimanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Connection koneksi, JasaPengiriman jp) throws SQLException {
        PreparedStatement ps = koneksi.prepareStatement(SQL_UPDATE);
        ps.setString(1, jp.getKodeJasaPengiriman());
        ps.setString(2, jp.getNamaJasaPengiriman());
        ps.setString(3, jp.getTipePengiriman());
        ps.setString(4, jp.getKeterangan());
        ps.setInt(5, jp.getId());
        ps.executeUpdate();
    }

    private void insert(Connection koneksi, JasaPengiriman jp) throws SQLException {
        PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
        ps.setString(1, jp.getKodeJasaPengiriman());
        ps.setString(2, jp.getNamaJasaPengiriman());
        ps.setString(3, jp.getTipePengiriman());
        ps.setString(4, jp.getKeterangan());
        
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
            jp.setId(idBaru);
        }
    }
    
    public List<JasaPengiriman> allJasa(){
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            
            List<JasaPengiriman> hasil = new ArrayList<>();
            while(rs.next()){
                JasaPengiriman jp = new JasaPengiriman();
                jp.setId(rs.getInt("id"));
                jp.setKodeJasaPengiriman(rs.getString("kodeJasaPengiriman"));
                jp.setNamaJasaPengiriman(rs.getString("namaJasaPengiriman"));
                jp.setTipePengiriman(rs.getString("tipePengiriman"));
                jp.setKeterangan(rs.getString("keterangan"));
                hasil.add(jp);
            }
            
            DatabaseHelper.disconnect(koneksi);
            
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(JasaPengirimanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void delete(JasaPengiriman jp){
        try {
            if(jp.getId() == null){
                return;
            }
            
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, jp.getId());
            ps.executeUpdate();
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(JasaPengirimanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public JasaPengiriman searchById(Integer id){
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

            JasaPengiriman jp = new JasaPengiriman();
            jp.setId(rs.getInt("id"));
            jp.setKodeJasaPengiriman(rs.getString("kodeJasaPengiriman"));
            jp.setNamaJasaPengiriman(rs.getString("namaJasaPengiriman"));
            jp.setTipePengiriman(rs.getString("tipePengiriman"));
            jp.setKeterangan(rs.getString("keterangan"));
            
            DatabaseHelper.disconnect(koneksi);
            
            return jp;
        } catch (SQLException ex) {
            Logger.getLogger(JasaPengirimanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
