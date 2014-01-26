package ua.mind.warehouse.domain.entities.storage;

import ua.mind.warehouse.domain.entities.MeasurementUnit;

import javax.persistence.*;

/**
 * Created by Сергій on 17.01.14.
 */
@Entity
@Table(name = "COMMODITY", uniqueConstraints = {
        @UniqueConstraint(columnNames = "NAME")})
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMODITY_ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STORAGE_ID", nullable = false)
    private Storage storage;

    @Column(name = "NAME", unique = true, nullable = false)
    String name;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "MEASUREMENT", nullable = false)
    MeasurementUnit measurementUnit;

    public Commodity() {
    }

    public Commodity(String name, String description, MeasurementUnit measurementUnit) {
        this.name = name;
        this.description = description;
        this.measurementUnit = measurementUnit;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
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
