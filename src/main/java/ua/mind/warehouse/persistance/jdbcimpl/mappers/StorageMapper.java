package ua.mind.warehouse.persistance.jdbcimpl.mappers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import ua.mind.warehouse.domain.entities.storage.Storage;
import ua.mind.warehouse.persistance.dao.StorageDAO;
import ua.mind.warehouse.persistance.jdbcimpl.JDBCStorageDAO;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Sergiy_Lesko on 17.06.2014.
 */
public class StorageMapper implements RowMapper<Storage> {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

    public Storage mapRow(ResultSet resultSet, int i) throws SQLException {

        Storage item = new Storage();
        item.setId(resultSet.getLong("id"));
        item.setAvailable(resultSet.getDouble("available_quantity"));

        StorageDAO storageTemplate = (JDBCStorageDAO) context.getBean("storageDAO");
        item.setCommodity(storageTemplate.getCommodityById(resultSet.getLong("commodity_id")));
        return item;
    }
}
