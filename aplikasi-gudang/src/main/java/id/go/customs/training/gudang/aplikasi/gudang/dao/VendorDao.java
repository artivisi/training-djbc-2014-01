package id.go.customs.training.gudang.aplikasi.gudang.dao;

import id.go.customs.training.gudang.aplikasi.gudang.domain.Barang;
import id.go.customs.training.gudang.aplikasi.gudang.domain.Vendor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendorDao {

    private static final String SQL_INSERT = "insert into t_vendor (id, nama, alamat, produk)" + "values (vendor_id_seq.nextval,?,?,?)";
    private static final String SQL_UPDATE = "update t_vendor set "
            + "nama = ?, "
            + "alamat = ?, "
            + "produk = ? "
            + "where id = ?";
    private static final String SQL_SELECT_ALL = "select * from t_vendor order by id";
    private static final String SQL_SELECT_GENERATED_ID = "select vendor_id_seq.currval from dual";
    private static final String SQL_DELETE_BY_ID = "delete from t_vendor where id = ?";
    private static final String SQL_SELECT_BY_ID = "select * from t_vendor where id = ?";

    public void simpan(Vendor b) {
        try {
            Connection koneksi = DatabaseHelper.connect();
            if (b.getId() == null) {
                insert(koneksi, b);
            } else {
                update(koneksi, b);
            }
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(VendorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insert(Connection koneksi, Vendor b) throws SQLException {
        PreparedStatement ps = koneksi.prepareStatement(SQL_INSERT);
        ps.setString(1, b.getNama());
        ps.setString(2, b.getAlamat());
        ps.setString(3, b.getProduk());
        int recordBaru = ps.executeUpdate();
        if (recordBaru > 0) {
            ResultSet generatedKeys = koneksi
                    .prepareStatement(SQL_SELECT_GENERATED_ID)
                    .executeQuery();
            if (generatedKeys == null || !generatedKeys.next()) {
                System.out.println("Tidak berhasil generate ID");
                return;
            }

            Integer idBaru = generatedKeys.getInt(1);
            b.setId(idBaru);
        }
    }

    private void update(Connection koneksi, Vendor b) throws SQLException {
        PreparedStatement ps = koneksi.prepareStatement(SQL_UPDATE);
        ps.setString(1, b.getNama());
        ps.setString(2, b.getAlamat());
        ps.setString(3, b.getProduk());
        ps.setInt(4, b.getId());
        ps.executeUpdate();
    }

    public List<Vendor> semuaVendor() {
        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            List<Vendor> hasil = new ArrayList<>();
            while (rs.next()) {
                Vendor b = new Vendor();
                b.setId(rs.getInt("id"));
                b.setNama(rs.getString("nama"));
                b.setAlamat(rs.getString("alamat"));
                b.setProduk(rs.getString("produk"));
                hasil.add(b);
            }

            DatabaseHelper.disconnect(koneksi);

            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(VendorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void hapus(Vendor b) {
        try {
            if (b.getId() == null) {
                return;
            }

            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, b.getId());
            ps.executeUpdate();
            DatabaseHelper.disconnect(koneksi);
        } catch (SQLException ex) {
            Logger.getLogger(VendorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Vendor cariById(Integer id) {
        if (id == null) {
            return null;
        }

        try {
            Connection koneksi = DatabaseHelper.connect();
            PreparedStatement ps = koneksi.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            Vendor b = new Vendor();
            b.setId(rs.getInt("id"));
            b.setNama(rs.getString("nama"));
            b.setAlamat(rs.getString("alamat"));
            b.setProduk(rs.getString("produk"));

            DatabaseHelper.disconnect(koneksi);

            return b;
        } catch (SQLException ex) {
            Logger.getLogger(VendorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
