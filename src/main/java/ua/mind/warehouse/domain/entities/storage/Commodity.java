package ua.mind.warehouse.domain.entities.storage;

import javax.persistence.*;

/**
 * Created by Сергій on 17.01.14.
 */
public class Commodity {

    private Long id;

    private String name;
    private String description;
    private String measurementUnit;

    public Commodity() {
    }

    public Commodity(String name, String description, String measurementUnit) {
        this.name = name;
        this.description = description;
        this.measurementUnit = measurementUnit;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commodity commodity = (Commodity) o;

        if (description != null ? !description.equals(commodity.description) : commodity.description != null)
            return false;
        if (!id.equals(commodity.id)) return false;
        if (measurementUnit != null ? !measurementUnit.equals(commodity.measurementUnit) : commodity.measurementUnit != null)
            return false;
        if (!name.equals(commodity.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (measurementUnit != null ? measurementUnit.hashCode() : 0);
        return result;
    }
}

