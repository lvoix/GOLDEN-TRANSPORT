package com.zakaria.khobizi.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.zakaria.khobizi.domain.Station} entity.
 */
public class StationDTO implements Serializable {
    
    private Long id;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StationDTO stationDTO = (StationDTO) o;
        if (stationDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), stationDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StationDTO{" +
            "id=" + getId() +
            "}";
    }
}
