/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.customs.training.gudang.aplikasi.gudang.dao;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Gedung;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class GedungDao {
    private static final String SQL_INSERT = "insert into t_gedung (id, kode, nama, alamat, keterangan) "
            + "values (gedung_id_seq.nextval,?,?,?,?)";
    
    private static final String SQL_UPDATE = "update t_gedung set "
            + "kode = ?, "
            + "nama = ?, "
            + "alamat = ?, "
            + "keterangan = ? "
            + "where id = ?";
    private static final String SQL_DELETE_BY_ID = "delete from t_gedung where id = ?";
    private static final String SQL_SELECT_BY_ID = "select * from t_gedung where id = ?";
    private static final String SQL_SELECT_ALL = "select * from t_gedung order by kode";
    private static final String SQL_SELECT_GENERATED_ID = "select gedung_id_seq.currval from dual";

    
    public void simpan(Gedung g){
        try {
            Connection koneksi = DatabaseHelper.connect();
            if(g.getId() == null){
                insert(koneksi, g);
            } else {
                update(koneksi, g);
            }
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void insert(Connection koneksi, Gedung g) throws SQLException {
        PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
        ps.setString(1, g.getKode());
        ps.setString(2, g.getNama());
        ps.setString(3, g.getAlamat());
        ps.setString(4, g.getKeterangan());
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
            g.setId(idBaru);
        }
    }
    
    
    private void update(Connection koneksi, Gedung g) throws SQLException {
        PreparedStatement ps = koneksi.prepareStatement(SQL_UPDATE);
        ps.setString(1, g.getKode());
        ps.setString(2, g.getNama());
        ps.setString(3, g.getAlamat());
        ps.setString(4, g.getKeterangan());
        ps.setInt(5, g.getId());
        ps.executeUpdate();
    }
    
    public List<Gedung> semuaGedung(){
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            
            List<Gedung> hasil = new ArrayList<>();
            while(rs.next()){
                Gedung b = new Gedung();
                b.setId(rs.getInt("id"));
                b.setKode(rs.getString("kode"));
                b.setNama(rs.getString("nama"));
                b.setKeterangan(rs.getString("keterangan"));
                hasil.add(b);
            }
            
            DatabaseHelper.disconnect(koneksi);
            
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void hapus(Gedung b){
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
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Gedung cariById(Integer id){
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

            Gedung b = new Gedung();
            b.setId(rs.getInt("id"));
            b.setKode(rs.getString("kode"));
            b.setNama(rs.getString("nama"));
            b.setAlamat(rs.getString("alamat"));
            b.setKeterangan(rs.getString("keterangan"));
            
            DatabaseHelper.disconnect(koneksi);
            
            return b;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
}
