package ua.mind.warehouse.persistance.dao;

import ua.mind.warehouse.domain.entities.user.User;

import java.util.List;

/**
 * Created by Сергій on 17.01.14.
 */
public interface UserDAO {
    public List<User> getAllUsers();
    public void addUser (User user);
    public User getUserByCredentials(String login, String password);
}
