package com.golden.transport.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.golden.transport.domain.Depences;
import com.golden.transport.domain.Station;
import com.golden.transport.domain.Vehicule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Target.
 */
@Entity
@Table(name = "target")
public class Target implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "stationDepart")
    private Station stationDepart;

    @OneToOne
    @JoinColumn(name = "stationDestination")
    private Station stationDestination;

    @OneToOne
    @JoinColumn(name = "depence")
    private Depences depence;

    @ManyToOne
    @JoinColumn(name ="Soustargets")
    private Target sousTargets;

    @OneToMany(mappedBy = "sousTargets")
    private Set<Target> targets = new HashSet<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Station getStationDepart() {
        return stationDepart;
    }

    public void setStationDepart(Station stationDepart) {
        this.stationDepart = stationDepart;
    }

    public Station getStationDestination() {
        return stationDestination;
    }

    public void setStationDestination(Station stationDestination) {
        this.stationDestination = stationDestination;
    }

    public Depences getDepence() {
        return depence;
    }

    public void setDepence(Depences depence) {
        this.depence = depence;
    }

    public Target getSousTargets() {
        return sousTargets;
    }

    public void setSousTargets(Target sousTargets) {
        this.sousTargets = sousTargets;
    }

    public Set<Target> getTargets() {
        return targets;
    }

    public void setTargets(Set<Target> targets) {
        this.targets = targets;
    }
}
