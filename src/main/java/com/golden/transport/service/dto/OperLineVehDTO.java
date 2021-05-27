package com.golden.transport.service.dto;

import com.golden.transport.domain.OperationLineVehicules;

import java.io.Serializable;


public class OperLineVehDTO implements Serializable {

    private Long id;

    private OperationDTO operations;

    //private VehiculeDTO vehicules;

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

   /* public VehiculeDTO getVehicules() {
        return vehicules;
    }

    public void setVehicules(VehiculeDTO vehicules) {
        this.vehicules = vehicules;
    }*/
}
