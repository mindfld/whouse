package ua.mind.warehouse.domain.entities;

import ua.mind.warehouse.domain.entities.user.User;

import javax.persistence.*;

/**
 * Created by Сергій on 17.01.14.
 */
@Entity
@Table(name = "FLOWS")
public class CommodityFlow {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne( cascade=CascadeType.ALL)
    private Commodity commodity;

    @OneToOne(cascade=CascadeType.ALL)
    private User user;

    public CommodityFlow() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
