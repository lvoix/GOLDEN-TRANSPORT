package com.golden.transport.service.dto;

import com.golden.transport.domain.OperationLineConducteurs;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Operation Line Conducteurs} entity.
 */
public class OperLineConDTO implements Serializable {

    private Long id;

    private OperationDTO operations;

    //private ConducteurDTO conducteurs;

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

   /* public ConducteurDTO getConducteurs() {
        return conducteurs;
    }

    public void setConducteurs(ConducteurDTO conducteurs) {
        this.conducteurs = conducteurs;
    }*/
}
