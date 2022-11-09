package database;

import java.sql.*;

/**
 * @author Nanda Kumar
 * @since 08/10/2022
 */
public class ConnectionTester {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, "sa", "");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM LDUSERS";
            ResultSet rs = stmt.executeQuery(sql);

            String name = null;
            while (rs.next()) {
                name = rs.getString("userkey");
                System.out.println("name : " + name);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
