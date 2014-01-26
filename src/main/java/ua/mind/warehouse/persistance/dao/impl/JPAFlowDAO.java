package ua.mind.warehouse.persistance.dao.impl;

import ua.mind.warehouse.domain.entities.flow.Flow;
import ua.mind.warehouse.domain.entities.user.User;
import ua.mind.warehouse.persistance.dao.FlowDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergiy_Lesko on 27.01.14.
 */
public class JPAFlowDAO implements FlowDAO {
    private EntityManager entityManager;

    public JPAFlowDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("whouse");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<Flow> listFlows() {
        List<Flow> result = new ArrayList<Flow>();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            result = entityManager.createQuery("SELECT f FROM Flow f").getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return result;
    }

    @Override
    public boolean addFlow(Flow flow) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(flow);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        }
        return false;
    }
}
