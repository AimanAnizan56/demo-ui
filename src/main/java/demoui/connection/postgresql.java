package demoui.connection;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;

public class postgresql {
    // reference - https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java
    private final String postgresql_driver = "org.postgresql.Driver";
    private URI dbUri = null;

    private static Connection conn = null;

    private postgresql() {
        try {
            Class.forName(postgresql_driver);

            dbUri = new URI(System.getenv("DATABASE_URL"));

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];

            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            conn = DriverManager.getConnection(dbUrl, username, password);
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

    public static void closeConnection() {
        try {
            if(!conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
