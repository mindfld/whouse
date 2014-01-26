package ua.mind.warehouse.domain.entities.storage;

import ua.mind.warehouse.domain.entities.MeasurementUnit;
import ua.mind.warehouse.domain.entities.Store;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Сергій on 26.01.14.
 */
@Entity
@Table(name = "STORAGE")
public class Storage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STORAGE_ID", unique = true, nullable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Commodity commodity;

    @Column(name = "QUANTITY", nullable = false)
    Integer quantity;

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
}
