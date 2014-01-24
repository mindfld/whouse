package ua.mind.warehouse.ui;

import ua.mind.warehouse.domain.entities.Order;
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
public class OrderBean {
    private List<Order> orderList;
    private CommodityDao commodityDao = new JPACommodityDao();


    public List<Order>getOrderList() {
        orderList = commodityDao.listOrders();
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
