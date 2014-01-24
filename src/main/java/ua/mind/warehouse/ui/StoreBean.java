package ua.mind.warehouse.ui;

import ua.mind.warehouse.domain.entities.Commodity;
import ua.mind.warehouse.domain.entities.Store;
import ua.mind.warehouse.persistance.dao.CommodityDao;
import ua.mind.warehouse.persistance.dao.impl.JPACommodityDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Сергій on 22.01.14.
 */
@ManagedBean
@RequestScoped
public class StoreBean {
    private List<Store> storeList;
    private CommodityDao commodityDao = new JPACommodityDao();


    public List<Store> getStoreList() {
        storeList = commodityDao.listStore();
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList= storeList;
    }
}
