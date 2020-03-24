package com.zakaria.khobizi.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.zakaria.khobizi.domain.Chauffeur} entity.
 */
public class ChauffeurDTO implements Serializable {
    
    private Long id;


    private Long societesId;

    private Long vehiculesId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSocietesId() {
        return societesId;
    }

    public void setSocietesId(Long societeId) {
        this.societesId = societeId;
    }

    public Long getVehiculesId() {
        return vehiculesId;
    }

    public void setVehiculesId(Long vehiculeId) {
        this.vehiculesId = vehiculeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ChauffeurDTO chauffeurDTO = (ChauffeurDTO) o;
        if (chauffeurDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), chauffeurDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ChauffeurDTO{" +
            "id=" + getId() +
            ", societesId=" + getSocietesId() +
            ", vehiculesId=" + getVehiculesId() +
            "}";
    }
}
