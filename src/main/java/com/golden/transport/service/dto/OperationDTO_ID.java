package com.golden.transport.service.dto;


import java.io.Serializable;


public class OperationDTO_ID implements Serializable {

    private Long id;

    private ClientDTO_ID client;

    private BeneficiaireDTO_ID beneficiaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientDTO_ID getClient() {
        return client;
    }

    public void setClient(ClientDTO_ID client) {
        this.client = client;
    }

    public BeneficiaireDTO_ID getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(BeneficiaireDTO_ID beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
