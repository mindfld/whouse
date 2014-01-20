package ua.mind.warehouse.persistance;

import ua.mind.warehouse.domain.entities.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергій on 17.01.14.
 */
public class JPADaoImpl implements DAO {
    private EntityManager entityManager;

    public JPADaoImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("whouse");
        this.entityManager = entityManagerFactory.createEntityManager();
    }


    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<User>();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            result = entityManager.createQuery("SELECT u FROM User u").getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return result;
    }

    @Override
    public void addUser(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
