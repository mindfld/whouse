package ua.mind.warehouse.persistance.dao;

import ua.mind.warehouse.domain.entities.storage.StorageItem;

import java.util.List;

/**
 * Created by Сергій on 22.01.14.
 */
public interface CommodityDao {
    public void addStorageItem(StorageItem item);
    public boolean removeStorageItem(Long index);
    public List<StorageItem> listStorageItems();



}
