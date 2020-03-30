package com.golden.transport.service.dto;

import com.golden.transport.domain.Contact;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link contact} entity.
 */
public class ContactDTO implements Serializable {
    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
