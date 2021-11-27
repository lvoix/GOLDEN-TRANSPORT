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
    private Date dateLivraison;
    private Date dateArrive;


    private Double montantOpe;

    private String deviseOpe;

    private String motifMontant;

    private String modeEmbarquement;

    private String extensionGeo;

    private String TypeMarchandises;
    private Integer PoidsMax;
    private Integer VolumeMax;
    private ClientDTO client;

    private String natureVehicule1;
    private String natureVehicule2;
    private String others;


    private Long conducteurs1;
    private Long conducteurs2;
    private Long conducteurs3;

    private Long vehicule1;
    private Long vehicule2;

    private Set<AssocaidTOOperLineConDTO> conducteurs = new HashSet<>();
    private Set<AssociadToOperLineVehDTO> vehicules = new HashSet<>();
    private Set<DepencesDTO> depences = new HashSet<>();
    private Set<StationDTO> stations = new HashSet<>();

     private BeneficiaireDTO beneficiaire;
     /* protected TargetDTO target;
    private Boolean facturer;
    private Set<AssocaidTOOperLineConDTO> conducteurs = new HashSet<>();
    private Set<AssociadToOperLineVehDTO> vehicules = new HashSet<>();
    private Set<DepencesDTO> depences = new HashSet<>();
    private Set<InvoicesDTO> invoices = new HashSet<>();*/

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

    public Set<DepencesDTO> getDepences() {
        return depences;
    }

    public void setDepences(Set<DepencesDTO> depences) {
        this.depences = depences;
    }

    public Set<StationDTO> getStations() {
        return stations;
    }

    public void setStations(Set<StationDTO> stations) {
        this.stations = stations;
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

    public Double getMontantOpe() {
        return montantOpe;
    }

    public void setMontantOpe(Double montantOpe) {
        this.montantOpe = montantOpe;
    }

    public String getDeviseOpe() {
        return deviseOpe;
    }

    public void setDeviseOpe(String deviseOpe) {
        this.deviseOpe = deviseOpe;
    }

    public String getMotifMontant() {
        return motifMontant;
    }

    public void setMotifMontant(String motifMontant) {
        this.motifMontant = motifMontant;
    }

    public String getModeEmbarquement() {
        return modeEmbarquement;
    }

    public void setModeEmbarquement(String modeEmbarquement) {
        this.modeEmbarquement = modeEmbarquement;
    }

    public String getExtensionGeo() {
        return extensionGeo;
    }

    public void setExtensionGeo(String extensionGeo) {
        this.extensionGeo = extensionGeo;
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

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public Long getConducteurs1() {
        return conducteurs1;
    }

    public void setConducteurs1(Long conducteurs1) {
        this.conducteurs1 = conducteurs1;
    }

    public Long getConducteurs2() {
        return conducteurs2;
    }

    public void setConducteurs2(Long conducteurs2) {
        this.conducteurs2 = conducteurs2;
    }

    public Long getConducteurs3() {
        return conducteurs3;
    }

    public void setConducteurs3(Long conducteurs3) {
        this.conducteurs3 = conducteurs3;
    }

    public Long getVehicule1() {
        return vehicule1;
    }

    public void setVehicule1(Long vehicule1) {
        this.vehicule1 = vehicule1;
    }

    public Long getVehicule2() {
        return vehicule2;
    }

    public void setVehicule2(Long vehicule2) {
        this.vehicule2 = vehicule2;
    }

    public BeneficiaireDTO getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(BeneficiaireDTO beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationDTO)) return false;
        OperationDTO that = (OperationDTO) o;
        return getId().equals(that.getId()) &&
                getNdossier().equals(that.getNdossier()) &&
                getOperationtype() == that.getOperationtype() &&
                Objects.equals(getRefChargement(), that.getRefChargement()) &&
                getDateCreation().equals(that.getDateCreation()) &&
                Objects.equals(getLibelle(), that.getLibelle()) &&
                Objects.equals(getMotifClient(), that.getMotifClient()) &&
                getStatus() == that.getStatus() &&
                Objects.equals(getDotationEuro(), that.getDotationEuro()) &&
                Objects.equals(getDotationDH(), that.getDotationDH()) &&
                Objects.equals(getDateUpadte(), that.getDateUpadte()) &&
                Objects.equals(getDateFin(), that.getDateFin()) &&
                getDatedepart().equals(that.getDatedepart()) &&
                Objects.equals(getDateLivraison(), that.getDateLivraison()) &&
                Objects.equals(getDateArrive(), that.getDateArrive()) &&
                getMontantOpe().equals(that.getMontantOpe()) &&
                getDeviseOpe().equals(that.getDeviseOpe()) &&
                Objects.equals(getMotifMontant(), that.getMotifMontant()) &&
                getModeEmbarquement().equals(that.getModeEmbarquement()) &&
                getExtensionGeo().equals(that.getExtensionGeo()) &&
                getTypeMarchandises().equals(that.getTypeMarchandises()) &&
                Objects.equals(getPoidsMax(), that.getPoidsMax()) &&
                Objects.equals(getVolumeMax(), that.getVolumeMax()) &&
                Objects.equals(getClient(), that.getClient()) &&
                getNatureVehicule1().equals(that.getNatureVehicule1()) &&
                getNatureVehicule2().equals(that.getNatureVehicule2()) &&
                Objects.equals(getOthers(), that.getOthers()) &&
                Objects.equals(getConducteurs1(), that.getConducteurs1()) &&
                Objects.equals(getConducteurs2(), that.getConducteurs2()) &&
                Objects.equals(getConducteurs3(), that.getConducteurs3()) &&
                Objects.equals(getVehicule1(), that.getVehicule1()) &&
                Objects.equals(getVehicule2(), that.getVehicule2()) &&
                getConducteurs().equals(that.getConducteurs()) &&
                getVehicules().equals(that.getVehicules()) &&
                Objects.equals(getDepences(), that.getDepences()) &&
                getStations().equals(that.getStations()) &&
                getBeneficiaire().equals(that.getBeneficiaire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNdossier(), getOperationtype(), getRefChargement(), getDateCreation(), getLibelle(), getMotifClient(), getStatus(), getDotationEuro(), getDotationDH(), getDateUpadte(), getDateFin(), getDatedepart(), getDateLivraison(), getDateArrive(), getMontantOpe(), getDeviseOpe(), getMotifMontant(), getModeEmbarquement(), getExtensionGeo(), getTypeMarchandises(), getPoidsMax(), getVolumeMax(), getClient(), getNatureVehicule1(), getNatureVehicule2(), getOthers(), getConducteurs1(), getConducteurs2(), getConducteurs3(), getVehicule1(), getVehicule2(), getConducteurs(), getVehicules(), getDepences(), getStations(), getBeneficiaire());
    }
}
