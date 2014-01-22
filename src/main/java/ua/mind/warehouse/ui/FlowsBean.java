package ua.mind.warehouse.ui;

import ua.mind.warehouse.domain.entities.CommodityFlow;
import ua.mind.warehouse.domain.entities.user.User;
import ua.mind.warehouse.persistance.CommodityFlowDao;
import ua.mind.warehouse.persistance.CommodityFlowDaoImpl;
import ua.mind.warehouse.persistance.JPAUserDaoImpl;
import ua.mind.warehouse.persistance.UserDAO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Сергій on 22.01.14.
 */
@ManagedBean
@RequestScoped
public class FlowsBean {
    private List<CommodityFlow> commodityFlows;
    CommodityFlowDao commodityFlowDao =new CommodityFlowDaoImpl();


    public List<CommodityFlow> getCommodityFlows() {
        if (commodityFlows == null) {
            commodityFlows = commodityFlowDao.listFlows();
        }
        return commodityFlows;
    }

    public void setCommodityFlows(List<CommodityFlow> commodityFlows) {
        this.commodityFlows = commodityFlows;
    }
}
