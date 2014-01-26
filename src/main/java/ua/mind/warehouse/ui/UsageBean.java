package ua.mind.warehouse.ui;

import ua.mind.warehouse.domain.entities.flow.Flow;
import ua.mind.warehouse.domain.entities.storage.StorageItem;
import ua.mind.warehouse.persistance.dao.CommodityDao;
import ua.mind.warehouse.persistance.dao.FlowDAO;
import ua.mind.warehouse.persistance.dao.impl.JPACommodityDao;
import ua.mind.warehouse.persistance.dao.impl.JPAFlowDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Сергій on 26.01.14.
 */
@ManagedBean
@RequestScoped
public class UsageBean {
    private FlowDAO flowDAO = new JPAFlowDAO();
    private CommodityDao commodityDao = new JPACommodityDao();
    private List<Flow> flowItems;
    private List<StorageItem> storageItems;
    private StorageItem currentItem;
    private Long currentItemId;

    public List<Flow> getFlowItems() {
        flowItems = flowDAO.listFlows();
        return flowItems;
    }

    public void setFlowItems(List<Flow> flowItems) {
        this.flowItems = flowItems;
    }

    public List<StorageItem> getStorageItems() {
        storageItems = commodityDao.listStorageItems();
        return storageItems;
    }

    public void setStorageItems(List<StorageItem> storageItems) {

        this.storageItems = storageItems;
    }

    public StorageItem getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(StorageItem currentItem) {
        this.currentItem = currentItem;
    }

    public Long getCurrentItemId() {
        return currentItemId;
    }

    public void setCurrentItemId(Long currentItemId) {
        this.currentItemId = currentItemId;
    }

    public void save() {

    }
}
