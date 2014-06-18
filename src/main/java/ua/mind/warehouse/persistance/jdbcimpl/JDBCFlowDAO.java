package ua.mind.warehouse.persistance.jdbcimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.mind.warehouse.domain.entities.flow.Flow;
import ua.mind.warehouse.domain.entities.storage.Commodity;
import ua.mind.warehouse.domain.entities.storage.Storage;
import ua.mind.warehouse.persistance.dao.FlowDAO;
import ua.mind.warehouse.persistance.dao.StorageDAO;
import ua.mind.warehouse.persistance.jdbcimpl.mappers.CommodityMapper;
import ua.mind.warehouse.persistance.jdbcimpl.mappers.FlowMapper;
import ua.mind.warehouse.persistance.jdbcimpl.mappers.StorageMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergiy_Lesko on 17.06.2014.
 */
public class JDBCFlowDAO implements FlowDAO {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate template;

    public void setDataSource(final DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Flow> listFlowItems() {
        String SQL = "SELECT F.id, F.balance,F.comments,f.flow_date, u.fullname, C.name, c.measurementUnit FROM FLOWS f JOIN USERS U on F.user_id=U.id JOIN COMMODITY C ON  F.commodity_id=c.id";
        List<Flow> items = template.query(SQL, new FlowMapper());
        return items;
    }


}
