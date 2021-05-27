package com.golden.transport.domain;

import com.golden.transport.enumeration.ConducteurType;
import com.golden.transport.enumeration.CustomerStatus;
import com.golden.transport.enumeration.ScoreEnum;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Conducteur")
public class Conducteur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TYPE",length = 255)
    @Enumerated(EnumType.STRING)
    private ConducteurType conducteurType;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CREATION", updatable = false)
    private Date dateCreation;

    @Column(name = "NAME", length = 255)
    private String name;

    @Column(name = "FIRST_NAME", length = 255)
    private String firstName;

    @Column(name = "LAST_NAME", length = 255)
    private String lastName;

    @Column(name = "MORE_REF", length = 255)
    private String ref;

    @Column(name = "CNI", length = 255)
    private String cni;

    @Column(name = "CNSS", length = 255)
    private String cnss;

    @Column(name = "NPASSPORT", length = 255)
    private String npasseport;

    @Column(name = "JOB_TITLE", length = 255)
    private String jobTitle;

    @Column(name = "ACC_EMAIL", length = 255)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 255)
    private String phoneNumber;

    @Column(name = "STATUS", length = 255)
    private CustomerStatus status;

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

    @Column(name = "NAF", length = 255)
    private String codeNAF;

    @Column(name = "Enfants", length = 255)
    private Integer enfants;

    @Column(name = "EXPERIENCE", length = 255)
    private Integer experience;

    @Column(name = "SITUATION_F", length = 255)
    private String situation;

    @Column(name = "FACEBOOK", length = 255)
    private String facebook;

    @Column(name = "WHATSAPP", length = 255)
    private String linkedin;

    @Column(name = "BUSINESS_SECTOR", length = 255)
    private String businessSector;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "conducteurs", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OperationLineConducteurs> operations = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BENEFICIAIRE_ID")
    private Beneficiaire beneficiaire;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConducteurType getConducteurType() {
        return conducteurType;
    }

    public void setConducteurType(ConducteurType conducteurType) {
        this.conducteurType = conducteurType;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getCnss() {
        return cnss;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }

    public String getNpasseport() {
        return npasseport;
    }

    public void setNpasseport(String npasseport) {
        this.npasseport = npasseport;
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

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
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

    public Integer getEnfants() {
        return enfants;
    }

    public void setEnfants(Integer enfants) {
        this.enfants = enfants;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
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

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
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
