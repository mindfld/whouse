package ua.mind.warehouse.domain.entities.storage;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Сергій on 17.02.14.
 */
@Entity
@Table(name = "CATEGORY", uniqueConstraints = {
        @UniqueConstraint(columnNames = "NAME")})
public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Commodity> commodityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Commodity> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<Commodity> commodityList) {
        this.commodityList = commodityList;
    }
}
