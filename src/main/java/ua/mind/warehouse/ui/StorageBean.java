package ua.mind.warehouse.ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Сергій on 26.01.14.
 */
@ManagedBean
@RequestScoped
public class StorageBean {
    private List<String> storageItems;

    public List<String> getStorageItems() {
        return storageItems;
    }

    public void setStorageItems(List<String> storageItems) {
        this.storageItems = storageItems;
    }
}
