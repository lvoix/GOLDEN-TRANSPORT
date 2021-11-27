package com.golden.transport.domain;

import com.golden.transport.enumeration.OperationStatus;
import com.golden.transport.enumeration.OperationType;
import com.golden.transport.util.IDHistorique;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Operation.
 */
@Entity
@Table(name = "operation_H")
public class Operation_H {

    private static final long serialVersionUID = 1L;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EmbeddedId
    private IDHistorique idop;

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

    @Column(name = "numHistorique")
    private int numHistorique;


    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Date_Historique", updatable = false)
    private Date DateHistorique;

    @Column(name = "TYPE",length = 255)
    @Enumerated(EnumType.STRING)
    private OperationType Operationtype;

    @Column(name = "Action_Historique", length = 255)
    private String actionHistorique;

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

  /*  @ManyToOne
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
*/

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IDHistorique getIdop() {
        return idop;
    }

    public void setIdop(IDHistorique idop) {
        this.idop = idop;
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

    public int getNumHistorique() {
        return numHistorique;
    }

    public void setNumHistorique(int numHistorique) {
        this.numHistorique = numHistorique;
    }

    public Date getDateHistorique() {
        return DateHistorique;
    }

    public void setDateHistorique(Date dateHistorique) {
        DateHistorique = dateHistorique;
    }

    public String getActionHistorique() {
        return actionHistorique;
    }

    public void setActionHistorique(String actionHistorique) {
        this.actionHistorique = actionHistorique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Operation_H)) {
            return false;
        }
        return id != null && id.equals(((Operation_H) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getNdossier(), getOperationtype(), getRefChargement(), getDateCreation(), getLibelle(), getMotifClient(), getStatus(), getDotationEuro(), getDotationDH(), getDateUpadte(), getDateFin(), getDatedepart(), getTypeMarchandises(), getPoidsMax(), getVolumeMax(), getFacturer());
    }

    @Override
    public String toString() {
        return "Operation_H{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", ndossier='" + ndossier + '\'' +
                ", Operationtype=" + Operationtype +
                ", refChargement='" + refChargement + '\'' +
                ", dateCreation=" + dateCreation +
                ", Libelle='" + Libelle + '\'' +
                ", motifClient='" + motifClient + '\'' +
                ", status=" + status +
                ", DotationEuro=" + DotationEuro +
                ", DotationDH=" + DotationDH +
                ", DateUpadte=" + DateUpadte +
                ", DateFin=" + DateFin +
                ", Datedepart=" + Datedepart +
                ", TypeMarchandises='" + TypeMarchandises + '\'' +
                ", PoidsMax=" + PoidsMax +
                ", VolumeMax=" + VolumeMax +
                ", facturer=" + facturer +
                '}';
    }
}
