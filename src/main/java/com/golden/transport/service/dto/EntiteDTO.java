package com.golden.transport.service.dto;

import com.golden.transport.domain.Entite;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Entite} entity.
 */
public class EntiteDTO implements Serializable {
    
    private Long id;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
