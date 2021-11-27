package com.golden.transport.service.dto;
import java.util.Date;


public class DepencesAddDTO  {
    
    private Long id;

    private Long depenceId ;

    private Date date;

    private String type;

    private String motif;

    private String lieu;

    private Double prix;

    private String devise;

    private Boolean etat;

    private OperationDTO_ID operations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepenceId() {
        return depenceId;
    }

    public void setDepenceId(Long depenceId) {
        this.depenceId = depenceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public OperationDTO_ID getOperations() {
        return operations;
    }

    public void setOperations(OperationDTO_ID operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "DepencesDTO{" +
                "id=" + id +
                ", depenceId=" + depenceId +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", motif='" + motif + '\'' +
                ", lieu='" + lieu + '\'' +
                ", prix=" + prix +
                ", devise='" + devise + '\'' +
                '}';
    }
}
