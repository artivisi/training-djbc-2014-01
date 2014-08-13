package id.go.customs.training.gudang.aplikasi.gudang.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoAksesDb {
    public static void main(String[] args) throws Exception {
        // 1. Parameter Koneksi
        String databaseDriver = "oracle.jdbc.driver.OracleDriver";
        String databaseUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "pelatihan";
        String password = "1";
        
        // 2. Connect ke database
        Class.forName(databaseDriver);
        try (Connection koneksi = DriverManager.getConnection(databaseUrl, username, password)) {
            String sql = "select (2+3) from dual";
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            // 4. Tampilkan hasilnya
            if(!rs.next()){
                System.out.println("Tidak ada record yang dihasilkan");
                return;
            }
            // ambil kolom pertama dalam hasil query
            Integer hasil = rs.getInt(1);
            System.out.println("Hasil query = "+hasil);
        }
    }
}


