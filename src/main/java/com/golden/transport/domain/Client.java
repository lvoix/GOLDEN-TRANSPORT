package com.golden.transport.domain;

import com.golden.transport.enumeration.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * A Client.
 */
@Entity
@Table(name = "Client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TYPE",length = 255)
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;

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

    @Column(name = "WEB_SITE", length = 255)
    private String webSite;

    @Column(name = "JOB_TITLE", length = 255)
    private String jobTitle;

    @Column(name = "BEN_EMAIL", length = 255)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 255)
    private String phoneNumber;

    @Column(name = "STATUS", length = 255)
    private CustomerStatus status;

    @Column(name = "CLIENT_TYPE")
    @Enumerated(EnumType.STRING)
    private ClientType type;

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

/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_PARENT_ID")
    Client parent;*/



    @ManyToOne
    @JoinColumn(name="users")
    private UsersG user;

    private Boolean active;

    @Embedded
    private Address address;

    @OneToMany(targetEntity = Operation.class , mappedBy="client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected Set<Operation> operations = new HashSet<>();

    @OneToMany(targetEntity = Contact.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "client", orphanRemoval = true)
    private Set<Contact> contacts = new HashSet<>();

   @OneToMany(targetEntity = BillingAccount.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "client", orphanRemoval = true)
    private Set<BillingAccount> billingaccount = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
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

/*    public Client getParent() {
        return parent;
    }

    public void setParent(Client parent) {
        this.parent = parent;
    }*/

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<BillingAccount> getBillingaccount() {
        return billingaccount;
    }

    public void setBillingaccount(Set<BillingAccount> billingaccount) {
        this.billingaccount = billingaccount;
    }


    public UsersG getUser() {
        return user;
    }

    public void setUser(UsersG user) {
        this.user = user;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }
        return id != null && id.equals(((Client) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Client{" +
            "id=" + getId() +
            "}";
    }
}
