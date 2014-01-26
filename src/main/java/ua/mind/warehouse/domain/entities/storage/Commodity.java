package ua.mind.warehouse.domain.entities.storage;

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
    @Column( unique = true, nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private StorageItem storage;

    @Column(unique = true, nullable = false)
    String name;
    @Column
    String description;
    @Column(nullable = false)
    MeasurementUnit measurementUnit;

    public Commodity() {
    }

    public Commodity(String name, String description, MeasurementUnit measurementUnit) {
        this.name = name;
        this.description = description;
        this.measurementUnit = measurementUnit;
    }

    public StorageItem getStorage() {
        return storage;
    }

    public void setStorage(StorageItem storage) {
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
