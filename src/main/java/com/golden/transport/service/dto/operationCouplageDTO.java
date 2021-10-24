package com.golden.transport.service.dto;

import java.io.Serializable;

public class operationCouplageDTO implements Serializable {

    private Long id;
    private String conducteurs1;
    private String conducteurs2;
    private String client;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConducteurs1() {
        return conducteurs1;
    }

    public void setConducteurs1(String conducteurs1) {
        this.conducteurs1 = conducteurs1;
    }

    public String getConducteurs2() {
        return conducteurs2;
    }

    public void setConducteurs2(String conducteurs2) {
        this.conducteurs2 = conducteurs2;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
