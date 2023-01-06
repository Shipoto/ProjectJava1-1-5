package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
    public static void main(String[] args) {

        UserDaoHibernateImpl ud = new UserDaoHibernateImpl();

        ud.createUsersTable();
        ud.saveUser("Aura", "Losai", (byte) 34);
        ud.saveUser("dsf", "Lofsdfai", (byte) 33);
        ud.saveUser("sdf", "efss", (byte) 43);
        ud.saveUser("sdff", "eesee", (byte) 45);
//        ud.removeUserById(2);
//        ud.dropUsersTable();
//        ud.cleanUsersTable();
//        ud.getAllUsers();







    }
}
