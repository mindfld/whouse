package ua.mind.warehouse.persistance.jdbcimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.mind.warehouse.domain.entities.storage.Commodity;
import ua.mind.warehouse.domain.entities.storage.Storage;
import ua.mind.warehouse.persistance.dao.StorageDAO;
import ua.mind.warehouse.persistance.jdbcimpl.mappers.CommodityMapper;
import ua.mind.warehouse.persistance.jdbcimpl.mappers.StorageMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sergiy_Lesko on 17.06.2014.
 */
public class JDBCStorageDAO implements StorageDAO {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate template;

    public void setDataSource(final DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Storage> listStorageItems() {
        String SQL = "SELECT * FROM STORAGE";
        List<Storage> items = template.query(SQL, new StorageMapper());
        return items;
    }

    @Override
    public Commodity getCommodityById(Long commodity_id) {
        String SQL = "SELECT * FROM COMMODITY WHERE id=?";
        Commodity commodity= template.queryForObject(SQL,new Object[]{commodity_id},new CommodityMapper());
        return commodity;
    }

    @Override
    public boolean removeStorageById(Long storage_id) {
        String SQL = "DELETE FROM STORAGE WHERE id=?";
        Integer result = template.update(SQL, new Object[]{storage_id});
        if (result>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean saveOrUpdateStorage(Storage storage) throws SQLException {
        String SQL = "SELECT * FROM COMMODITY WHERE name=? ";
        Commodity commodity;
        try {
            commodity = template.queryForObject(SQL, new Object[]{storage.getCommodity().getName()}, new CommodityMapper());
        }catch (EmptyResultDataAccessException ex){
            SQL = "INSERT INTO commodity (name,description,measurementUnit) VALUES(?,?,?)";
            Integer result = template.update(SQL, new Object[]{storage.getCommodity().getName(),storage.getCommodity().getDescription(),storage.getCommodity().getMeasurementUnit()});
            SQL = "SELECT * FROM COMMODITY WHERE name=? ";
            commodity= template.queryForObject(SQL,new Object[]{storage.getCommodity().getName()},new CommodityMapper());
        }
        if (commodity ==null){
            throw new SQLException("Unable to find/persist commodity entity");
        }else{
            try{
                SQL = "SELECT * FROM STORAGE WHERE commodity_id =?";
                Storage tmpStor = template.queryForObject(SQL, new Object[]{commodity.getId()}, new StorageMapper());
                SQL = "UPDATE STORAGE SET available_quantity = ? WHERE commodity_id=?";
                if (template.update(SQL, new Object[]{storage.getAvailable()+tmpStor.getAvailable(),commodity.getId()})<=0){
                    throw  new SQLException("Unable to persist storage item");
                }
            }catch (EmptyResultDataAccessException ex){
                SQL = "INSERT INTO STORAGE (commodity_id,available_quantity) VALUES (?,?)";
                if (template.update(SQL, new Object[]{commodity.getId(),storage.getAvailable()})<=0){
                    throw  new SQLException("Unable to persist storage item");
                }
            }
        }
        return true;
    }
}
