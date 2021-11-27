package com.golden.transport.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import com.golden.transport.enumeration.OperationStatus;
import com.golden.transport.enumeration.OperationType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.history.RevisionMetadata;

/**
 * A Operation.
 */
@Entity
@Audited
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

    @Column(name = "NATURE_VEHICULE1", length = 255)
    private String natureVehicule1;

    @Column(name = "NATURE_VEHICULE2", length = 255)
    private String natureVehicule2;

    @Column(name = "OTHERS", length = 255)
    private String others;

    @Column(name = "OPERATION_STATUS", length = 255)
    private OperationStatus status;

    @Column(name = "DOTATIONEURO", length = 255)
    private Float DotationEuro;

    @Column(name = "DOTATIONDH", length = 255)
    private Float DotationDH;

    @Column(name = "MONTANTOPE", length = 255)
    private Double montantOpe;

    @Column(name = "DEVISEOPE", length = 255)
    private String deviseOpe;

    @Column(name = "MOTIF_MONTANT", length = 255)
    private String motifMontant;

    @Column(name = "MODE_EMBARQUEMENT", length = 255)
    private String modeEmbarquement;

    @Column(name = "EXTENSION_GEO", length = 255)
    private String extensionGeo;


    @Column(name = "DATE_UPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateUpadte;

    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateFin;

    @Column(name = "DATE_DEPART")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Datedepart;

    @Column(name = "DATE_ARRIVE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateArrive;

    @Column(name = "DATE_LIVRAISON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLivraison;

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
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "BENEFICIAIRE_ID")
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Beneficiaire beneficiaire;

    @OneToMany(mappedBy = "operations", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @NotAudited
    private Set<OperationLineConducteurs> conducteurs = new HashSet<>();

    @OneToMany(mappedBy = "operations", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @NotAudited
    private Set<OperationLineVehicules> vehicules = new HashSet<>();

    @OneToOne
    @JoinColumn(name="TARGETID", referencedColumnName="id")
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected Target target;

    @OneToMany(targetEntity = Station.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "operations", orphanRemoval = true)
    @NotAudited
    private Set<Station> stations = new HashSet<>();

    @OneToMany(targetEntity = Depences.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "operations", orphanRemoval = true)
    @NotAudited
    private Set<Depences> depences = new HashSet<>();

   @OneToMany(targetEntity = Invoice.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "operations", orphanRemoval = true)
   @NotAudited
   private Set<Invoice> invoices = new HashSet<>();


    @Transient
    private RevisionMetadata<Long> editVersion;

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

    public String getNatureVehicule1() {
        return natureVehicule1;
    }

    public void setNatureVehicule1(String natureVehicule1) {
        this.natureVehicule1 = natureVehicule1;
    }

    public String getNatureVehicule2() {
        return natureVehicule2;
    }

    public void setNatureVehicule2(String natureVehicule2) {
        this.natureVehicule2 = natureVehicule2;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public Double getMontantOpe() {
        return montantOpe;
    }

    public void setMontantOpe(Double montantOpe) {
        this.montantOpe = montantOpe;
    }

    public String getDeviseOpe() {
        return deviseOpe;
    }

    public void setDeviseOpe(String deviseOpe) {
        this.deviseOpe = deviseOpe;
    }

    public String getMotifMontant() {
        return motifMontant;
    }

    public void setMotifMontant(String motifMontant) {
        this.motifMontant = motifMontant;
    }

    public String getModeEmbarquement() {
        return modeEmbarquement;
    }

    public void setModeEmbarquement(String modeEmbarquement) {
        this.modeEmbarquement = modeEmbarquement;
    }

    public String getExtensionGeo() {
        return extensionGeo;
    }

    public void setExtensionGeo(String extensionGeo) {
        this.extensionGeo = extensionGeo;
    }

    public Date getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(Date dateArrive) {
        this.dateArrive = dateArrive;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    /**
     * @return the editVersion
     */
    public RevisionMetadata<Long> getEditVersion() {
        return editVersion;
    }
    /**
     * @param editVersion the editVersion to set
     */
    public void setEditVersion(RevisionMetadata<Long> editVersion) {
        this.editVersion = editVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operation)) return false;
        Operation operation = (Operation) o;
        return Objects.equals(getId(), operation.getId()) &&
                Objects.equals(getCode(), operation.getCode()) &&
                Objects.equals(getNdossier(), operation.getNdossier()) &&
                getOperationtype() == operation.getOperationtype() &&
                Objects.equals(getRefChargement(), operation.getRefChargement()) &&
                Objects.equals(getDateCreation(), operation.getDateCreation()) &&
                Objects.equals(getLibelle(), operation.getLibelle()) &&
                Objects.equals(getMotifClient(), operation.getMotifClient()) &&
                Objects.equals(getNatureVehicule1(), operation.getNatureVehicule1()) &&
                Objects.equals(getNatureVehicule2(), operation.getNatureVehicule2()) &&
                Objects.equals(getOthers(), operation.getOthers()) &&
                getStatus() == operation.getStatus() &&
                Objects.equals(getDotationEuro(), operation.getDotationEuro()) &&
                Objects.equals(getDotationDH(), operation.getDotationDH()) &&
                Objects.equals(getMontantOpe(), operation.getMontantOpe()) &&
                Objects.equals(getDeviseOpe(), operation.getDeviseOpe()) &&
                Objects.equals(getMotifMontant(), operation.getMotifMontant()) &&
                Objects.equals(getModeEmbarquement(), operation.getModeEmbarquement()) &&
                Objects.equals(getExtensionGeo(), operation.getExtensionGeo()) &&
                Objects.equals(getDateUpadte(), operation.getDateUpadte()) &&
                Objects.equals(getDateFin(), operation.getDateFin()) &&
                Objects.equals(getDatedepart(), operation.getDatedepart()) &&
                Objects.equals(getDateArrive(), operation.getDateArrive()) &&
                Objects.equals(getDateLivraison(), operation.getDateLivraison()) &&
                Objects.equals(getTypeMarchandises(), operation.getTypeMarchandises()) &&
                Objects.equals(getPoidsMax(), operation.getPoidsMax()) &&
                Objects.equals(getVolumeMax(), operation.getVolumeMax()) &&
                Objects.equals(getFacturer(), operation.getFacturer()) &&
                Objects.equals(getClient(), operation.getClient()) &&
                Objects.equals(getBeneficiaire(), operation.getBeneficiaire()) &&
                Objects.equals(getConducteurs(), operation.getConducteurs()) &&
                Objects.equals(getVehicules(), operation.getVehicules()) &&
                Objects.equals(getTarget(), operation.getTarget()) &&
                Objects.equals(getStations(), operation.getStations()) &&
                Objects.equals(getDepences(), operation.getDepences()) &&
                Objects.equals(getInvoices(), operation.getInvoices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getNdossier(), getOperationtype(), getRefChargement(), getDateCreation(), getLibelle(), getMotifClient(), getNatureVehicule1(), getNatureVehicule2(), getOthers(), getStatus(), getDotationEuro(), getDotationDH(), getMontantOpe(), getDeviseOpe(), getMotifMontant(), getModeEmbarquement(), getExtensionGeo(), getDateUpadte(), getDateFin(), getDatedepart(), getDateArrive(), getDateLivraison(), getTypeMarchandises(), getPoidsMax(), getVolumeMax(), getFacturer(), getClient(), getBeneficiaire(), getConducteurs(), getVehicules(), getTarget(), getStations(), getDepences(), getInvoices());
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", ndossier='" + ndossier + '\'' +
                ", Operationtype=" + Operationtype +
                ", refChargement='" + refChargement + '\'' +
                ", dateCreation=" + dateCreation +
                ", Libelle='" + Libelle + '\'' +
                ", motifClient='" + motifClient + '\'' +
                ", natureVehicule1='" + natureVehicule1 + '\'' +
                ", natureVehicule2='" + natureVehicule2 + '\'' +
                ", others='" + others + '\'' +
                ", status=" + status +
                ", DotationEuro=" + DotationEuro +
                ", DotationDH=" + DotationDH +
                ", montantOpe=" + montantOpe +
                ", deviseOpe='" + deviseOpe + '\'' +
                ", motifMontant='" + motifMontant + '\'' +
                ", modeEmbarquement='" + modeEmbarquement + '\'' +
                ", extensionGeo='" + extensionGeo + '\'' +
                ", DateUpadte=" + DateUpadte +
                ", DateFin=" + DateFin +
                ", Datedepart=" + Datedepart +
                ", dateArrive=" + dateArrive +
                ", dateLivraison=" + dateLivraison +
                ", TypeMarchandises='" + TypeMarchandises + '\'' +
                ", PoidsMax=" + PoidsMax +
                ", VolumeMax=" + VolumeMax +
                ", facturer=" + facturer +
                ", client=" + client +
                ", beneficiaire=" + beneficiaire +
                ", conducteurs=" + conducteurs +
                ", vehicules=" + vehicules +
                ", target=" + target +
                ", stations=" + stations +
                ", depences=" + depences +
                ", invoices=" + invoices +
                '}';
    }
}
