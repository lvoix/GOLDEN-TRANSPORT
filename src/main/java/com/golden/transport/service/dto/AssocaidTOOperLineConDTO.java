package com.golden.transport.service.dto;

import java.io.Serializable;


public class AssocaidTOOperLineConDTO implements Serializable {

    private Long id;

    private Long numerOrder ;

    private AssociadToConducteurDTO conducteurs;

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

    public AssociadToConducteurDTO getConducteurs() {
        return conducteurs;
    }

    public void setConducteurs(AssociadToConducteurDTO conducteurs) {
        this.conducteurs = conducteurs;
    }
}
