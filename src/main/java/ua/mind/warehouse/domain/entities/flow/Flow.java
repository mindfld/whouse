package ua.mind.warehouse.domain.entities.flow;

import ua.mind.warehouse.domain.entities.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Sergiy_Lesko on 27.01.14.
 */
@Entity
@Table(name="FLOWS")
public class Flow implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<FlowItem> flowItems;

    @OneToOne
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FlowItem> getFlowItems() {
        return flowItems;
    }

    public void setFlowItems(List<FlowItem> flowItems) {
        this.flowItems = flowItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
