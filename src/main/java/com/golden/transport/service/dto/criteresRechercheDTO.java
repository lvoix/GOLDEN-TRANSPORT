package com.golden.transport.service.dto;


import java.io.Serializable;
import java.util.Date;


public class criteresRechercheDTO implements Serializable {
    
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private Boolean bolDF;
    private Boolean bolDC;
    private Integer cBeneficiaire;
    private Integer cClient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Boolean getBolDF() {
        return bolDF;
    }

    public void setBolDF(Boolean bolDF) {
        this.bolDF = bolDF;
    }

    public Boolean getBolDC() {
        return bolDC;
    }

    public void setBolDC(Boolean bolDC) {
        this.bolDC = bolDC;
    }

    public Integer getcBeneficiaire() {
        return cBeneficiaire;
    }

    public void setcBeneficiaire(Integer cBeneficiaire) {
        this.cBeneficiaire = cBeneficiaire;
    }

    public Integer getcClient() {
        return cClient;
    }

    public void setcClient(Integer cClient) {
        this.cClient = cClient;
    }

    @Override
    public String toString() {
        return "criteresRechercheDTO{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", bolDF=" + bolDF +
                ", bolDC=" + bolDC +
                ", cBeneficiaire=" + cBeneficiaire +
                ", cClient=" + cClient +
                '}';
    }
}
