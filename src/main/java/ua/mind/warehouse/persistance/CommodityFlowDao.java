package ua.mind.warehouse.persistance;

import ua.mind.warehouse.domain.entities.CommodityFlow;

import java.util.List;

/**
 * Created by Сергій on 22.01.14.
 */
public interface CommodityFlowDao {
    public List <CommodityFlow> listFlows();
}
