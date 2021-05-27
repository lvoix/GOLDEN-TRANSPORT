package com.golden.transport.service.dto;

import java.io.Serializable;


public class OperLineConupdateDTO implements Serializable {

    private Long id;

    private AssociadToConducteurDTO conducteurs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AssociadToConducteurDTO getConducteurs() {
        return conducteurs;
    }

    public void setConducteurs(AssociadToConducteurDTO conducteurs) {
        this.conducteurs = conducteurs;
    }
}

