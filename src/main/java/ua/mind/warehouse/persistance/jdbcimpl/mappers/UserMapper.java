package ua.mind.warehouse.persistance.jdbcimpl.mappers;

import org.springframework.jdbc.core.RowMapper;
import ua.mind.warehouse.domain.entities.user.Role;
import ua.mind.warehouse.domain.entities.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Sergiy_Lesko on 17.06.2014.
 */
public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("fullname"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(Role.getById(resultSet.getLong("role_id")));
        return user;
    }
}
