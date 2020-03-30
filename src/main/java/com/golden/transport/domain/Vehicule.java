package com.golden.transport.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.golden.transport.domain.Operation;
import com.golden.transport.enumeration.VehiculeColor;
import com.golden.transport.enumeration.VehiculeGenre;
import com.golden.transport.enumeration.VehiculeStatus;
import com.golden.transport.enumeration.VehiculeType;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * A Vehicule.
 */
@Entity
@Table(name = "vehicule")
public class Vehicule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MATRICULE", length = 255)
    private String matricule;

    @Column(name = "TYPE",length = 255)
    @Enumerated(EnumType.STRING)
    private VehiculeType VehiculeType;

    @Column(name = "VEHICULE_REF", length = 255)
    private String ref;

    @Column(name = "NEXTERNE", length = 255)
    private String Nexterne;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CREATION", updatable = false)
    private Date dateCreation;

    @Column(name = "LIBELLE", length = 255)
    private String Libelle;

    @Column(name = "MODEL", length = 255)
    private String Model;

    @Column(name = "STATUS", length = 255)
    private VehiculeStatus status;

    @Column(name = "GENRE", length = 255)
    private VehiculeGenre Genre;

    @Column(name = "VCOLOR")
    @Enumerated(EnumType.STRING)
    private VehiculeColor VColor;

    @Column(name = "NPARC", length = 255)
    private Integer NParc;

    @Column(name = "TURNOVER", length = 255)
    private Float turnover;

    @Column(name = "PERMITED", length = 255)
    private Boolean permited;

    @Column(name = "NBCHEVALIERS", length = 255)
    private Integer Nb_Chevalier;

    @Column(name = "IndexKM", length = 255)
    private Float IndexKM;

    @Column(name = "KMN", length = 255)
    private Float KMN;

    @Column(name = "KMA", length = 255)
    private Float KMA;

    @Column(name = "MODIFY_DATE")
    @Temporal(TemporalType.DATE)
    private Date ModifyDate;


    @OneToMany(mappedBy = "vehicules", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<OperationLineVehicules> operations = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "ENTITE_ID")
    private Entite entites;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public Entite getEntites() {
        return entites;
    }

    public void setEntites(Entite entites) {
        this.entites = entites;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public com.golden.transport.enumeration.VehiculeType getVehiculeType() {
        return VehiculeType;
    }

    public void setVehiculeType(com.golden.transport.enumeration.VehiculeType vehiculeType) {
        VehiculeType = vehiculeType;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNexterne() {
        return Nexterne;
    }

    public void setNexterne(String nexterne) {
        Nexterne = nexterne;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public VehiculeStatus getStatus() {
        return status;
    }

    public void setStatus(VehiculeStatus status) {
        this.status = status;
    }

    public VehiculeGenre getGenre() {
        return Genre;
    }

    public void setGenre(VehiculeGenre genre) {
        Genre = genre;
    }

    public VehiculeColor getVColor() {
        return VColor;
    }

    public void setVColor(VehiculeColor VColor) {
        this.VColor = VColor;
    }

    public Integer getNParc() {
        return NParc;
    }

    public void setNParc(Integer NParc) {
        this.NParc = NParc;
    }

    public Float getTurnover() {
        return turnover;
    }

    public void setTurnover(Float turnover) {
        this.turnover = turnover;
    }

    public Boolean getPermited() {
        return permited;
    }

    public void setPermited(Boolean permited) {
        this.permited = permited;
    }

    public Integer getNb_Chevalier() {
        return Nb_Chevalier;
    }

    public void setNb_Chevalier(Integer nb_Chevalier) {
        Nb_Chevalier = nb_Chevalier;
    }

    public Float getIndexKM() {
        return IndexKM;
    }

    public void setIndexKM(Float indexKM) {
        IndexKM = indexKM;
    }

    public Float getKMN() {
        return KMN;
    }

    public void setKMN(Float KMN) {
        this.KMN = KMN;
    }

    public Float getKMA() {
        return KMA;
    }

    public void setKMA(Float KMA) {
        this.KMA = KMA;
    }

    public Date getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        ModifyDate = modifyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vehicule)) {
            return false;
        }
        return id != null && id.equals(((Vehicule) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
            "id=" + getId() +
            "}";
    }
}
