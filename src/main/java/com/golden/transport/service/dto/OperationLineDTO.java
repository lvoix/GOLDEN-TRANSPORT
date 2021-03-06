package com.golden.transport.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link Operation Line Conducteurs} entity.
 */
public class OperationLineDTO implements Serializable {

    private Long id;

    private OperationDTO operations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OperationDTO getOperations() {
        return operations;
    }

    public void setOperations(OperationDTO operations) {
        this.operations = operations;
    }
}

