package com.golden.transport.service.dto;

import com.golden.transport.domain.Vehicule;

import java.io.Serializable;

/**
 * A DTO for the {@link Vehicule} entity.
 */
public class AssociadToVehiculeDTO implements Serializable {
    
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
