package com.golden.transport.service.dto;

import java.io.Serializable;

public class operationDirectionDTO  implements Serializable {

    private Long id;
    private String prenom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
