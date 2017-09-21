package ua.mind.warehouse.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sergiy_Lesko on 18.06.2014.
 */
public class Flow implements Serializable {
    private Long id;
    private Double balance;
    private String comments;
    private Date date;
    private String userName;
    private String measurementUnit;
    private String productName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flow flow = (Flow) o;

        if (!balance.equals(flow.balance)) return false;
        if (!comments.equals(flow.comments)) return false;
        if (!date.equals(flow.date)) return false;
        if (!id.equals(flow.id)) return false;
        if (!measurementUnit.equals(flow.measurementUnit)) return false;
        if (!userName.equals(flow.userName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + balance.hashCode();
        result = 31 * result + comments.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + measurementUnit.hashCode();
        return result;
    }
}
