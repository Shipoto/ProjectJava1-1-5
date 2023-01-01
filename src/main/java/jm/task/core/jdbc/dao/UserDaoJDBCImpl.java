package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static jm.task.core.jdbc.util.Util.getConnect;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            PreparedStatement preparedStatement = getConnect()
                    .prepareStatement("CREATE TABLE IF NOT EXISTS user (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), lastName VARCHAR(20), age INT)");

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try {
            PreparedStatement preparedStatement = getConnect()
                    .prepareStatement("DROP TABLE IF EXISTS user");

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            PreparedStatement preparedStatement = getConnect().prepareStatement("INSERT INTO user VALUES (1, ?, ?, ?)");
//            preparedStatement.setLong(0, );
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User c imenem " + name + " dobavlen v basu dannih");
    }

    public void removeUserById(long id) {
        try {
            PreparedStatement preparedStatement = getConnect().prepareStatement("DELETE FROM user WHERE id=?");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try (Statement statement = getConnect().createStatement()){
            String sql = "SELECT * FROM user";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));

                userList.add(user);

            }
            System.out.println(userList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public void cleanUsersTable() {
        try {
            PreparedStatement preparedStatement = getConnect().prepareStatement("DELETE FROM user");

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
