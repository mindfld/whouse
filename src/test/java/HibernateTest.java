import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ua.mind.warehouse.domain.entities.Commodity;
import ua.mind.warehouse.domain.entities.MeasurementUnit;
import ua.mind.warehouse.domain.entities.Order;
import ua.mind.warehouse.domain.entities.Store;
import ua.mind.warehouse.domain.entities.user.Role;
import ua.mind.warehouse.domain.entities.user.User;
import ua.mind.warehouse.persistance.dao.CommodityDao;
import ua.mind.warehouse.persistance.dao.impl.JPACommodityDao;
import ua.mind.warehouse.persistance.dao.impl.JPAUserDao;
import ua.mind.warehouse.persistance.dao.UserDAO;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергій on 17.01.14.
 */

public class HibernateTest {
    public static final int DEFAULT_QUANTITY = 5;
    UserDAO userDB;
    CommodityDao commodityDB;

    @Before
    public void init() {
        userDB = new JPAUserDao();
        commodityDB = new JPACommodityDao();
    }

    @Test
    @Ignore
    public void insertUsers() {
        User user = new User();
        user.setName("Sergiy");
        user.setRole(Role.STOREKEEPER);
        user.setLogin("mind");
        user.setPassword("medusa");
        userDB.addUser(user);

        User user1 = new User();
        user1.setName("Victor");
        user1.setRole(Role.DIRECTOR);
        user1.setLogin("vitas");
        user1.setPassword("vitas");
        userDB.addUser(user1);

    }

    @Test
    public void getUsers() {

        List<User> list = userDB.getAllUsers();
        System.out.println(list.size());
    }

    @Test
    @Ignore
    public void setOrder() {
        User user = new User();
        user.setName("OrderUser");
        user.setRole(Role.STOREKEEPER);
        user.setLogin("order");
        user.setPassword("order");
        userDB.addUser(user);

        Commodity commodity = new Commodity();
        commodity.setName("Дюбель 3мм");
        commodity.setDescription("Стальный дюбель 3мм");
        commodity.setMeasurementUnit(MeasurementUnit.pcs);

        Order order = new Order();
        order.setUser(user);
        List<Commodity> commodities = new ArrayList<Commodity>();
        commodities.add(commodity);
        order.setCommodity(commodities);
        commodityDB.addOrder(order);

    }

    @Test
    public void checkStorePutGet() {
        Commodity commodity = new Commodity();
        commodity.setName("TestCommodity2");
        Store store = commodityDB.getStoreByCommodityName(commodity.getName());
        Integer beforeQuantity =0;
        if (store!=null){
             beforeQuantity= store.getQuantity();
        }
        commodityDB.addCommodities(commodity, DEFAULT_QUANTITY);
        Integer afterQuantity= commodityDB.getStoreByCommodityName(commodity.getName()).getQuantity();
        assertEquals(DEFAULT_QUANTITY,afterQuantity-beforeQuantity);

    }

}
