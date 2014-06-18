package ua.mind.warehouse.persistance.dao;

import ua.mind.warehouse.domain.entities.flow.Flow;

import java.util.List;

/**
 * Created by Сергій on 22.01.14.
 */
public interface FlowDAO {
    public List<Flow> listFlowItems();
}

