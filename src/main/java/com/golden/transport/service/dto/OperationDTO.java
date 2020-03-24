package com.golden.transport.service.dto;

import com.golden.transport.domain.Operation;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Operation} entity.
 */
public class OperationDTO implements Serializable {
    
    private Long id;


    private Long tragetId;

    private Long societeId;

    private Long beneficiaireId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTragetId() {
        return tragetId;
    }

    public void setTragetId(Long tragetId) {
        this.tragetId = tragetId;
    }

    public Long getSocieteId() {
        return societeId;
    }

    public void setSocieteId(Long societeId) {
        this.societeId = societeId;
    }

    public Long getBeneficiaireId() {
        return beneficiaireId;
    }

    public void setBeneficiaireId(Long beneficiaireId) {
        this.beneficiaireId = beneficiaireId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OperationDTO operationDTO = (OperationDTO) o;
        if (operationDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), operationDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OperationDTO{" +
            "id=" + getId() +
            ", tragetId=" + getTragetId() +
            ", societeId=" + getSocieteId() +
            ", beneficiaireId=" + getBeneficiaireId() +
            "}";
    }
}
