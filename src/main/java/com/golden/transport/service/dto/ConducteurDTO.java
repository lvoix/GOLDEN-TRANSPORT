package com.golden.transport.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Conducteur} entity.
 */
public class ConducteurDTO implements Serializable {
    
    private Long id;

    private Set<OperLineConDTO> operations = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public Set<OperLineConDTO> getOperations() {
        return operations;
    }

    public void setOperations(Set<OperLineConDTO> operations) {
        this.operations = operations;
    }
}
