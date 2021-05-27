package com.golden.transport.service.dto;

import com.golden.transport.enumeration.OperationStatus;
import com.golden.transport.enumeration.OperationType;

import java.io.Serializable;
import java.util.*;


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
    private ClientDTO client;
    private BeneficiaireDTO beneficiaire;
    protected TargetDTO target;
    private Boolean facturer;
    private Set<StationDTO> stations = new HashSet<>();
    private Set<AssocaidTOOperLineConDTO> conducteurs = new HashSet<>();
    private Set<AssociadToOperLineVehDTO> vehicules = new HashSet<>();
    private Set<DepencesDTO> depences = new HashSet<>();
    private Set<InvoicesDTO> invoices = new HashSet<>();

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

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
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

    public Boolean getFacturer() {
        return facturer;
    }

    public void setFacturer(Boolean facturer) {
        this.facturer = facturer;
    }

    public Set<DepencesDTO> getDepences() {
        return depences;
    }

    public void setDepences(Set<DepencesDTO> depences) {
        this.depences = depences;
    }

    public Set<InvoicesDTO> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<InvoicesDTO> invoices) {
        this.invoices = invoices;
    }

    public BeneficiaireDTO getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(BeneficiaireDTO beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override
    public String toString() {
        return "OperationDTO{" +
                "id=" + id +
                ", ndossier='" + ndossier + '\'' +
                ", Operationtype=" + Operationtype +
                ", refChargement='" + refChargement + '\'' +
                ", dateCreation=" + dateCreation +
                ", Libelle='" + Libelle + '\'' +
                ", motifClient='" + motifClient + '\'' +
                ", status=" + status +
                ", DotationEuro=" + DotationEuro +
                ", DotationDH=" + DotationDH +
                ", DateUpadte=" + DateUpadte +
                ", DateFin=" + DateFin +
                ", Datedepart=" + Datedepart +
                ", TypeMarchandises='" + TypeMarchandises + '\'' +
                ", PoidsMax=" + PoidsMax +
                ", VolumeMax=" + VolumeMax +
                ", client=" + client +
                ", target=" + target +
                ", facturer=" + facturer +
                ", stations=" + stations +
                ", conducteurs=" + conducteurs +
                ", vehicules=" + vehicules +
                ", depences=" + depences +
                '}';
    }
}
