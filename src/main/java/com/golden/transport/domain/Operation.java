package com.golden.transport.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @OneToOne
    @JoinColumn(unique = true)
    private Traget traget;

    @OneToOne
    @JoinColumn(unique = true)
    private Societe societe;

    @OneToOne
    @JoinColumn(unique = true)
    private Beneficiaire beneficiaire;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Traget getTraget() {
        return traget;
    }

    public Operation traget(Traget traget) {
        this.traget = traget;
        return this;
    }

    public void setTraget(Traget traget) {
        this.traget = traget;
    }

    public Societe getSociete() {
        return societe;
    }

    public Operation societe(Societe societe) {
        this.societe = societe;
        return this;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public Operation beneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
        return this;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
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
