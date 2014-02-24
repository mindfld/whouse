package ua.mind.warehouse.ui;

import ua.mind.warehouse.domain.entities.storage.Category;
import ua.mind.warehouse.domain.entities.storage.Commodity;
import ua.mind.warehouse.domain.entities.storage.StorageItem;
import ua.mind.warehouse.persistance.dao.CommodityDao;
import ua.mind.warehouse.persistance.dao.impl.JPACommodityDao;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Created by Сергій on 21.02.14.
 */
@ManagedBean
@RequestScoped
public class CommodityControlBean {
    private CommodityDao commodityDao = new JPACommodityDao();


    /*Active items*/
    private String newCategory;
    private StorageItem storageItem = new StorageItem();

    public StorageItem getStorageItem() {
        return storageItem;
    }

    public void setStorageItem(StorageItem storageItem) {
        this.storageItem = storageItem;
    }

    public String getNewCategory() {
        return newCategory;
    }

    public void setNewCategory(String newCategory) {
        this.newCategory = newCategory;
    }

    public void addCategory() {
        Category category = new Category();
        category.setName(newCategory);

        if (commodityDao.addCategory(category) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Категорія додана", "Категорія " + newCategory + " успішно створена"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Помилка", "Категорія " + newCategory + " не була створена"));
        }
        newCategory = "";
    }
    public void addCommodity(){
        commodityDao.addStorageItem(storageItem);
    }
}
