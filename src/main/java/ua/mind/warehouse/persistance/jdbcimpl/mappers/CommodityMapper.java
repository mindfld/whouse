package ua.mind.warehouse.persistance.jdbcimpl.mappers;

import org.springframework.jdbc.core.RowMapper;
import ua.mind.warehouse.domain.entities.storage.Commodity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergiy_Lesko on 17.06.2014.
 */
public class CommodityMapper implements RowMapper<Commodity> {
    @Override
    public Commodity mapRow(ResultSet resultSet, int i) throws SQLException {
        Commodity commodity = new Commodity();
        commodity.setId(resultSet.getLong("id"));
        commodity.setName(resultSet.getString("name"));
        commodity.setDescription(resultSet.getString("description"));
        commodity.setMeasurementUnit(resultSet.getString("measurementUnit"));
        return commodity;
    }
}
