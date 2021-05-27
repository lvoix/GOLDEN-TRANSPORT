package com.golden.transport.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import com.golden.transport.enumeration.OperationStatus;
import com.golden.transport.enumeration.OperationType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

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

    @GenericGenerator(name = "operation_id", strategy = "com.golden.transport.util.ClientIdGenerator")
    @GeneratedValue(generator = "operation_id")
    @Column(name="code")
    private String code;

 /*   @GenericGenerator(name = "operation_dossier", strategy = "com.golden.transport.util.OperationCodeGenerator")
    @GeneratedValue(generator = "operation_dossier")*/
    @Column(name = "ndossier")
     private String ndossier;

/*    @Version
    @Column(name = "version")
    private int version;*/

    @Column(name = "TYPE",length = 255)
    @Enumerated(EnumType.STRING)
    private OperationType Operationtype;

    @Column(name = "OPERATION_REF", length = 255)
    private String refChargement;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CREATION", updatable = false)
    private Date dateCreation;

    @Column(name = "LIBELLE", length = 255)
    private String Libelle;

    @Column(name = "MOTIF", length = 255)
    private String motifClient;

    @Column(name = "OPERATION_STATUS", length = 255)
    private OperationStatus status;

    @Column(name = "DOTATIONEURO", length = 255)
    private Float DotationEuro;

    @Column(name = "DOTATIONDH", length = 255)
    private Float DotationDH;

    @Column(name = "DATE_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date DateUpadte;

    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date DateFin;

    @Column(name = "DATE_DEPART")
    @Temporal(TemporalType.DATE)
    private Date Datedepart;

    @Column(name = "TYPE_MARCHANDISES", length = 255)
    private String TypeMarchandises;

    @Column(name = "POIDSMAX", length = 255)
    private Integer PoidsMax;

    @Column(name = "VOLUMEMAX", length = 255)
    private Integer VolumeMax;

    @Column(name = "FACTURER", length = 255)
    private Boolean facturer;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "BENEFICIAIRE_ID")
    private Beneficiaire beneficiaire;

    @OneToMany(mappedBy = "operations", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OperationLineConducteurs> conducteurs = new HashSet<>();

    @OneToMany(mappedBy = "operations", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OperationLineVehicules> vehicules = new HashSet<>();

    @OneToOne
    @JoinColumn(name="TARGETID", referencedColumnName="id")
    protected Target target;

    @OneToMany(targetEntity = Station.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "operations", orphanRemoval = true)
    private Set<Station> stations = new HashSet<>();

    @OneToMany(targetEntity = Depences.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "operations", orphanRemoval = true)
    private Set<Depences> depences = new HashSet<>();

   @OneToMany(targetEntity = Invoice.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "operations", orphanRemoval = true)
    private Set<Invoice> invoices = new HashSet<>();


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OperationType getOperationtype() {
        return Operationtype;
    }

    public void setOperationtype(OperationType operationtype) {
        Operationtype = operationtype;
    }

    public String getRefChargement() {
        return refChargement;
    }

    public void setRefChargement(String refChargement) {
        this.refChargement = refChargement;
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

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    public Float getDotationEuro() {
        return DotationEuro;
    }

    public void setDotationEuro(Float dotationEuro) {
        DotationEuro = dotationEuro;
    }

    public Float getDotationDH() {
        return DotationDH;
    }

    public void setDotationDH(Float dotationDH) {
        DotationDH = dotationDH;
    }

    public Date getDateUpadte() {
        return DateUpadte;
    }

    public void setDateUpadte(Date dateUpadte) {
        DateUpadte = dateUpadte;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateFin(Date dateFin) {
        DateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public String getTypeMarchandises() {
        return TypeMarchandises;
    }

    public void setTypeMarchandises(String typeMarchandises) {
        TypeMarchandises = typeMarchandises;
    }

    public Integer getPoidsMax() {
        return PoidsMax;
    }

    public void setPoidsMax(Integer poidsMax) {
        PoidsMax = poidsMax;
    }

    public Integer getVolumeMax() {
        return VolumeMax;
    }

    public void setVolumeMax(Integer volumeMax) {
        VolumeMax = volumeMax;
    }

    public String getMotifClient() {
        return motifClient;
    }

    public void setMotifClient(String motifClient) {
        this.motifClient = motifClient;
    }

    public Date getDatedepart() {
        return Datedepart;
    }

    public void setDatedepart(Date datedepart) {
        Datedepart = datedepart;
    }

    public Set<Station> getStations() {
        return stations;
    }

    public void setStations(Set<Station> stations) {
        this.stations = stations;
    }

    public String getNdossier() {
        return ndossier;
    }

    public void setNdossier(String ndossier) {
        this.ndossier = ndossier;
    }

    public Boolean getFacturer() {
        return facturer;
    }

    public void setFacturer(Boolean facturer) {
        this.facturer = facturer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Depences> getDepences() {
        return depences;
    }

    public void setDepences(Set<Depences> depences) {
        this.depences = depences;
    }

   public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
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
