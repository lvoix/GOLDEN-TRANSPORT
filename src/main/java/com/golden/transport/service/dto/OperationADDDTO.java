package com.golden.transport.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.golden.transport.domain.*;
import com.golden.transport.enumeration.OperationStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;


public class OperationADDDTO implements Serializable {

    private Long id;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date datedepart;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date dateFin;

    private BigDecimal ndossier;
    private String operationtype;
    private OperationStatus status;

    private Vehicule tracteurs ;
    private Vehicule remorques ;

    private Conducteur conducteurs1 ;
    private Conducteur conducteurs2 ;

    private OperLineVehupdateDTO lineV1;
    private OperLineVehupdateDTO lineV2;

    private OperLineConupdateDTO lineC1;
    private OperLineConupdateDTO lineC2;

    private String email;
    private String work;

    private String street;
    private String city;
    private String state;
    private String zip;

    private Client client;

    private Beneficiaire beneficiaire;


    private List<StationDTO> adressesLoad = new ArrayList<StationDTO>();
    private List<StationDTO> adressesLivraison = new ArrayList<StationDTO>();

    private String refChargement;
    private String typeMarchandises;

    private BigDecimal dotationDH;
    private BigDecimal dotationEuro;

    private String motifClient;

    private List<DepencesDTO> depencesall = new ArrayList<DepencesDTO>();

    private Set<InvoicesDTO> invoices = new HashSet<>();

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

    public Vehicule getTracteurs() {
        return tracteurs;
    }

    public void setTracteurs(Vehicule tracteurs) {
        this.tracteurs = tracteurs;
    }

    public Vehicule getRemorques() {
        return remorques;
    }

    public void setRemorques(Vehicule remorques) {
        this.remorques = remorques;
    }

    public Conducteur getConducteurs1() {
        return conducteurs1;
    }

    public void setConducteurs1(Conducteur conducteurs1) {
        this.conducteurs1 = conducteurs1;
    }

    public Conducteur getConducteurs2() {
        return conducteurs2;
    }

    public void setConducteurs2(Conducteur conducteurs2) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public List<StationDTO> getAdressesLoad() {
        return adressesLoad;
    }

    public void setAdressesLoad(List<StationDTO> adressesLoad) {
        this.adressesLoad = adressesLoad;
    }

    public List<StationDTO> getAdressesLivraison() {
        return adressesLivraison;
    }

    public void setAdressesLivraison(List<StationDTO> adressesLivraison) {
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

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    public OperLineVehupdateDTO getLineV1() {
        return lineV1;
    }

    public void setLineV1(OperLineVehupdateDTO lineV1) {
        this.lineV1 = lineV1;
    }

    public OperLineVehupdateDTO getLineV2() {
        return lineV2;
    }

    public void setLineV2(OperLineVehupdateDTO lineV2) {
        this.lineV2 = lineV2;
    }

    public OperLineConupdateDTO getLineC1() {
        return lineC1;
    }

    public void setLineC1(OperLineConupdateDTO lineC1) {
        this.lineC1 = lineC1;
    }

    public OperLineConupdateDTO getLineC2() {
        return lineC2;
    }

    public void setLineC2(OperLineConupdateDTO lineC2) {
        this.lineC2 = lineC2;
    }

    public List<DepencesDTO> getDepencesall() {
        return depencesall;
    }

    public void setDepencesall(List<DepencesDTO> depencesall) {
        this.depencesall = depencesall;
    }

    public Set<InvoicesDTO> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<InvoicesDTO> invoices) {
        this.invoices = invoices;
    }

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
