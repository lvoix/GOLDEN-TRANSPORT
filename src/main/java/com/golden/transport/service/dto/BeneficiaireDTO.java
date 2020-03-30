package com.golden.transport.service.dto;

import com.golden.transport.domain.Beneficiaire;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Beneficiaire} entity.
 */
public class BeneficiaireDTO implements Serializable {
    
    private Long id;
    private AddressDTO address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BeneficiaireDTO beneficiaireDTO = (BeneficiaireDTO) o;
        if (beneficiaireDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), beneficiaireDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BeneficiaireDTO{" +
            "id=" + getId() +
            "}";
    }
}
