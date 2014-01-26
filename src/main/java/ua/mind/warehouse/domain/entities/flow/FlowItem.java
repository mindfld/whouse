package ua.mind.warehouse.domain.entities.flow;

import ua.mind.warehouse.domain.entities.storage.Commodity;
import ua.mind.warehouse.domain.entities.user.User;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Сергій on 26.01.14.
 */
@Entity
@Table(name = "FLOWITEMS")
public class FlowItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToOne
    private Commodity commodity;

    @Column
    private Integer quantity;

    @ManyToOne
    private Flow flow;

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

    public Flow getFlow() {
        return flow;
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
    }
}
