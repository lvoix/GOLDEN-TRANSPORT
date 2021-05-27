package com.golden.transport.service.dto;

import java.io.Serializable;

public class operationCouplageDTO implements Serializable {

    private Long id;
    private ConducteurDTO conducteurs1;
    private ConducteurDTO conducteurs2;
    private ClientDTO client;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConducteurDTO getConducteurs1() {
        return conducteurs1;
    }

    public void setConducteurs1(ConducteurDTO conducteurs1) {
        this.conducteurs1 = conducteurs1;
    }

    public ConducteurDTO getConducteurs2() {
        return conducteurs2;
    }

    public void setConducteurs2(ConducteurDTO conducteurs2) {
        this.conducteurs2 = conducteurs2;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }
}
