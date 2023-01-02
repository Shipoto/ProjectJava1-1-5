package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;

import static jm.task.core.jdbc.util.Util.getConnect;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Alex", "Bolotin", (byte) 25);
        userService.saveUser("Max", "Lovon", (byte) 23);
        userService.saveUser("Robert", "Patison", (byte) 43);
        userService.getAllUsers();
        userService.dropUsersTable();

    }
}
