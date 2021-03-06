<<<<<<< HEAD:src/main/java/com/zakaria/khobizi/service/dto/BeneficiaireDTO.java
package com.zakaria.khobizi.service.dto;
=======
package com.golden.transport.service.dto;

import com.golden.transport.domain.Beneficiaire;
import com.golden.transport.enumeration.*;
>>>>>>> lvoix-2020:src/main/java/com/golden/transport/service/dto/BeneficiaireDTO.java

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.zakaria.khobizi.domain.Beneficiaire} entity.
 */
public class BeneficiaireDTO implements Serializable {
    
    private Long id;
<<<<<<< HEAD:src/main/java/com/zakaria/khobizi/service/dto/BeneficiaireDTO.java
=======
    private String name;

    private CustomerType customerType;

    private Date dateCreation;

    private String firstName;

    private String lastName;

    private String ref;

    private String webSite;

    private String jobTitle;

    private String email;

    private String phoneNumber;

    private CustomerStatus status;

    private BeneficiaireType type;

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

    private AddressDTO address;
>>>>>>> lvoix-2020:src/main/java/com/golden/transport/service/dto/BeneficiaireDTO.java

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD:src/main/java/com/zakaria/khobizi/service/dto/BeneficiaireDTO.java
=======
    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
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

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public BeneficiaireType getType() {
        return type;
    }

    public void setType(BeneficiaireType type) {
        this.type = type;
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

>>>>>>> lvoix-2020:src/main/java/com/golden/transport/service/dto/BeneficiaireDTO.java
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BeneficiaireDTO beneficiaireDTO = (BeneficiaireDTO) o;
        if (beneficiaireDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), beneficiaireDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BeneficiaireDTO{" +
            "id=" + getId() +
            "}";
    }
}
