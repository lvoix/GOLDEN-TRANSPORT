package com.golden.transport.service.dto;

import java.io.Serializable;


public class AssociadToOperLineVehDTO implements Serializable {

    private Long id;

    private Long numerOrder ;

    private AssociadToVehiculeDTO vehicules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumerOrder() {
        return numerOrder;
    }

    public void setNumerOrder(Long numerOrder) {
        this.numerOrder = numerOrder;
    }

    public AssociadToVehiculeDTO getVehicules() {
        return vehicules;
    }

    public void setVehicules(AssociadToVehiculeDTO vehicules) {
        this.vehicules = vehicules;
    }
}
