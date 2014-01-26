package ua.mind.warehouse.domain.entities.storage;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Сергій on 26.01.14.
 */
@Entity
@Table(name = "STORAGE")
public class StorageItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Commodity commodity;

    @Column( nullable = false)
    Integer quantity;

    public StorageItem() {
    }

    public StorageItem(Commodity commodity, Integer quantity) {
        this.commodity = commodity;
        this.quantity = quantity;
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
}
