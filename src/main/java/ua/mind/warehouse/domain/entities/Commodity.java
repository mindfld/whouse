package ua.mind.warehouse.domain.entities;

import javax.persistence.*;

/**
 * Created by Сергій on 17.01.14.
 */
@Entity
@Table(name = "COMMODITY", uniqueConstraints = {
        @UniqueConstraint(columnNames = "NAME") })
public class Commodity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true,name = "NAME",nullable = false)
    String name;
    @Column
    String description;
    @Column
    MeasurementUnit measurementUnit;

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

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

}
