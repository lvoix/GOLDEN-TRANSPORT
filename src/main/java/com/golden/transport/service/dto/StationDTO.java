package com.golden.transport.service.dto;

import com.golden.transport.domain.Station;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Station} entity.
 */
public class StationDTO implements Serializable {
    
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }



}
