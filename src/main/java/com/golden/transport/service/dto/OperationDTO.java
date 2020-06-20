package com.golden.transport.service.dto;

import com.golden.transport.domain.*;
import com.golden.transport.enumeration.OperationStatus;
import com.golden.transport.enumeration.OperationType;

import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.*;

/**
 * A DTO for the {@link Operation} entity.
 */
public class OperationDTO implements Serializable {

    private Long id;
    private String ndossier;
    private OperationType Operationtype;
    private String refChargement;
    private Date dateCreation;
    private String Libelle;
    private String motifClient;
    private OperationStatus status;
    private Float DotationEuro;
    private Float DotationDH;
    private Date DateUpadte;
    private Date DateFin;
    private Date Datedepart;
    private String TypeMarchandises;
    private Integer PoidsMax;
    private Integer VolumeMax;
    private BeneficiaireDTO beneficiaire;
    protected TargetDTO target;

    private Set<StationDTO> stations = new HashSet<>();
    private Set<AssocaidTOOperLineConDTO> conducteurs = new HashSet<>();
    private Set<AssociadToOperLineVehDTO> vehicules = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNdossier() {
        return ndossier;
    }

    public void setNdossier(String ndossier) {
        this.ndossier = ndossier;
    }

    public OperationType getOperationtype() {
        return Operationtype;
    }

    public void setOperationtype(OperationType operationtype) {
        Operationtype = operationtype;
    }

    public String getRefChargement() {
        return refChargement;
    }

    public void setRefChargement(String refChargement) {
        this.refChargement = refChargement;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public String getMotifClient() {
        return motifClient;
    }

    public void setMotifClient(String motifClient) {
        this.motifClient = motifClient;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    public Float getDotationEuro() {
        return DotationEuro;
    }

    public void setDotationEuro(Float dotationEuro) {
        DotationEuro = dotationEuro;
    }

    public Float getDotationDH() {
        return DotationDH;
    }

    public void setDotationDH(Float dotationDH) {
        DotationDH = dotationDH;
    }

    public Date getDateUpadte() {
        return DateUpadte;
    }

    public void setDateUpadte(Date dateUpadte) {
        DateUpadte = dateUpadte;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateFin(Date dateFin) {
        DateFin = dateFin;
    }

    public Date getDatedepart() {
        return Datedepart;
    }

    public void setDatedepart(Date datedepart) {
        Datedepart = datedepart;
    }

    public String getTypeMarchandises() {
        return TypeMarchandises;
    }

    public void setTypeMarchandises(String typeMarchandises) {
        TypeMarchandises = typeMarchandises;
    }

    public Integer getPoidsMax() {
        return PoidsMax;
    }

    public void setPoidsMax(Integer poidsMax) {
        PoidsMax = poidsMax;
    }

    public Integer getVolumeMax() {
        return VolumeMax;
    }

    public void setVolumeMax(Integer volumeMax) {
        VolumeMax = volumeMax;
    }

    public BeneficiaireDTO getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(BeneficiaireDTO beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public TargetDTO getTarget() {
        return target;
    }

    public void setTarget(TargetDTO target) {
        this.target = target;
    }

    public Set<StationDTO> getStations() {
        return stations;
    }

    public void setStations(Set<StationDTO> stations) {
        this.stations = stations;
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
}
