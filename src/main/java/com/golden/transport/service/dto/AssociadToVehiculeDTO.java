package com.golden.transport.service.dto;

import com.golden.transport.domain.Vehicule;
import com.golden.transport.enumeration.VehiculeGenre;
import com.golden.transport.enumeration.VehiculeType;


import java.io.Serializable;


public class AssociadToVehiculeDTO implements Serializable {
    
    private Long id;
    private String matricule;
    private VehiculeType VehiculeType;
    private VehiculeGenre Genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public VehiculeType getVehiculeType() {
        return VehiculeType;
    }

    public void setVehiculeType(VehiculeType vehiculeType) {
        VehiculeType = vehiculeType;
    }

    public VehiculeGenre getGenre() {
        return Genre;
    }

    public void setGenre(VehiculeGenre genre) {
        Genre = genre;
    }
}
