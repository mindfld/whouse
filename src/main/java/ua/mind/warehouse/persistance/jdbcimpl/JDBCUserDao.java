package ua.mind.warehouse.persistance.jdbcimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.mind.warehouse.domain.entities.user.User;
import ua.mind.warehouse.persistance.dao.UserDAO;
import ua.mind.warehouse.persistance.jdbcimpl.mappers.UserMapper;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Sergiy_Lesko on 04.06.2014.
 */
@Repository
public class JDBCUserDao implements UserDAO{

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public List<User> getAllUsers() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void addUser(User user) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public User getUserByCredentials(String login, String password) {
        String SQL = "SELECT * FROM Users WHERE login = ? AND password=?";
            User user = jdbcTemplateObject.queryForObject(SQL,
                    new Object[]{login,password}, new UserMapper());
        return user;
    }


    public void setDataSource(final DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

}
