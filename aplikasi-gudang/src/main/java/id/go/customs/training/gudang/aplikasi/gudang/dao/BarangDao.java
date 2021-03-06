package id.go.customs.training.gudang.aplikasi.gudang.dao;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarangDao {
    
    private static final String SQL_INSERT = "insert into t_barang (id, kode, nama, keterangan) "
            + "values (barang_id_seq.nextval,?,?,?)";
    private static final String SQL_UPDATE = "update t_barang set "
            + "kode = ?, "
            + "nama = ?, "
            + "keterangan = ? "
            + "where id = ?";
    private static final String SQL_DELETE_BY_ID = "delete from t_barang where id = ?";
    private static final String SQL_SELECT_BY_ID = "select * from t_barang where id = ?";
    private static final String SQL_SELECT_ALL = "select * from t_barang order by kode";
    private static final String SQL_SELECT_GENERATED_ID = "select barang_id_seq.currval from dual";
    
    public void simpan(Barang b){
        try {
            Connection koneksi = DatabaseHelper.connect();
            if(b.getId() == null){
                insert(koneksi, b);
            } else {
                update(koneksi, b);
            }
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insert(Connection koneksi, Barang b) throws SQLException {
        PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
        ps.setString(1, b.getKode());
        ps.setString(2, b.getNama());
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
    
    
    private void update(Connection koneksi, Barang b) throws SQLException {
        PreparedStatement ps = koneksi.prepareStatement(SQL_UPDATE);
        ps.setString(1, b.getKode());
        ps.setString(2, b.getNama());
        ps.setString(3, b.getKeterangan());
        ps.setInt(4, b.getId());
        ps.executeUpdate();
    }
    
    public List<Barang> semuaBarang(){
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            
            List<Barang> hasil = new ArrayList<Barang>();
            while(rs.next()){
                Barang b = new Barang();
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
    
    public void hapus(Barang b){
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
    
    public Barang cariById(Integer id){
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

            Barang b = new Barang();
            b.setId(rs.getInt("id"));
            b.setKode(rs.getString("kode"));
            b.setNama(rs.getString("nama"));
            b.setKeterangan(rs.getString("keterangan"));
            
            DatabaseHelper.disconnect(koneksi);
            
            return b;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

