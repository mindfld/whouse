package ua.mind.warehouse.persistance.dao;

import ua.mind.warehouse.domain.entities.Commodity;
import ua.mind.warehouse.domain.entities.Order;
import ua.mind.warehouse.domain.entities.Store;

import java.util.List;

/**
 * Created by Сергій on 22.01.14.
 */
public interface CommodityDao {
    public List<Commodity> listCommodity();
    public List<Order> listOrders();
    public boolean addOrder(Order order);
    public boolean addCommodities(Commodity commodity, Integer quantity);
    public Store getStoreByCommodityName(String name);
    public List<Store> listStore();

}
