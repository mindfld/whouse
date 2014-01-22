package ua.mind.warehouse.persistance;

import ua.mind.warehouse.domain.entities.CommodityFlow;
import ua.mind.warehouse.domain.entities.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергій on 22.01.14.
 */
public class CommodityFlowDaoImpl implements CommodityFlowDao {

    private EntityManager entityManager;

    public CommodityFlowDaoImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("whouse");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<CommodityFlow> listFlows() {
        List<CommodityFlow> result = new ArrayList<CommodityFlow>();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            result = entityManager.createQuery("SELECT f FROM CommodityFlow f").getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return result;
    }
}
