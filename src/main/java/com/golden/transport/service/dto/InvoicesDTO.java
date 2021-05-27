package com.golden.transport.service.dto;



import com.golden.transport.domain.*;
import com.golden.transport.enumeration.InvoiceStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class InvoicesDTO implements Serializable {

    private String id;

    private int version;

    private String title;

    private String label;

    private Boolean pending;

    private Boolean received;

    private Date receptionDate;

    private Boolean travelCosts;

    private LocalDate publishingDate;

    private String ref;

    private Date billingDate;

    private Date dueDate;

    private InvoiceStatus status;

    private Price carriedBalance;

    private Price amount;

    private Price restToPay;

    private Date dateCreation;

    private OperationDTO_ID operations;

    private BeneficiaireDTO_ID entite;

    private BillaccountDTO_ID billingaccount;

    private Set<InvoiceLine> invoiceLines = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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

    public OperationDTO_ID getOperations() {
        return operations;
    }

    public void setOperations(OperationDTO_ID operations) {
        this.operations = operations;
    }

    public BeneficiaireDTO_ID getEntite() {
        return entite;
    }

    public void setEntite(BeneficiaireDTO_ID entite) {
        this.entite = entite;
    }

    public BillaccountDTO_ID getBillingaccount() {
        return billingaccount;
    }

    public void setBillingaccount(BillaccountDTO_ID billingaccount) {
        this.billingaccount = billingaccount;
    }
}
