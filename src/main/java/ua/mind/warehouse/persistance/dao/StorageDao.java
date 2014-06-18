package ua.mind.warehouse.persistance.dao;

import ua.mind.warehouse.domain.entities.storage.Commodity;
import ua.mind.warehouse.domain.entities.storage.Storage;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Сергій on 22.01.14.
 */
public interface StorageDAO {
    public List<Storage> listStorageItems();

    public Commodity getCommodityById(Long commodity_id);

    public boolean removeStorageById(Long storage_id);

    public boolean saveOrUpdateStorage(Storage storage) throws SQLException;

}

