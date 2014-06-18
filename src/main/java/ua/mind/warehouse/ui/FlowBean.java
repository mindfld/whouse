package ua.mind.warehouse.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.mind.warehouse.domain.entities.flow.Flow;
import ua.mind.warehouse.domain.entities.storage.Commodity;
import ua.mind.warehouse.domain.entities.storage.Storage;
import ua.mind.warehouse.persistance.dao.FlowDAO;
import ua.mind.warehouse.persistance.dao.StorageDAO;
import ua.mind.warehouse.persistance.jdbcimpl.JDBCFlowDAO;
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
public class FlowBean {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
    private static FlowDAO dao = (JDBCFlowDAO)context.getBean("flowDAO");

    private List<Flow> flowItems;

    public List<Flow> getFlowItems() {
        flowItems= dao.listFlowItems();
        return flowItems;
    }


}
