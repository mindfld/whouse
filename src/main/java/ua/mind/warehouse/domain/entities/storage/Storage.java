package ua.mind.warehouse.domain.entities.storage;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    List<Commodity> commodity;

    @Column(name = "QUANTITY", nullable = false)
    Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Commodity> getCommodity() {
        return commodity;
    }

    public void setCommodity(List<Commodity> commodity) {
        this.commodity = commodity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
