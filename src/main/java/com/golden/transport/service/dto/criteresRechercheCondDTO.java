package com.golden.transport.service.dto;


import java.io.Serializable;


public class criteresRechercheCondDTO implements Serializable {

    private Long id;
    private String codeConducteur;
    private String cin;
    private String npasseport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeConducteur() {
        return codeConducteur;
    }

    public void setCodeConducteur(String codeConducteur) {
        this.codeConducteur = codeConducteur;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNpasseport() {
        return npasseport;
    }

    public void setNpasseport(String npasseport) {
        this.npasseport = npasseport;
    }

    @Override
    public String toString() {
        return "criteresRechercheCondDTO{" +
                "id=" + id +
                ", codeConducteur='" + codeConducteur + '\'' +
                ", cin='" + cin + '\'' +
                ", npasseport='" + npasseport + '\'' +
                '}';
    }
}
