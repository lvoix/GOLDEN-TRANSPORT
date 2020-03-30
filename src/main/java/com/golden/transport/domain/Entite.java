package com.golden.transport.domain;

import com.golden.transport.domain.Beneficiaire;
import com.golden.transport.domain.Conducteur;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Societe.
 */
@Entity
@Table(name = "entite")
public class Entite implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "entite")
    private Set<Conducteur> conducteurs = new HashSet<>();

    @OneToMany(mappedBy = "entites")
    private Set<Vehicule> vehicules = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<Conducteur> getConducteurs() {
        return conducteurs;
    }

    public void setConducteurs(Set<Conducteur> conducteurs) {
        this.conducteurs = conducteurs;
    }

    public Set<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(Set<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Entite)) {
            return false;
        }
        return id != null && id.equals(((Entite) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Entite{" +
            "id=" + getId() +
            "}";
    }
}
