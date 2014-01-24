package ua.mind.warehouse.persistance.dao.impl;

import ua.mind.warehouse.domain.entities.user.User;
import ua.mind.warehouse.persistance.dao.UserDAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергій on 17.01.14.
 */
public class JPAUserDao implements UserDAO {
    private EntityManager entityManager;

    public JPAUserDao() {
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

    @Override
    public User getUserByCredentials(String login, String password) {
        Query q = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :pass");
        q.setParameter("login", login);
        q.setParameter("pass", password);
        try {
            User user = (User) q.getSingleResult();
            if (login.equalsIgnoreCase(user.getLogin()) && password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
            System.out.println("Ololo");
                        //TODO LOGIN ERROR
        }
        return null;
    }
}