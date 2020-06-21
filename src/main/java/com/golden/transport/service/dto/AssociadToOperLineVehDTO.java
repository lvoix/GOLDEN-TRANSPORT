package com.golden.transport.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link Operation Line Vehicules} entity.
 */
public class AssociadToOperLineVehDTO implements Serializable {

    private Long id;

    private AssociadToVehiculeDTO vehicules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AssociadToVehiculeDTO getVehicules() {
        return vehicules;
    }

    public void setVehicules(AssociadToVehiculeDTO vehicules) {
        this.vehicules = vehicules;
    }
}
