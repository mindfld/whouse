package ua.mind.warehouse.persistance.jdbcimpl.mappers;

import org.springframework.jdbc.core.RowMapper;
import ua.mind.warehouse.domain.entities.flow.Flow;
import ua.mind.warehouse.domain.entities.user.Role;
import ua.mind.warehouse.domain.entities.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Sergiy_Lesko on 17.06.2014.
 */
public class FlowMapper implements RowMapper<Flow> {

    public Flow mapRow(ResultSet resultSet, int i) throws SQLException {
        Flow flow = new Flow();
        flow.setId(resultSet.getLong("id"));
        flow.setBalance(resultSet.getDouble("balance"));
        flow.setComments(resultSet.getString("comments"));
        flow.setDate(resultSet.getDate("flow_date"));
        flow.setUserName(resultSet.getString("fullname"));
        flow.setProductName(resultSet.getString("name"));
        flow.setMeasurementUnit(resultSet.getString("measurementUnit"));
        return flow;
    }
}
