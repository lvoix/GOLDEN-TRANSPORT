package com.golden.transport.service.dto;

import com.golden.transport.domain.Vehicule;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Vehicule} entity.
 */
public class VehiculeDTO implements Serializable {
    
    private Long id;

    private Set<OperLineVehDTO> operations = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<OperLineVehDTO> getOperations() {
        return operations;
    }

    public void setOperations(Set<OperLineVehDTO> operations) {
        this.operations = operations;
    }
}
