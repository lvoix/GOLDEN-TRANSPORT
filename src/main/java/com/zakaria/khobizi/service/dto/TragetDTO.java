package com.zakaria.khobizi.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.zakaria.khobizi.domain.Traget} entity.
 */
public class TragetDTO implements Serializable {
    
    private Long id;


    private Long stationDepartId;

    private Long stationDestinationId;

    private Long depenceId;

    private Long sousTragetsId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStationDepartId() {
        return stationDepartId;
    }

    public void setStationDepartId(Long stationId) {
        this.stationDepartId = stationId;
    }

    public Long getStationDestinationId() {
        return stationDestinationId;
    }

    public void setStationDestinationId(Long stationId) {
        this.stationDestinationId = stationId;
    }

    public Long getDepenceId() {
        return depenceId;
    }

    public void setDepenceId(Long depencesId) {
        this.depenceId = depencesId;
    }

    public Long getSousTragetsId() {
        return sousTragetsId;
    }

    public void setSousTragetsId(Long tragetId) {
        this.sousTragetsId = tragetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TragetDTO tragetDTO = (TragetDTO) o;
        if (tragetDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tragetDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TragetDTO{" +
            "id=" + getId() +
            ", stationDepartId=" + getStationDepartId() +
            ", stationDestinationId=" + getStationDestinationId() +
            ", depenceId=" + getDepenceId() +
            ", sousTragetsId=" + getSousTragetsId() +
            "}";
    }
}
