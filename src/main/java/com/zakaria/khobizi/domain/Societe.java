package com.zakaria.khobizi.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Societe.
 */
@Entity
@Table(name = "societe")
public class Societe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "societes")
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Chauffeur> chauffeurs = new HashSet<>();

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Chauffeur> getChauffeurs() {
        return chauffeurs;
    }

    public Societe chauffeurs(Set<Chauffeur> chauffeurs) {
        this.chauffeurs = chauffeurs;
        return this;
    }

    public Societe addChauffeur(Chauffeur chauffeur) {
        this.chauffeurs.add(chauffeur);
        chauffeur.setSocietes(this);
        return this;
    }

    public Societe removeChauffeur(Chauffeur chauffeur) {
        this.chauffeurs.remove(chauffeur);
        chauffeur.setSocietes(null);
        return this;
    }

    public void setChauffeurs(Set<Chauffeur> chauffeurs) {
        this.chauffeurs = chauffeurs;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Societe)) {
            return false;
        }
        return id != null && id.equals(((Societe) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Societe{" +
            "id=" + getId() +
            "}";
    }
}
