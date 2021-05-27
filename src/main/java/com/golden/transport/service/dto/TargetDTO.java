package com.golden.transport.service.dto;

import com.golden.transport.domain.Target;

import java.io.Serializable;
import java.util.Objects;


public class TargetDTO implements Serializable {
    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
