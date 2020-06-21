package com.golden.transport.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.golden.transport.enumeration.OperationStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A DTO for the {@link Operation} entity.
 */
public class OperationUpdateDTO implements Serializable {

    private Long id;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date datedepart;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date dateFin;

    private BigDecimal ndossier;
    private String operationtype;
    private OperationStatus status;

    private VehiculeDTO tracteurs ;
    private VehiculeDTO remorques ;

    private ConducteurDTO conducteurs1 ;
    private ConducteurDTO conducteurs2 ;

    private String email;
    private String work;

    private String street;
    private String city;
    private String state;
    private String zip;

    private BeneficiaireDTO beneficiaire ;

    private List<AddressDTO> adressesLoad = new ArrayList<AddressDTO>();
    private List<AddressDTO> adressesLivraison = new ArrayList<AddressDTO>();

    private String refChargement;
    private String typeMarchandises;

    private BigDecimal dotationDH;
    private BigDecimal dotationEuro;

    private String motifClient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(Date datedepart) {
        this.datedepart = datedepart;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public BigDecimal getNdossier() {
        return ndossier;
    }

    public void setNdossier(BigDecimal ndossier) {
        this.ndossier = ndossier;
    }

    public String getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(String operationtype) {
        this.operationtype = operationtype;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    public VehiculeDTO getTracteurs() {
        return tracteurs;
    }

    public void setTracteurs(VehiculeDTO tracteurs) {
        this.tracteurs = tracteurs;
    }

    public VehiculeDTO getRemorques() {
        return remorques;
    }

    public void setRemorques(VehiculeDTO remorques) {
        this.remorques = remorques;
    }

    public ConducteurDTO getConducteurs1() {
        return conducteurs1;
    }

    public void setConducteurs1(ConducteurDTO conducteurs1) {
        this.conducteurs1 = conducteurs1;
    }

    public ConducteurDTO getConducteurs2() {
        return conducteurs2;
    }

    public void setConducteurs2(ConducteurDTO conducteurs2) {
        this.conducteurs2 = conducteurs2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public BeneficiaireDTO getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(BeneficiaireDTO beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public List<AddressDTO> getAdressesLoad() {
        return adressesLoad;
    }

    public void setAdressesLoad(List<AddressDTO> adressesLoad) {
        this.adressesLoad = adressesLoad;
    }

    public List<AddressDTO> getAdressesLivraison() {
        return adressesLivraison;
    }

    public void setAdressesLivraison(List<AddressDTO> adressesLivraison) {
        this.adressesLivraison = adressesLivraison;
    }

    public String getRefChargement() {
        return refChargement;
    }

    public void setRefChargement(String refChargement) {
        this.refChargement = refChargement;
    }

    public String getTypeMarchandises() {
        return typeMarchandises;
    }

    public void setTypeMarchandises(String typeMarchandises) {
        this.typeMarchandises = typeMarchandises;
    }

    public BigDecimal getDotationDH() {
        return dotationDH;
    }

    public void setDotationDH(BigDecimal dotationDH) {
        this.dotationDH = dotationDH;
    }

    public BigDecimal getDotationEuro() {
        return dotationEuro;
    }

    public void setDotationEuro(BigDecimal dotationEuro) {
        this.dotationEuro = dotationEuro;
    }

    public String getMotifClient() {
        return motifClient;
    }

    public void setMotifClient(String motifClient) {
        this.motifClient = motifClient;
    }
}
