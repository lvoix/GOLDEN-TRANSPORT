package com.golden.transport.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Operation Line Vehicules.
 */
@Entity
@Table(name = "OperationLineVehicules")
public class OperationLineVehicules implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERORDER")
    private Long numerOrder ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OPERATION_ID")
    private Operation operations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VEHICULE_ID")
    private Vehicule vehicules;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumerOrder() {
        return numerOrder;
    }

    public void setNumerOrder(Long numerOrder) {
        this.numerOrder = numerOrder;
    }

    public Operation getOperations() {
        return operations;
    }

    public void setOperations(Operation operations) {
        this.operations = operations;
    }

    public Vehicule getVehicules() {
        return vehicules;
    }

    public void setVehicules(Vehicule vehicules) {
        this.vehicules = vehicules;
    }
}
