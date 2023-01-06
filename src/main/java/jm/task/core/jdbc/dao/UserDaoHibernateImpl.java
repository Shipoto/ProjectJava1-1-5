package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        Transaction transaction = null;

//        try (Session session = Util.getSessionFactory().openSession()) {
        Session session = null;
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createSQLQuery("CREATE TABLE IF NOT EXISTS user " +
                    "(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), lastName VARCHAR(20), age INT)");
            query.executeUpdate();
            transaction.commit();
//            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
//            session.close();
//            getSessionFactory().close();
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Query query = session.createSQLQuery("DROP TABLE IF EXISTS user");
            query.executeUpdate();

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
//            getSessionFactory().close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            User user = new User(name, lastName, age);
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
//                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            System.out.println(user);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
//                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            userList = session.createQuery("from User").getResultList();
            System.out.println(userList);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
//                transaction.rollback();
            }
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
//        dropUsersTable();
//        createUsersTable();

        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("delete User").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
//                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
