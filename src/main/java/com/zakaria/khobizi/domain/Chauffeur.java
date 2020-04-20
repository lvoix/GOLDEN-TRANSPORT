package com.zakaria.khobizi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Chauffeur.
 */
@Entity
@Table(name = "chauffeur")
public class Chauffeur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("chauffeurs")
    private Societe societes;

    @ManyToOne
    @JsonIgnoreProperties("chauffeurs")
    private Vehicule vehicules;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Societe getSocietes() {
        return societes;
    }

    public Chauffeur societes(Societe societe) {
        this.societes = societe;
        return this;
    }

    public void setSocietes(Societe societe) {
        this.societes = societe;
    }

    public Vehicule getVehicules() {
        return vehicules;
    }

    public Chauffeur vehicules(Vehicule vehicule) {
        this.vehicules = vehicule;
        return this;
    }

    public void setVehicules(Vehicule vehicule) {
        this.vehicules = vehicule;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Chauffeur)) {
            return false;
        }
        return id != null && id.equals(((Chauffeur) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Chauffeur{" +
            "id=" + getId() +
            "}";
    }
}
