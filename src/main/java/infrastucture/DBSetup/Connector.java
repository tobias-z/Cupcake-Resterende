package infrastucture.DBSetup;

import java.sql.*;

public class Connector {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DB_URL = null;


    //  Database credentials
    private static final String USER = "cupcake";

    // Database version
    private static final int version = 4;

    public Connector(String url) throws ClassNotFoundException {
        DB_URL = url == null ? "jdbc:mysql://localhost/cupcake?serverTimezone=CET" : url;
        Class.forName(JDBC_DRIVER);
        if (getCurrentVersion() != getVersion()) {
            throw new IllegalStateException("Database in wrong state");
        }
    }

    public static int getVersion() {
        return version;
    }

    public static int getCurrentVersion() {
        try (Connection conn = getConnection()) {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT value FROM properties WHERE name = 'version';");
            if(rs.next()) {
                String column = rs.getString("value");
                return Integer.parseInt(column);
            } else {
                System.err.println("No version in properties.");
                return -1;
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            return -1;
        }
    }



    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        DB_URL = "jdbc:mysql://localhost/cupcake?serverTimezone=CET";
        Class.forName(JDBC_DRIVER);
        // JDBC driver name and database URL
        return DriverManager.getConnection(DB_URL, USER, null);
    }
}
