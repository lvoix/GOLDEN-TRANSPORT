package com.golden.transport.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.golden.transport.enumeration.VehiculeColor;
import com.golden.transport.enumeration.VehiculeGenre;
import com.golden.transport.enumeration.VehiculeStatus;
import com.golden.transport.enumeration.VehiculeType;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class VehiculeDTO implements Serializable {
    
    private Long id;

    private String matricule;

    private VehiculeType VehiculeType;

    private String ref;

    private String Nexterne;

    private Date dateCreation;

    private String Libelle;

    private String Model;

    private VehiculeStatus status;

    private VehiculeGenre Genre;

    private VehiculeColor VColor;

    private Float turnover;

    private Boolean permited;

    private Integer Nb_Chevalier;

    private Integer Capacite;

    private Float IndexKM;

    private Float KMN;

    private Float KMA;

    private Date ModifyDate;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date dateMiseCirculation;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date updateDateTime;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    private Date miseCirculation;

    private String email;

    private BeneficiaireDTO beneficiaires;

    private Set<OperLineVehDTO> lineoperations = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public VehiculeType getVehiculeType() {
        return VehiculeType;
    }

    public void setVehiculeType(VehiculeType vehiculeType) {
        VehiculeType = vehiculeType;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNexterne() {
        return Nexterne;
    }

    public void setNexterne(String nexterne) {
        Nexterne = nexterne;
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

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public VehiculeStatus getStatus() {
        return status;
    }

    public void setStatus(VehiculeStatus status) {
        this.status = status;
    }

    public VehiculeGenre getGenre() {
        return Genre;
    }

    public void setGenre(VehiculeGenre genre) {
        Genre = genre;
    }

    public VehiculeColor getVColor() {
        return VColor;
    }

    public void setVColor(VehiculeColor VColor) {
        this.VColor = VColor;
    }

    public Float getTurnover() {
        return turnover;
    }

    public void setTurnover(Float turnover) {
        this.turnover = turnover;
    }

    public Boolean getPermited() {
        return permited;
    }

    public void setPermited(Boolean permited) {
        this.permited = permited;
    }

    public Integer getNb_Chevalier() {
        return Nb_Chevalier;
    }

    public void setNb_Chevalier(Integer nb_Chevalier) {
        Nb_Chevalier = nb_Chevalier;
    }

    public Integer getCapacite() {
        return Capacite;
    }

    public void setCapacite(Integer capacite) {
        Capacite = capacite;
    }

    public Float getIndexKM() {
        return IndexKM;
    }

    public void setIndexKM(Float indexKM) {
        IndexKM = indexKM;
    }

    public Float getKMN() {
        return KMN;
    }

    public void setKMN(Float KMN) {
        this.KMN = KMN;
    }

    public Float getKMA() {
        return KMA;
    }

    public void setKMA(Float KMA) {
        this.KMA = KMA;
    }

    public Date getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        ModifyDate = modifyDate;
    }

    public Date getDateMiseCirculation() {
        return dateMiseCirculation;
    }

    public void setDateMiseCirculation(Date dateMiseCirculation) {
        dateMiseCirculation = dateMiseCirculation;
    }

    public Set<OperLineVehDTO> getLineoperations() {
        return lineoperations;
    }

    public void setLineoperations(Set<OperLineVehDTO> lineoperations) {
        this.lineoperations = lineoperations;
    }

    public BeneficiaireDTO getBeneficiaires() {
        return beneficiaires;
    }

    public void setBeneficiaires(BeneficiaireDTO beneficiaires) {
        this.beneficiaires = beneficiaires;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Date getMiseCirculation() {
        return miseCirculation;
    }

    public void setMiseCirculation(Date miseCirculation) {
        this.miseCirculation = miseCirculation;
    }
}
