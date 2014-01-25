package ua.mind.warehouse.domain.entities;

import ua.mind.warehouse.domain.entities.user.User;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sergiy_Lesko on 23.01.14.
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "ORDERITEMS")
    private List<Store> store;

    @OneToOne(cascade = CascadeType.REFRESH)
    private User user;

    @Column
    private boolean completed = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Store> getStore() {
        return store;
    }

    public void setStore(List<Store> store) {
        this.store = store;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Order(List<Store> store, User user, boolean completed) {
        this.store = store;
        this.user = user;
        this.completed = completed;
    }
}
