package ua.mind.warehouse.persistance.dao;

import ua.mind.warehouse.domain.entities.flow.Flow;

import java.util.List;

/**
 * Created by Sergiy_Lesko on 27.01.14.
 */
public interface FlowDAO {
    public List<Flow> listFlows();
    public boolean addFlow(Flow flow);

}
