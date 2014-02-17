package ua.mind.warehouse.ui;

import ua.mind.warehouse.domain.entities.storage.Category;
import ua.mind.warehouse.domain.entities.storage.Commodity;
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
public class OrdersBean {
    private CommodityDao commodityDao = new JPACommodityDao();
    private List<Category> categories;
    private List<Commodity> commodityByCategory;


    /*Active items*/
    private Category activeCategory;
    private Commodity activeCommodity;
    private int activeQuantity;

    public List<Category> getCategories() {
        categories = commodityDao.listCategories();
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Commodity> getCommodityByCategory() {
        if (activeCategory != null)
            commodityByCategory = commodityDao.getCommodityByCategory(activeCategory);
        return commodityByCategory;
    }

    /*Getters and setters*/

    public void setCommodityByCategory(List<Commodity> commodityByCategory) {
        this.commodityByCategory = commodityByCategory;
    }

    public Category getActiveCategory() {
        return activeCategory;
    }

    public void setActiveCategory(Category activeCategory) {
        this.activeCategory = activeCategory;
    }

    public Commodity getActiveCommodity() {
        return activeCommodity;
    }

    public void setActiveCommodity(Commodity activeCommodity) {
        this.activeCommodity = activeCommodity;
    }

    public int getActiveQuantity() {
        return activeQuantity;
    }

    public void setActiveQuantity(int activeQuantity) {
        this.activeQuantity = activeQuantity;
    }
}
