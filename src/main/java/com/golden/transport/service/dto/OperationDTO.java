package com.golden.transport.service.dto;

import java.io.Serializable;
import java.util.*;

/**
 * A DTO for the {@link Operation} entity.
 */
public class OperationDTO implements Serializable {

    private Long id;

    private BeneficiaireDTO beneficiaire;

    private Set<AssocaidTOOperLineConDTO> conducteurs = new HashSet<>();

    private Set<AssociadToOperLineVehDTO> vehicules = new HashSet<>();

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

    public Set<AssocaidTOOperLineConDTO> getConducteurs() {
        return conducteurs;
    }

    public void setConducteurs(Set<AssocaidTOOperLineConDTO> conducteurs) {
        this.conducteurs = conducteurs;
    }

    public Set<AssociadToOperLineVehDTO> getVehicules() {
        return vehicules;
    }

    public void setVehicules(Set<AssociadToOperLineVehDTO> vehicules) {
        this.vehicules = vehicules;
    }

    public TargetDTO getTarget() {
        return target;
    }

    public void setTarget(TargetDTO target) {
        this.target = target;
    }
}
