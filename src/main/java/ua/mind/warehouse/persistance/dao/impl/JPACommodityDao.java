package ua.mind.warehouse.persistance.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.mind.warehouse.domain.entities.Commodity;
import ua.mind.warehouse.domain.entities.Order;
import ua.mind.warehouse.domain.entities.Store;
import ua.mind.warehouse.persistance.dao.CommodityDao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергій on 22.01.14.
 */
public class JPACommodityDao implements CommodityDao {

    static final Logger LOGGER = LoggerFactory.getLogger(JPACommodityDao.class);
    private EntityManager entityManager;

    public JPACommodityDao() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("whouse");
        this.entityManager = entityManagerFactory.createEntityManager();
    }


    @Override
    public List<Commodity> listCommodity() {
        List<Commodity> result = new ArrayList<Commodity>();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            result = entityManager.createQuery("SELECT c FROM Commodity c").getResultList();
            transaction.commit();
        } catch (Exception e) {
            LOGGER.warn("Unable to load commodities");
            transaction.rollback();
        }
        return result;
    }
    @Override
    public List<Store> listStore() {
        List<Store> result = new ArrayList<Store>();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            result = entityManager.createQuery("SELECT s FROM Store s").getResultList();
            transaction.commit();
        } catch (Exception e) {
            LOGGER.warn("Unable to list store items");
            transaction.rollback();
        }
        return result;
    }
    @Override
    public List<Order> listOrders() {
        List<Order> result = new ArrayList<Order>();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            result = entityManager.createQuery("SELECT o FROM Order o").getResultList();
            transaction.commit();
        } catch (Exception e) {
            LOGGER.warn("Unable to load orders");
            transaction.rollback();
        }
        return result;
    }

    @Override
    public boolean addOrder(Order order) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(order);
            transaction.commit();
            return true;
        } catch (Exception e) {
            LOGGER.warn("Unable to persist order");
            transaction.rollback();
        }
        return false;
    }

    @Override
    public boolean addCommodities(Commodity commodity, Integer quantity) {
        Store store = getStoreByCommodityName(commodity.getName());
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            if (store != null) {
                store.setQuantity(quantity + store.getQuantity());
            } else {
                store = new Store();
                store.setCommodity(commodity);
                store.setQuantity(quantity);
            }
            transaction.begin();
            entityManager.merge(store);
            transaction.commit();
            return true;
        } catch (Exception e) {
            LOGGER.warn("Unable to persist commodity");
            transaction.rollback();
        }
        return false;
    }

    @Override
    public Store getStoreByCommodityName(String name) {
        EntityTransaction transaction = entityManager.getTransaction();
        Store findedStore = null;
        Query q = entityManager.createQuery("SELECT s FROM Store s WHERE s.commodity.name= :nam");
        q.setParameter("nam", name);

        try {
            transaction.begin();
            findedStore = (Store) q.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            LOGGER.warn("Unable to find Store entity" + e);
            transaction.rollback();
        }
        return findedStore;
    }
}
