package com.golden.transport.service.dto;

import com.golden.transport.domain.Vehicule;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Vehicule} entity.
 */
public class VehiculeDTO implements Serializable {
    
    private Long id;


    private Long vehiculesId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehiculesId() {
        return vehiculesId;
    }

    public void setVehiculesId(Long tragetId) {
        this.vehiculesId = tragetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VehiculeDTO vehiculeDTO = (VehiculeDTO) o;
        if (vehiculeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vehiculeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VehiculeDTO{" +
            "id=" + getId() +
            ", vehiculesId=" + getVehiculesId() +
            "}";
    }
}
