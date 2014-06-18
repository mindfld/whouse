package ua.mind.warehouse.ui;

import org.primefaces.context.RequestContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.mind.warehouse.domain.entities.storage.Commodity;
import ua.mind.warehouse.domain.entities.storage.Storage;
import ua.mind.warehouse.persistance.dao.StorageDAO;
import ua.mind.warehouse.persistance.jdbcimpl.JDBCStorageDAO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Сергій on 26.01.14.
 */
@ManagedBean
@RequestScoped
public class StorageBean {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
    private static StorageDAO dao = (JDBCStorageDAO)context.getBean("storageDAO");

    private List<Storage> storageItems;

    private String name;
    private String description;
    private String  measurementUnit;
    private Double available;


    public List<Storage> getStorageItems() {
        storageItems = dao.listStorageItems();
        return storageItems;
    }

    public void setStorageItems(List<Storage> storageItems) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public  void remove(Long id){
        Boolean result = dao.removeStorageById(id);
        FacesContext facesContext= FacesContext.getCurrentInstance();
        if (result){
            facesContext.addMessage(null, new FacesMessage("Виконано",  "Товар з id: " + id +" видалено.") );
        }else{
            facesContext.addMessage(null, new FacesMessage("Помилка",  "Товар з id: " + id +" не знайдено.") );
        }
    }
    public  void addItem(){
        Storage storage = new Storage();
        Commodity commodity = new Commodity();
        commodity.setName(name);
        commodity.setDescription(description);
        commodity.setMeasurementUnit(measurementUnit);

        storage.setAvailable(available);
        storage.setCommodity(commodity);
        FacesContext facesContext= FacesContext.getCurrentInstance();
        try {
            if (dao.saveOrUpdateStorage(storage)) {
                facesContext.addMessage(null, new FacesMessage("Виконано", "Новий товар додано на склад"));
            } else {
                facesContext.addMessage(null, new FacesMessage("Помилка", "Новий товар не додано на склад"));
            }
        } catch (SQLException e) {
            facesContext.addMessage(null, new FacesMessage("Помилка", "Неможливо зберегти товар"));
        }
        clearFields();
    }

    private void clearFields() {
        name="";
        description="";
        available=0.0;
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

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public Double getAvailable() {
        return available;
    }

    public void setAvailable(Double available) {
        this.available = available;
    }
}
