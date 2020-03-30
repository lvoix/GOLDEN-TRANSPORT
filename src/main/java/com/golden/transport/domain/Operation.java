package com.golden.transport.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.golden.transport.domain.*;

/**
 * A Operation.
 */
@Entity
@Table(name = "operation")
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BENEFICIAIRE_ID")
    private Beneficiaire beneficiaire;

    @OneToMany(mappedBy = "conducteurs", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OperationLineConducteurs> conducteurs = new HashSet<>();


    @OneToMany(mappedBy = "vehicules", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OperationLineVehicules> vehicules = new HashSet<>();


    @OneToOne
    @JoinColumn(name="TARGETID", referencedColumnName="id")
    protected Target target;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Set<OperationLineConducteurs> getConducteurs() {
        return conducteurs;
    }

    public void setConducteurs(Set<OperationLineConducteurs> conducteurs) {
        this.conducteurs = conducteurs;
    }

    public Set<OperationLineVehicules> getVehicules() {
        return vehicules;
    }

    public void setVehicules(Set<OperationLineVehicules> vehicules) {
        this.vehicules = vehicules;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Operation)) {
            return false;
        }
        return id != null && id.equals(((Operation) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Operation{" +
            "id=" + getId() +
            "}";
    }
}
