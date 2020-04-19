package com.golden.transport.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link Conducteur} entity.
 */
public class AssociadToConducteurDTO implements Serializable {
    
    private Long id;
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

}
