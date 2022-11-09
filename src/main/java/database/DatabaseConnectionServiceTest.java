package database;

import java.sql.SQLException;

/**
 * @author Nanda Kumar
 * @since 08/10/2022
 */
public class DatabaseConnectionServiceTest {

    public static void main(String[] args) throws SQLException {

        DatabaseConnectionService dbconnection=new DatabaseConnectionService();
        dbconnection.insertUserKey("12345", "us01_02_01");
        dbconnection.insertUserKey("12345", "us01_02_01");

        dbconnection.close();

    }
}
