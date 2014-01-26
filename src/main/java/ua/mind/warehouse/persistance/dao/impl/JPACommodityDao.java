package ua.mind.warehouse.persistance.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.mind.warehouse.domain.entities.storage.StorageItem;
import ua.mind.warehouse.domain.entities.user.User;
import ua.mind.warehouse.persistance.dao.CommodityDao;
import ua.mind.warehouse.persistance.dao.UserDAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергій on 22.01.14.
 */
public class JPACommodityDao implements CommodityDao {

    static final Logger LOGGER = LoggerFactory.getLogger(JPACommodityDao.class);
    private EntityManager entityManager;
    UserDAO userDAO = new JPAUserDao();

    public JPACommodityDao() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("whouse");
        this.entityManager = entityManagerFactory.createEntityManager();
    }


    @Override
    public void addStorageItem(StorageItem item) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(item);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public boolean removeStorageItem(Long index) {
        List<StorageItem> result = new ArrayList<StorageItem>();
        EntityTransaction transaction = entityManager.getTransaction();
        StorageItem toRemove = entityManager.find(StorageItem.class, index);
        try {
            transaction.begin();
            if (toRemove != null) {
                entityManager.remove(toRemove);
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        }
        return false;
    }

    @Override
    public List<StorageItem> listStorageItems() {
        List<StorageItem> result = new ArrayList<StorageItem>();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            result = entityManager.createQuery("SELECT s FROM StorageItem s").getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return result;
    }
}
