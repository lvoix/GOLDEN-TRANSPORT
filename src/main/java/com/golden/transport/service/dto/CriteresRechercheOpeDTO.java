package com.golden.transport.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.golden.transport.enumeration.OperationType;

import java.util.Date;


public class CriteresRechercheOpeDTO {
    

    private Long numeroOperation;
    private OperationType typoperation;
    private String ndossier;
    private String vehicule1;
    private String vehicule2;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date startDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date endDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date dateDepart;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date dateLivraison;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date dateArrive;


    public Long getNumeroOperation() {
        return numeroOperation;
    }

    public void setNumeroOperation(Long numeroOperation) {
        this.numeroOperation = numeroOperation;
    }

    public OperationType getTypoperation() {
        return typoperation;
    }

    public void setTypoperation(OperationType typoperation) {
        this.typoperation = typoperation;
    }

    public String getNdossier() {
        return ndossier;
    }

    public void setNdossier(String ndossier) {
        this.ndossier = ndossier;
    }

    public String getVehicule1() {
        return vehicule1;
    }

    public void setVehicule1(String vehicule1) {
        this.vehicule1 = vehicule1;
    }

    public String getVehicule2() {
        return vehicule2;
    }

    public void setVehicule2(String vehicule2) {
        this.vehicule2 = vehicule2;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Date getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(Date dateArrive) {
        this.dateArrive = dateArrive;
    }
}
