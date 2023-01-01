package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.net.URLClassLoader.newInstance;


public class Util {
    // реализуйте настройку соеденения с БД
//    private static final String DB_DRIVER = "org.h2.Driver";
//    private static final String DB_URL = "jbc:h2:~/test";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db1";

    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    public static Connection getConnect() {

//        Connection conn = null;

//        Object o = Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//        static {
//            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            try { Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                System.out.println("Database Connection Established...");
                return conn;
            } catch (Exception ex) {
                System.err.println("Cannot connect to database server");
                ex.printStackTrace();
            }
//        }
//        } finally {
//            if (conn != null) {
//                try {
//                    System.out.println("n***** Let terminate the Connection *****");
//                    conn.close();
//                    System.out.println("Database connection terminated... ");
//                } catch (Exception ex) {
//                    System.out.println("Error in connection termination!");
//                }
//            }
            return null;
//        }

//    }
//        }
    }
}
//        =================================
//            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)
//            | Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance()) {
//                System.out.println("Connection successful");
//                return connection;
//            } catch (SQLException e | Exception e) {
//                throw Exception;
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//       return conn;
//    }
//}
//}
