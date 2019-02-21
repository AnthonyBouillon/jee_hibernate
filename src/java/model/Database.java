package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;
    /**
     * Connection to the database
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_ee", "root", "leqxd777");
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
    }
    /**
     * Retrieves a connection object
     * @return 
     */
    public static Connection getConnection() {
        return connection;
    }

}
