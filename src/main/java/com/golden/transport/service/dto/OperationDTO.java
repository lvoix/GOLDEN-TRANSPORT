package com.golden.transport.service.dto;

import java.io.Serializable;
import java.util.*;

/**
 * A DTO for the {@link Operation} entity.
 */
public class OperationDTO implements Serializable {

    private Long id;

    private BeneficiaireDTO beneficiaire;

    // private Set<OperLineConDTO> conducteurs = new HashSet<>();

   // private Set<OperLineVehDTO> vehicules = new HashSet<>();

    protected TargetDTO target;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BeneficiaireDTO getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(BeneficiaireDTO beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
/*
    public Set<OperLineConDTO> getConducteurs() {
        return conducteurs;
    }

    public void setConducteurs(Set<OperLineConDTO> conducteurs) {
        this.conducteurs = conducteurs;
    }

    public Set<OperLineVehDTO> getVehicules() {
        return vehicules;
    }

    public void setVehicules(Set<OperLineVehDTO> vehicules) {
        this.vehicules = vehicules;
    }*/

    public TargetDTO getTarget() {
        return target;
    }

    public void setTarget(TargetDTO target) {
        this.target = target;
    }
}
