package ua.mind.warehouse.ui;

import ua.mind.warehouse.domain.entities.storage.Commodity;
import ua.mind.warehouse.domain.entities.MeasurementUnit;
import ua.mind.warehouse.domain.entities.Order;
import ua.mind.warehouse.domain.entities.Store;
import ua.mind.warehouse.domain.entities.user.User;
import ua.mind.warehouse.persistance.dao.CommodityDao;
import ua.mind.warehouse.persistance.dao.impl.JPACommodityDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергій on 22.01.14.
 */
@ManagedBean
@SessionScoped
public class OrderBean {
    private CommodityDao commodityDao = new JPACommodityDao();
    private Order currentOrder;
    private List<Order> allOrders;

    private String name;
    private String description;
    private MeasurementUnit measurementUnit;
    private Integer quantity;

    public OrderBean() {
        init();
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void addCommodity(){
        if (validateStoreItem()){
            Commodity commodity= new Commodity(name,description,measurementUnit);
            Store store = new Store(commodity, quantity);
            commodity.setStore(store);
            currentOrder.getStore().add(store);
            setDefaultvalues();
        }else{
            //TODO add error message to page about not valid store item
        }

    }
    public void removeCommodity(int removeId){
       if (currentOrder.getStore().size()>removeId){
           currentOrder.getStore().remove(removeId);
       }
    }
    public void saveOrder(){
        commodityDao.addOrder(currentOrder);
        init();
    }

    private void init() {
        HttpSession session = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession(true);
        User user = (User)session.getAttribute("user");
        if (user==null){
            user =User.getAnonymous();
        }
        currentOrder = new Order(new ArrayList<Store>(),user , false);
    }

    private boolean validateStoreItem() {
        //TODO create field validation
        return  true;
    }

    private void setDefaultvalues() {
        setName("");
        setDescription("");
        setMeasurementUnit(MeasurementUnit.pcs);
        setQuantity(0);
    }

    public List<Order> getAllOrders() {
        allOrders = commodityDao.listOrders();
        return allOrders;
    }

    public void setAllOrders(List<Order> allOrders) {
        this.allOrders = allOrders;
    }


}
