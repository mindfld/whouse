package ua.mind.warehouse.ui;

import ua.mind.warehouse.domain.entities.user.User;
import ua.mind.warehouse.persistance.DAO;
import ua.mind.warehouse.persistance.JPADaoImpl;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергій on 17.01.14.
 */
@ManagedBean(name = "userGridBean")
public class UserGridBean implements Serializable {

    DAO database = new JPADaoImpl(){};

    public List<User> getAllUsers(){
        List<User> list  = database.getAllUsers();
        return list;
    }
}
