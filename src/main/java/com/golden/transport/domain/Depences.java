package com.golden.transport.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "depences")
public class Depences implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long depenceId ;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String type;

    private String motif;

    private String lieu;

    private Double prix;

    private String devise;

    private Boolean etat;


    @ManyToOne
    @JoinColumn(name = "OPERATION_ID")
    private Operation operations;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getDepenceId() {
        return depenceId;
    }

    public void setDepenceId(Long depenceId) {
        this.depenceId = depenceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public Operation getOperations() {
        return operations;
    }

    public void setOperations(Operation operations) {
        this.operations = operations;
    }


    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Depences)) {
            return false;
        }
        return id != null && id.equals(((Depences) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Depences{" +
                "id=" + id +
                ", DepenceId=" + depenceId +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", motif='" + motif + '\'' +
                ", lieu='" + lieu + '\'' +
                ", prix=" + prix +
                ", devise='" + devise + '\'' +
                ", operations=" + operations +
                '}';
    }
}
