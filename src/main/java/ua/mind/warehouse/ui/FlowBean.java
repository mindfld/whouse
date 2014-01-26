package ua.mind.warehouse.ui;

import ua.mind.warehouse.domain.entities.flow.Flow;
import ua.mind.warehouse.domain.entities.storage.Commodity;
import ua.mind.warehouse.domain.entities.storage.MeasurementUnit;
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
public class FlowBean {
    private FlowDAO flowDAO= new JPAFlowDAO();
    private List<Flow> flowItems;

    public List<Flow> getFlowItems() {
        flowItems = flowDAO.listFlows();
        return flowItems;
    }

    public void setFlowItems(List<Flow> flowItems) {
        this.flowItems = flowItems;
    }
}
