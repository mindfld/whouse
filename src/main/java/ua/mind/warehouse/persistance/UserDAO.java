package ua.mind.warehouse.persistance;

import ua.mind.warehouse.domain.entities.user.User;

import java.util.List;

/**
 * Created by Сергій on 17.01.14.
 */
public interface UserDAO {
    public List<User> getAllUsers();
    public void addUser (User user);
    public boolean authorized(String login, String password);
}
