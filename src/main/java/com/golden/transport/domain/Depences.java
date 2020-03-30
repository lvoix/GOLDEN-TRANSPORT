package com.golden.transport.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Station.
 */
@Entity
@Table(name = "depences")
public class Depences implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Depences)) {
            return false;
        }
        return id != null && id.equals(((Depences) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Depences{" +
            "id=" + getId() +
            "}";
    }
}
