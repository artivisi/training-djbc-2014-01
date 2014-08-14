/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.dao;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Pegawai;
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
 * @author CEISA13
 */
public class PegawaiDao {
    private static final String SQL_INSERT = "insert into t_pegawai (id, nama, divisi) "
            + "values (pegawai_id_seq.nextval,?,?)";
    private static final String SQL_UPDATE = "update t_pegawai set "
            + "nama = ?, "
            + "divisi = ? "
            + "where id = ?";
    private static final String SQL_DELETE_BY_ID = "delete from t_pegawai where id = ?";
    private static final String SQL_SELECT_BY_ID = "select * from t_pegawai where id = ?";
    private static final String SQL_SELECT_ALL = "select * from t_pegawai order by id";
    private static final String SQL_SELECT_GENERATED_ID = "select pegawai_id_seq.currval from dual";
    
    public void simpan(Pegawai p){
        try {
            Connection koneksi = DatabaseHelper.connect();
            if (p.getId()==null){
                insert(koneksi, p);
            }else{
                update(koneksi, p);
            }
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insert(Connection koneksi, Pegawai p) throws SQLException {
        PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
        ps.setString(1, p.getNama());
        ps.setString(2, p.getDivisi());
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
            p.setId(idBaru);
        }
    }
    
    private void update(Connection koneksi, Pegawai p) throws SQLException {
        PreparedStatement ps = koneksi.prepareStatement(SQL_UPDATE);
        ps.setString(1, p.getNama());
        ps.setString(2, p.getDivisi());
        ps.setInt(3, p.getId());
        ps.executeUpdate();
    }
    
    public List<Pegawai> semuaPegawai(){
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            
            List<Pegawai> hasil = new ArrayList<>();
            while(rs.next()){
                Pegawai p = new Pegawai();
                p.setId(rs.getInt("id"));
                p.setNama(rs.getString("nama"));
                p.setDivisi(rs.getString("divisi"));
                hasil.add(p);
            }
            
            DatabaseHelper.disconnect(koneksi);
            
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void hapus(Pegawai p){
        try {
            if(p.getId() == null){
                return;
            }
            
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, p.getId());
            ps.executeUpdate();
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Pegawai cariById(Integer id){
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

            Pegawai p = new Pegawai();
            p.setId(rs.getInt("id"));
            p.setNama(rs.getString("nama"));
            p.setDivisi(rs.getString("divisi"));
            
            DatabaseHelper.disconnect(koneksi);
            
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
           
}
