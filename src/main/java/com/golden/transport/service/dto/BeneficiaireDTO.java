package com.golden.transport.service.dto;

import com.golden.transport.domain.Address;
import com.golden.transport.enumeration.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class BeneficiaireDTO implements Serializable {
    
    private Long id;
    private String gerant;
    private CustomerType customerType;
    private Date dateCreation;
    private Date dateCreationEntite;
    private String name;
    private String rc;
    private String patente;
    private String cnss;
    private String tp;
    private String ICE;
    private ABERIVAITION abr;
    private String ref;
    private String webSite;
    private String jobTitle;
    private String email;
    private String phoneNumber;
    private BeneficiaireStatus status;
    private Industry industry;
    private Float turnover;
    private ScoreEnum score;
    private String telephone;
    private String fax;
    private Boolean permited;
    private String codeNAF;
    private Integer employees;
    private String twitter;
    private String facebook;
    private String linkedin;
    private String businessSector;
    private Address address;
    private Set<InvoicesDTO> invoices = new HashSet<>();


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<InvoicesDTO> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<InvoicesDTO> invoices) {
        this.invoices = invoices;
    }
}
