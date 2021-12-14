package demoui.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class postgresql {
    private final String postgresql_driver = "org.postgresql.Driver";
    private final String postgresql_host = "ec2-54-204-128-96.compute-1.amazonaws.com";
    private final String postgresql_user = "hpkmourdokyitg";
    private final String postgresql_password = "385268bfad6244b6512f5c88c254b87fe8efd8f22f3bcb86dd4f33e14c4f134a";

    private static Connection conn = null;

    private postgresql() {
        try {
            Class.forName(postgresql_driver);
            conn = DriverManager.getConnection(postgresql_host, postgresql_user, postgresql_password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if(conn == null) {
            new postgresql();
        }
        return conn;
    }
}
