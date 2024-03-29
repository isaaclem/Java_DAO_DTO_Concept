package person.jdbc;

import java.sql.*;

/**
 *
 * @author isaaclem
 */
public class JConnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost/test_schema?useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "lemkhoo2424";
    private static Driver driver;
    
    public static synchronized Connection getConnection() throws SQLException {
        if (driver == null){
            try {
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);
            } catch (Exception e) {
                System.out.println("Failed to load JDBC driver");
                e.printStackTrace(System.out);
            }
        }
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
    }
    
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
    }
}
