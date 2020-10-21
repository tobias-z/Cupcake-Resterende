package DBAccess.DBSetup;

import java.sql.*;

public class Connector {

    // JDBC driver name and database URL
    private static Connection singleton;
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/webapp";


    //  Database credentials
    private static final String USER = "webapp";

    // Database version
    private static final int version = 5;

    public Connector() throws ClassNotFoundException {
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
        Class.forName(JDBC_DRIVER);
        singleton = DriverManager.getConnection(DB_URL, USER, null);
        return singleton;
    }
}
