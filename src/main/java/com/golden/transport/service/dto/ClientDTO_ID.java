package com.golden.transport.service.dto;

import com.golden.transport.enumeration.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class ClientDTO_ID implements Serializable {
    
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
