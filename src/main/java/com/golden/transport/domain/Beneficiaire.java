package com.golden.transport.domain;

import com.golden.transport.domain.Operation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Beneficiaire.
 */
@Entity
@Table(name = "beneficiaire") 
public class Beneficiaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address address;

    @OneToMany(targetEntity = Operation.class , mappedBy="beneficiaire", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected Set<Operation> operations = new HashSet<>();

    @OneToMany(targetEntity = Contact.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "beneficiaire", orphanRemoval = true)
    private Set<Contact> contacts = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
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
        if (!(o instanceof Beneficiaire)) {
            return false;
        }
        return id != null && id.equals(((Beneficiaire) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Beneficiaire{" +
            "id=" + getId() +
            "}";
    }
}
