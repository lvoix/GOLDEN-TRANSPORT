package com.golden.transport.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "Contact")
@EntityListeners(AuditingEntityListener.class)
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "EMAIL_Contact", length = 255)
    private String email;
    @Column(name = "FIRST_NAME_Contact", length = 255)
    private String firstName;
    @Column(name = "LAST_NAME_Contact", length = 255)
    private String lastName;
    @Column(name = "JOB_TITLE_Contact", length = 255)
    private String jobTitle;

    @CreatedDate
    @Column(name = "DATE_CREATION_Contact",updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID_Contact")
    private Client client;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getId(), contact.getId()) &&
                Objects.equals(getEmail(), contact.getEmail()) &&
                Objects.equals(getFirstName(), contact.getFirstName()) &&
                Objects.equals(getLastName(), contact.getLastName()) &&
                Objects.equals(getJobTitle(), contact.getJobTitle()) &&
                Objects.equals(getDateCreation(), contact.getDateCreation()) &&
                Objects.equals(getClient(), contact.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getFirstName(), getLastName(), getJobTitle(), getDateCreation(), getClient());
    }
}
