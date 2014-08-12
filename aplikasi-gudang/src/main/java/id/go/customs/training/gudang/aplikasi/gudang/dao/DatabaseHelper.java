package id.go.customs.training.gudang.aplikasi.gudang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHelper {

    public static Connection connect() throws SQLException {
        try {
            Class.forName(KonfigurasiDatabaseConstants.DATABASE_DRIVER);
            Connection koneksi = DriverManager
                    .getConnection(
                            KonfigurasiDatabaseConstants.DATABASE_URL,
                            KonfigurasiDatabaseConstants.USERNAME,
                            KonfigurasiDatabaseConstants.PASSWORD);
            return koneksi;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void disconnect(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
