package com.golden.transport.domain;

import com.golden.transport.enumeration.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * A Beneficiaire.
 */
@Entity
@Table(name = "Beneficiaire")
public class Beneficiaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "GERANT", length = 255)
    private String gerant;

    @Column(name = "TYPE",length = 255)
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CREATION", updatable = false)
    private Date dateCreation;

    @Column(name = "DATE_CREATION_ENTITE", updatable = false)
    private Date dateCreationEntite;

    @Column(name = "NAME", length = 255)
    private String name;

    @Column(name = "RC", length = 255)
    private String rc;

    @Column(name = "PATENTE", length = 255)
    private String patente;

    @Column(name = "CNSS", length = 255)
    private String cnss;

    @Column(name = "I_FISCALE", length = 255)
    private String tp;

    @Column(name = "ICE", length = 255)
    private String ICE;

    @Column(name = "ABREVIATION")
    private ABERIVAITION abr;

    @Column(name = "MORE_REF", length = 255)
    private String ref;

    @Column(name = "WEB_SITE", length = 255)
    private String webSite;

    @Column(name = "JOB_TITLE", length = 255)
    private String jobTitle;

    @Column(name = "ENTITE_EMAIL", length = 255)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 255)
    private String phoneNumber;

    @Column(name = "STATUS", length = 255)
    private BeneficiaireStatus status;

    @Column(name = "INDUSTRY")
    @Enumerated(EnumType.STRING)
    private Industry industry;

    @Column(name = "TURNOVER", length = 255)
    private Float turnover;

    @Column(name = "SCORE_ENUM")
    @Enumerated(EnumType.STRING)
    private ScoreEnum score;

    @Column(name = "TELEPHONE", length = 255)
    private String telephone;

    @Column(name = "FAX", length = 255)
    private String fax;

    @Column(name = "PERMITED", length = 255)
    private Boolean permited;

    @Column(name = "ACCEPTTERMS", length = 255)
    private Boolean acceptTerms;

    @Column(name = "NAF", length = 255)
    private String codeNAF;

    @Column(name = "EMPLOYEES", length = 255)
    private Integer employees;

    @Column(name = "TWITTER", length = 255)
    private String twitter;

    @Column(name = "FACEBOOK", length = 255)
    private String facebook;

    @Column(name = "LINKEDIN", length = 255)
    private String linkedin;

    @Column(name = "BUSINESS_SECTOR", length = 255)
    private String businessSector;

    @Embedded
    private Address address;

    @OneToMany(targetEntity = Operation.class , mappedBy="beneficiaire", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected Set<Operation> operations = new HashSet<>();

    @OneToMany(mappedBy = "beneficiaire", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Conducteur> conducteurs = new HashSet<>();

    @OneToMany(mappedBy = "beneficiaires", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Vehicule> vehicules = new HashSet<>();

    @OneToMany(mappedBy = "beneficiaire", targetEntity = Invoice.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Invoice> invoices = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getGerant() {
        return gerant;
    }

    public void setGerant(String gerant) {
        this.gerant = gerant;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateCreationEntite() {
        return dateCreationEntite;
    }

    public void setDateCreationEntite(Date dateCreationEntite) {
        this.dateCreationEntite = dateCreationEntite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getCnss() {
        return cnss;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getICE() {
        return ICE;
    }

    public void setICE(String ICE) {
        this.ICE = ICE;
    }

    public ABERIVAITION getAbr() {
        return abr;
    }

    public void setAbr(ABERIVAITION abr) {
        this.abr = abr;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BeneficiaireStatus getStatus() {
        return status;
    }

    public void setStatus(BeneficiaireStatus status) {
        this.status = status;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public Float getTurnover() {
        return turnover;
    }

    public void setTurnover(Float turnover) {
        this.turnover = turnover;
    }

    public ScoreEnum getScore() {
        return score;
    }

    public void setScore(ScoreEnum score) {
        this.score = score;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Boolean getPermited() {
        return permited;
    }

    public void setPermited(Boolean permited) {
        this.permited = permited;
    }

    public String getCodeNAF() {
        return codeNAF;
    }

    public void setCodeNAF(String codeNAF) {
        this.codeNAF = codeNAF;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getBusinessSector() {
        return businessSector;
    }

    public void setBusinessSector(String businessSector) {
        this.businessSector = businessSector;
    }

    public Set<Conducteur> getConducteurs() {
        return conducteurs;
    }

    public void setConducteurs(Set<Conducteur> conducteurs) {
        this.conducteurs = conducteurs;
    }

    public Set<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(Set<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getAcceptTerms() {
        return acceptTerms;
    }

    public void setAcceptTerms(Boolean acceptTerms) {
        this.acceptTerms = acceptTerms;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
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
