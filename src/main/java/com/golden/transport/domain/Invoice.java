package com.golden.transport.domain;

import com.golden.transport.enumeration.InvoiceStatus;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "INVOICES")
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
*/
    @Id
    @GenericGenerator(name = "invoice_id", strategy = "com.golden.transport.util.ClientIdGenerator")
    @GeneratedValue(generator = "invoice_id")
    @Column(name="id")
    private String id;

    @Version
    @Column(name = "version")
    private int version;

    @Column
    private String title;

    @Column
    private String label;

    @Column
    private Boolean pending;

    @Column
    private Boolean received;

    @Column
    private Date receptionDate;

    @Column
    private Boolean travelCosts;

    @Column
    private Date publishingDate;

    @Column(name = "REF")
    private String ref;

    @Column(name = "BILLING_DATE")
    @Temporal(TemporalType.DATE)
    private Date billingDate;

    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PRICE_CARRIED_BALANCE")
    private Price carriedBalance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PRICE_AMOUNT")
    private Price amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PRICE_REST_TOPAY")
    private Price restToPay;

    @ManyToOne
    @JoinColumn(name = "OPERATION_ID")
    private Operation operations;

    @ManyToOne
    @JoinColumn(name = "BENEFICIAIRE_ID")
    private Beneficiaire beneficiaire;

    @ManyToOne
    @JoinColumn(name = "ID_BILL_ACCOUNT")
    private BillingAccount billingaccount;

    @CreatedDate
    @Column(updatable = false)
    private Date dateCreation;

    @OneToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<InvoiceLine> invoiceLines = new HashSet<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public Boolean getTravelCosts() {
        return travelCosts;
    }

    public void setTravelCosts(Boolean travelCosts) {
        this.travelCosts = travelCosts;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public Price getCarriedBalance() {
        return carriedBalance;
    }

    public void setCarriedBalance(Price carriedBalance) {
        this.carriedBalance = carriedBalance;
    }

    public Price getAmount() {
        return amount;
    }

    public void setAmount(Price amount) {
        this.amount = amount;
    }

    public Price getRestToPay() {
        return restToPay;
    }

    public void setRestToPay(Price restToPay) {
        this.restToPay = restToPay;
    }

    public Operation getOperations() {
        return operations;
    }

    public void setOperations(Operation operations) {
        this.operations = operations;
    }

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public BillingAccount getBillingaccount() {
        return billingaccount;
    }

    public void setBillingaccount(BillingAccount billingaccount) {
        this.billingaccount = billingaccount;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Set<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(Set<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }




    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", title='" + title + '\'' +
                ", label='" + label + '\'' +
                ", pending=" + pending +
                ", received=" + received +
                ", receptionDate=" + receptionDate +
                ", travelCosts=" + travelCosts +
                ", publishingDate=" + publishingDate +
                ", ref='" + ref + '\'' +
                ", billingDate=" + billingDate +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", carriedBalance=" + carriedBalance +
                ", amount=" + amount +
                ", restToPay=" + restToPay +
                ", operations=" + operations +
                 ", beneficiaire=" + beneficiaire +
               ", billingaccount=" + billingaccount +
                ", invoiceLines=" + invoiceLines +
                ", dateCreation=" + dateCreation +
                '}';
    }
}
