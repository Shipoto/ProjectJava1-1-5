package jm.task.core.jdbc.util;

import com.mysql.cj.Session;
//import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.SessionFactory;
import jm.task.core.jdbc.model.User;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
//    public static SessionFactory sessionFactory() {
//
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(User.class)
//                .buildSessionFactory();
//        return factory;
//    }

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/dbhiber?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

//    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//            .addAnnotatedClass("User.class")
//            .buildSessionFactory();
//
//    Session session = factory.getSession();



//    private static final String DB_URL = "jdbc:mysql://localhost:3306/db1";
//    private static final String DB_USERNAME = "root";
//     private static final String DB_PASSWORD = "root";
//
//    static {
//        getDriver();
//    }
//
//    public Util() {
//    }
//
//    public static Connection getConnect() {
//            try { Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//                System.out.println("Database Connection Established...");
//                return conn;
//            } catch (SQLException ex) {
//                System.err.println("Cannot connect to database server");
//                throw new RuntimeException(ex);
//            }
//        }
//
//    private static void getDriver() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

}

