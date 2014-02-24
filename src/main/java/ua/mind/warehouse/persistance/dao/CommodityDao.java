package ua.mind.warehouse.persistance.dao;

import ua.mind.warehouse.domain.entities.storage.Category;
import ua.mind.warehouse.domain.entities.storage.Commodity;
import ua.mind.warehouse.domain.entities.storage.StorageItem;

import java.util.List;

/**
 * Created by Сергій on 22.01.14.
 */
public interface CommodityDao {
    public void addStorageItem(StorageItem item);
    public boolean removeStorageItem(Long index);
    public List<StorageItem> listStorageItems();
    public List<Category> listCategories();
    public List<Commodity> getCommodityByCategory(Category category);
    public boolean addCategory(Category category);
}
