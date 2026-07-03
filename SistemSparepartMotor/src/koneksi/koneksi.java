package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

public class koneksi {

    private static Connection conn;

    public static Connection getConnection() {

        try {

            String url = "jdbc:mysql://localhost:3306/db_sparepart";
            String user = "root";
            String pass = "";

            conn = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {

            System.out.println("Koneksi Gagal : " + e.getMessage());

        }

        return conn;
    }

}