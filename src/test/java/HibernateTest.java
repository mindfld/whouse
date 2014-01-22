import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ua.mind.warehouse.domain.entities.user.Role;
import ua.mind.warehouse.domain.entities.user.User;
import ua.mind.warehouse.persistance.JPAUserDaoImpl;
import ua.mind.warehouse.persistance.UserDAO;

import java.util.List;

/**
 * Created by Сергій on 17.01.14.
 */

public class HibernateTest {
    UserDAO database;

    @Before
    public void init() {
        database = new JPAUserDaoImpl();
    }

    @Test
    @Ignore
    public void insertUsers() {
        User user = new User();
        user.setName("Sergiy");
        user.setRole(Role.STOREKEEPER);
        user.setLogin("mind");
        user.setPassword("medusa");
        database.addUser(user);

        User user1 = new User();
        user1.setName("Victor");
        user1.setRole(Role.DIRECTOR);
        user1.setLogin("vitas");
        user1.setPassword("vitas");
        database.addUser(user1);

    }

    @Test
    public void getUsers() {

        List<User> list = database.getAllUsers();
        System.out.println(list.size());
    }


}
