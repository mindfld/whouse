package ua.mind.warehouse.domain.entities;

import javax.persistence.*;

/**
 * Created by Сергій on 17.01.14.
 */
@Entity
@Table(name="COMMODITY")
public class Commodity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    String name;
    @Column
    String description;
    @Column
    String measurementUnit;

    public Commodity() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }
}
