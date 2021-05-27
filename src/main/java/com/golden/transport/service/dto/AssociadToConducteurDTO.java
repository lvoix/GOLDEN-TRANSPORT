package com.golden.transport.service.dto;

import java.io.Serializable;


public class AssociadToConducteurDTO implements Serializable {
    
    private Long id;
    private String name;
    private String firstName;
    private String lastName;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
