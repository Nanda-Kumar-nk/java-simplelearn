package database;

import java.sql.*;

/**
 * @author Nanda Kumar
 * @since 08/10/2022
 */
public class DatabaseConnectionService {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";
    private Connection conn = null;

    private Statement stmt;

    public DatabaseConnectionService() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, "sa", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertUserKey(String userKey, String salesAreaParameter) throws SQLException {

        if (!isEntryExisting(userKey)) {
            String insertStmt = "Insert into LDUSERS(USERKEY, SALESAREA) values ('" + userKey + "', '" + salesAreaParameter + "')";
            int rows = getStatement().executeUpdate(insertStmt);
            if (rows > 0) {
                System.out.println("user key " + userKey + "is inserted for salesarea " + salesAreaParameter);
            }
        } else {
            System.out.println("user key " + userKey + "already existing for salesarea " + salesAreaParameter);
        }

    }

    private boolean isEntryExisting(String userKey) throws SQLException {
        String sql = "SELECT * FROM LDUSERS where userkey='" + userKey+"'";
        ResultSet rs = getStatement().executeQuery(sql);
        return rs.next();
    }

    public Statement getStatement() throws SQLException {
        try {
            if (stmt == null || stmt.isClosed()) {
                stmt = conn.createStatement();
            }
        } catch (Exception e) {
            stmt = null;
        }
        if (stmt == null) {
            stmt = conn.createStatement();
        }
        return stmt;
    }

    public void close() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        }catch (Exception ex){
            System.out.println("Exception Thrown while closing the statement "+ ex);
        }
        try {
            if (conn != null) {
                conn.close();
            }
        }catch (Exception ex){
            System.out.println("Exception Thrown while closing the connection "+ ex);
        }
    }
}
