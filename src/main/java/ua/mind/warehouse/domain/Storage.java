package ua.mind.warehouse.domain;

import java.io.Serializable;

/**
 * Created by Sergiy_Lesko on 17.06.2014.
 */
public class Storage implements Serializable {
    private Long id;
    private Commodity commodity;
    private Double available = 0.0;

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

    public Double getAvailable() {
        return available;
    }

    public void setAvailable(Double available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Storage storage = (Storage) o;

        if (!available.equals(storage.available)) return false;
        if (!commodity.equals(storage.commodity)) return false;
        if (!id.equals(storage.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + commodity.hashCode();
        result = 31 * result + available.hashCode();
        return result;
    }
}
