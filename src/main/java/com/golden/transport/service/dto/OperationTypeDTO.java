package com.golden.transport.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OperationTypeDTO {

    private Long id;
    private String libelle;
    private String code;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}