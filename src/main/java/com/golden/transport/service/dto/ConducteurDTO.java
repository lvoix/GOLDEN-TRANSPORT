package com.golden.transport.service.dto;

import com.golden.transport.domain.Address;
import com.golden.transport.enumeration.ConducteurType;
import com.golden.transport.enumeration.CustomerStatus;
import com.golden.transport.enumeration.ScoreEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class ConducteurDTO implements Serializable {
    
    private Long id;
    private ConducteurType conducteurType;
    private Date dateCreation;
    private String name;
    private String firstName;
    private String lastName;
    private String ref;
    private String cni;
    private String cnss;
    private String npasseport;
    private String jobTitle;
    private String email;
    private String phoneNumber;
    private CustomerStatus status;
    private Float turnover;
    private ScoreEnum score;
    private String telephone;
    private String fax;
    private Boolean permited;
    private String codeNAF;
    private Integer enfants;
    private Integer experience;
    private String situation;
    private String facebook;
    private String linkedin;
    private String businessSector;
    private Address address;
    private BeneficiaireDTO beneficiaire;
    private Set<OperationLineDTO> operations = new HashSet<>();

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

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BeneficiaireDTO getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(BeneficiaireDTO beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Set<OperationLineDTO> getOperations() {
        return operations;
    }

    public void setOperations(Set<OperationLineDTO> operations) {
        this.operations = operations;
    }
}
