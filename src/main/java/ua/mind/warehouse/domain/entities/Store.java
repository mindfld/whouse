package ua.mind.warehouse.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sergiy_Lesko on 24.01.14.
 */
@Entity
@Table(name = "STORE")
public class Store implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Commodity commodity;

    @Column
    Integer quantity = 0;

    public Store(Commodity commodity, Integer quantity) {
        this.commodity=commodity;
        this.quantity = quantity;
    }

    public Store() {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Store store = (Store) o;

        if (commodity != null ? !commodity.equals(store.commodity) : store.commodity != null) return false;
        if (id != null ? !id.equals(store.id) : store.id != null) return false;
        if (quantity != null ? !quantity.equals(store.quantity) : store.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (commodity != null ? commodity.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
