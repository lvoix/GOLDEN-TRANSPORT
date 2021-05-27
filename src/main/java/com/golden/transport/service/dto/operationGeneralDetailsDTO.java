package com.golden.transport.service.dto;

import java.io.Serializable;

public class operationGeneralDetailsDTO implements Serializable {

    private Long id;
    private String others;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
