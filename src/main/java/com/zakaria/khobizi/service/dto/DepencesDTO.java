package com.zakaria.khobizi.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.zakaria.khobizi.domain.Depences} entity.
 */
public class DepencesDTO implements Serializable {
    
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

        DepencesDTO depencesDTO = (DepencesDTO) o;
        if (depencesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), depencesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DepencesDTO{" +
            "id=" + getId() +
            "}";
    }
}
