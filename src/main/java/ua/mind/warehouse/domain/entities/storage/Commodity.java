package ua.mind.warehouse.domain.entities.storage;

import ua.mind.warehouse.domain.entities.MeasurementUnit;
import ua.mind.warehouse.domain.entities.Store;

import javax.persistence.*;

/**
 * Created by Сергій on 17.01.14.
 */
@Entity
@Table(name = "COMMODITY", uniqueConstraints = {
        @UniqueConstraint(columnNames = "NAME")})
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,)
    @Column(name = '')
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Store store;

    @Column(unique = true, name = "NAME", nullable = false)
    String name;
    @Column
    String description;
    @Column
    MeasurementUnit measurementUnit;

    public Commodity() {
    }

    public Commodity(String name, String description, MeasurementUnit measurementUnit) {
        this.name = name;
        this.description = description;
        this.measurementUnit = measurementUnit;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
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