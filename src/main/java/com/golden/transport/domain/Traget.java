package com.golden.transport.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Traget.
 */
@Entity
@Table(name = "traget")
public class Traget implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(unique = true)
    private Station stationDepart;

    @OneToOne
    @JoinColumn(unique = true)
    private Station stationDestination;

    @OneToOne
    @JoinColumn(unique = true)
    private Depences depence;

    @OneToMany(mappedBy = "sousTragets")
    private Set<Traget> tragets = new HashSet<>();

    @OneToMany(mappedBy = "vehicules")
    private Set<Vehicule> vehicules = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("tragets")
    private Traget sousTragets;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Station getStationDepart() {
        return stationDepart;
    }

    public Traget stationDepart(Station station) {
        this.stationDepart = station;
        return this;
    }

    public void setStationDepart(Station station) {
        this.stationDepart = station;
    }

    public Station getStationDestination() {
        return stationDestination;
    }

    public Traget stationDestination(Station station) {
        this.stationDestination = station;
        return this;
    }

    public void setStationDestination(Station station) {
        this.stationDestination = station;
    }

    public Depences getDepence() {
        return depence;
    }

    public Traget depence(Depences depences) {
        this.depence = depences;
        return this;
    }

    public void setDepence(Depences depences) {
        this.depence = depences;
    }

    public Set<Traget> getTragets() {
        return tragets;
    }

    public Traget tragets(Set<Traget> tragets) {
        this.tragets = tragets;
        return this;
    }

    public Traget addTraget(Traget traget) {
        this.tragets.add(traget);
        traget.setSousTragets(this);
        return this;
    }

    public Traget removeTraget(Traget traget) {
        this.tragets.remove(traget);
        traget.setSousTragets(null);
        return this;
    }

    public void setTragets(Set<Traget> tragets) {
        this.tragets = tragets;
    }

    public Set<Vehicule> getVehicules() {
        return vehicules;
    }

    public Traget vehicules(Set<Vehicule> vehicules) {
        this.vehicules = vehicules;
        return this;
    }

    public Traget addVehicule(Vehicule vehicule) {
        this.vehicules.add(vehicule);
        vehicule.setVehicules(this);
        return this;
    }

    public Traget removeVehicule(Vehicule vehicule) {
        this.vehicules.remove(vehicule);
        vehicule.setVehicules(null);
        return this;
    }

    public void setVehicules(Set<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public Traget getSousTragets() {
        return sousTragets;
    }

    public Traget sousTragets(Traget traget) {
        this.sousTragets = traget;
        return this;
    }

    public void setSousTragets(Traget traget) {
        this.sousTragets = traget;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Traget)) {
            return false;
        }
        return id != null && id.equals(((Traget) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Traget{" +
            "id=" + getId() +
            "}";
    }
}
