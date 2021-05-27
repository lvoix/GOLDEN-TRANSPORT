package com.golden.transport.domain;

import com.golden.transport.enumeration.AccountStatus;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;


@Entity
@Table(name = "BIllACCOUNT")
public class BillingAccount implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "REF", length = 255, unique = true)
        private String ref;

        @Enumerated(EnumType.STRING)
        private AccountStatus status;

        @Column(name = "NAME", length = 255)
        private String name;

        private Boolean allowSubAccount = true;

        private Boolean invoiceIfChild;

        @Column(name = "LANGUAGE_BILL", length = 255)
        private String langage;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CURRENCY_ID")
        private Currency currency;

        @Column(name = "BALANCE")
        private BigDecimal balance;

        @ManyToOne
        @JoinColumn(name = "CLIENT_ID")
        private Client client;

        @OneToMany(targetEntity = Invoice.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "billingaccount", orphanRemoval = true)
        private Set<Invoice> invoices = new HashSet<>();

        @CreatedDate
        @Temporal(TemporalType.TIMESTAMP)
        @Column(updatable = false)
        private Date dateCreation;

/*
        @Transient
        private List<Invoice> currentInvoices = new ArrayList<>();
*/

        public BillingAccount() {
        }

        public BillingAccount(AccountStatus status) {
            this.status = status;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getAllowSubAccount() {
            return allowSubAccount;
        }

        public void setAllowSubAccount(Boolean allowSubAccount) {
            this.allowSubAccount = allowSubAccount;
        }

        public Boolean getInvoiceIfChild() {
            return invoiceIfChild;
        }

        public void setInvoiceIfChild(Boolean invoiceIfChild) {
            this.invoiceIfChild = invoiceIfChild;
        }

        public String getLangage() {
            return langage;
        }

        public void setLangage(String langage) {
            this.langage = langage;
        }

        public Currency getCurrency() {
            return currency;
        }

        public void setCurrency(Currency currency) {
            this.currency = currency;
        }


        public AccountStatus getStatus() {
            return status;
        }

        public void setStatus(AccountStatus status) {
            this.status = status;
        }

        public Date getDateCreation() {
            return dateCreation;
        }

        public void setDateCreation(Date dateCreation) {
            this.dateCreation = dateCreation;
        }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
        public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", ref='" + ref + '\'' +
                    ", status=" + status +
                    ", name='" + name + '\'' +
                    ", allowSubAccount=" + allowSubAccount +
                    ", invoiceIfChild=" + invoiceIfChild +
                    ", langage='" + langage + '\'' +
                    ", balance=" + balance +
                    ", dateCreation=" + dateCreation +
                    '}';
        }

        public BigDecimal getBalance() {
            return balance;
        }

        public void setBalance(BigDecimal balance) {
            this.balance = balance;
        }


/*    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }*/




}
