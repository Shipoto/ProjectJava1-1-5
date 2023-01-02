package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db1";
    private static final String DB_USERNAME = "root";
     private static final String DB_PASSWORD = "root";

    static {
        getDriver();
    }

    public Util() {
    }

    public static Connection getConnect() {
            try { Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                System.out.println("Database Connection Established...");
                return conn;
            } catch (SQLException ex) {
                System.err.println("Cannot connect to database server");
                throw new RuntimeException(ex);
            }
        }

    private static void getDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

