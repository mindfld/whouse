import org.hibernate.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ua.mind.warehouse.domain.entities.user.Role;
import ua.mind.warehouse.domain.entities.user.User;
import ua.mind.warehouse.persistance.DAO;
import ua.mind.warehouse.persistance.JPADaoImpl;
import ua.mind.warehouse.utils.HibernateUtil;

import java.util.List;

/**
 * Created by Сергій on 17.01.14.
 */

public class HibernateTest {
    DAO database;

    @Before
    public void init() {
        database = new JPADaoImpl();
    }

    @Test
    public void inswertUsers() {
        User user = new User();
        user.setName("Sergiy");
        user.setRole(Role.STOREKEEPER);
        database.addUser(user);

        User user1 = new User();
        user1.setName("Victor");
        user1.setRole(Role.DIRECTOR);
        database.addUser(user1);

        User user2 = new User();
        user2.setName("Grisha");
        user2.setRole(Role.WORKER);
        database.addUser(user2);
    }

    @Test
    @Ignore
    public void getUsers() {
        User user = new User();
        user.setName("Sergiy");
        user.setRole(Role.STOREKEEPER);
        database.addUser(user);

        List<User> list = database.getAllUsers();
        System.out.println(list.size());
    }

    @Ignore
    @Test
    public void insertCommodity() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        User user = new User();
        user.setName("Sergiy");
        user.setRole(Role.STOREKEEPER);
        session.save(user);

        User user1 = new User();
        user.setName("Victor");
        user.setRole(Role.DIRECTOR);
        session.save(user1);

        User user2 = new User();
        user.setName("Grisha");
        user.setRole(Role.WORKER);
        session.save(user2);
        session.getTransaction().commit();
    }
}
