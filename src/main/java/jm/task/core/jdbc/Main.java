package jm.task.core.jdbc;

//import com.mysql.cj.Session;
//import com.mysql.cj.xdevapi.SessionFactory;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;


public class Main {
    public static void main(String[] args) {

//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(User.class)
//                .buildSessionFactory();

        UserDaoHibernateImpl ud = new UserDaoHibernateImpl();
//
        ud.createUsersTable();
        ud.saveUser("Aura", "Losai", (byte) 34);
        ud.saveUser("dsf", "Lofsdfai", (byte) 33);
        ud.saveUser("sdf", "efss", (byte) 43);
        ud.saveUser("sdff", "eesee", (byte) 45);
//        ud.removeUserById(2);
//        ud.dropUsersTable();
//        ud.cleanUsersTable();
//        ud.getAllUsers();



//        try {
//            Session session = factory.getCurrentSession();
//            User user = new User("Alex", "Bolotin", (byte) 25);
//            session.beginTransaction();
//            session.save(user);
//            session.getTransaction().commit();
//
//        } finally {
//            factory.close();
//        }


//        UserService userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.saveUser("Alex", "Bolotin", (byte) 25);
//        userService.saveUser("Max", "Lovon", (byte) 23);
//        userService.saveUser("Robert", "Patison", (byte) 43);
//        userService.getAllUsers();
//        userService.dropUsersTable();

    }
}
