package com.golden.transport.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Operation Line Conducteurs.
 */
@Entity
@Table(name = "OperationLineConducteurs")
public class OperationLineConducteurs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OPERATION_ID")
    private Operation operations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONDUCTEUR_ID")
    private Conducteur conducteurs;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Operation getOperations() {
        return operations;
    }

    public void setOperations(Operation operations) {
        this.operations = operations;
    }

    public Conducteur getConducteurs() {
        return conducteurs;
    }

    public void setConducteurs(Conducteur conducteurs) {
        this.conducteurs = conducteurs;
    }
}
