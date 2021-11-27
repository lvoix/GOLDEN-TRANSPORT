package com.golden.transport.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.golden.transport.enumeration.OperationType;

import java.io.Serializable;
import java.util.Date;

public class operationCouplageDTO implements Serializable {

    private Long id;
    private String conducteurs1;
    private String conducteurs2;
    private String conducteurs3;
    private String client;

    private String MotifClient;

    private String natureVehicule1;
    private String natureVehicule2;

    private String vehicule1;
    private String vehicule2;

    private String ndossier;
    private OperationType typeoperation;


    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date dateDepart;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date dateArrive;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date dateLivraison;


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

    public String getConducteurs3() {
        return conducteurs3;
    }

    public void setConducteurs3(String conducteurs3) {
        this.conducteurs3 = conducteurs3;
    }

    public String getMotifClient() {
        return MotifClient;
    }

    public void setMotifClient(String motifClient) {
        MotifClient = motifClient;
    }

    public String getNatureVehicule1() {
        return natureVehicule1;
    }

    public void setNatureVehicule1(String natureVehicule1) {
        this.natureVehicule1 = natureVehicule1;
    }

    public String getNatureVehicule2() {
        return natureVehicule2;
    }

    public void setNatureVehicule2(String natureVehicule2) {
        this.natureVehicule2 = natureVehicule2;
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

    public String getNdossier() {
        return ndossier;
    }

    public void setNdossier(String ndossier) {
        this.ndossier = ndossier;
    }

    public OperationType getTypeoperation() {
        return typeoperation;
    }

    public void setTypeoperation(OperationType typeoperation) {
        this.typeoperation = typeoperation;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(Date dateArrive) {
        this.dateArrive = dateArrive;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }
}
