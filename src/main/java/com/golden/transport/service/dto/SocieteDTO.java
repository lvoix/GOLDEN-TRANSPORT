package com.golden.transport.service.dto;

import com.golden.transport.domain.Societe;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Societe} entity.
 */
public class SocieteDTO implements Serializable {
    
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

        SocieteDTO societeDTO = (SocieteDTO) o;
        if (societeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), societeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SocieteDTO{" +
            "id=" + getId() +
            "}";
    }
}
