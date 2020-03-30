package com.golden.transport.domain;

import com.golden.transport.domain.Entite;
import com.golden.transport.domain.Vehicule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Conducteur")
public class Conducteur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "conducteurs", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OperationLineConducteurs> operations = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "ENTITE_ID")
    private Entite entite;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<OperationLineConducteurs> getOperations() {
        return operations;
    }

    public void setOperations(Set<OperationLineConducteurs> operations) {
        this.operations = operations;
    }

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Conducteur)) {
            return false;
        }
        return id != null && id.equals(((Conducteur) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Conducteur{" +
            "id=" + getId() +
            "}";
    }
}
