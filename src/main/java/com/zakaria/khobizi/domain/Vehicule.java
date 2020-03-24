package com.zakaria.khobizi.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Vehicule.
 */
@Entity
@Table(name = "vehicule")
public class Vehicule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "vehicules")
    private Set<Chauffeur> chauffeurs = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("vehicules")
    private Traget vehicules;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Chauffeur> getChauffeurs() {
        return chauffeurs;
    }

    public Vehicule chauffeurs(Set<Chauffeur> chauffeurs) {
        this.chauffeurs = chauffeurs;
        return this;
    }

    public Vehicule addChauffeur(Chauffeur chauffeur) {
        this.chauffeurs.add(chauffeur);
        chauffeur.setVehicules(this);
        return this;
    }

    public Vehicule removeChauffeur(Chauffeur chauffeur) {
        this.chauffeurs.remove(chauffeur);
        chauffeur.setVehicules(null);
        return this;
    }

    public void setChauffeurs(Set<Chauffeur> chauffeurs) {
        this.chauffeurs = chauffeurs;
    }

    public Traget getVehicules() {
        return vehicules;
    }

    public Vehicule vehicules(Traget traget) {
        this.vehicules = traget;
        return this;
    }

    public void setVehicules(Traget traget) {
        this.vehicules = traget;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vehicule)) {
            return false;
        }
        return id != null && id.equals(((Vehicule) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
            "id=" + getId() +
            "}";
    }
}
