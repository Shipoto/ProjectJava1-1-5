package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;

import static jm.task.core.jdbc.util.Util.getConnect;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
//        userDaoJDBC.saveUser("Alex", "Bolotin", (byte) 25);
//        userDaoJDBC.saveUser("Luka", "Shilin", (byte) 32);
//        userDaoJDBC.saveUser("Max", "Lovon", (byte) 23);
//        userDaoJDBC.saveUser("Robert", "Patison", (byte) 43);
        userDaoJDBC.getAllUsers();
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();

    }
}
