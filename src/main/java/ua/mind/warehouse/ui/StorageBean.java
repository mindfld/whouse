package ua.mind.warehouse.ui;

import ua.mind.warehouse.domain.entities.storage.Commodity;
import ua.mind.warehouse.domain.entities.storage.MeasurementUnit;
import ua.mind.warehouse.domain.entities.storage.StorageItem;
import ua.mind.warehouse.persistance.dao.CommodityDao;
import ua.mind.warehouse.persistance.dao.impl.JPACommodityDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Сергій on 26.01.14.
 */
@ManagedBean
@RequestScoped
public class StorageBean {
    private CommodityDao commodityDao = new JPACommodityDao();
    private List<StorageItem> storageItems;

    private String name;
    private String description;
    private MeasurementUnit measurementUnit;
    private int quantity;


    public List<StorageItem> getStorageItems() {
        storageItems = commodityDao.listStorageItems();
        return storageItems;
    }

    public void setStorageItems(List<StorageItem> storageItems) {
        this.storageItems = storageItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public  void remove(int id){
        commodityDao.removeStorageItem(new Long(id));
    }
    public  void addItem(){
        Commodity commodity = new Commodity(name,description,MeasurementUnit.m);
        StorageItem item = new StorageItem(commodity,quantity);
        commodity.setStorage(item);
        commodityDao.addStorageItem(item);
    }
}
