package com.golden.transport.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class operationGeneralDetailsDTO implements Serializable {

    private Long id;
    private String natureMarchandises;
    private String others;
    private String refchargement;
    private String deviseOpe;
    private String modeEmbarquement;
    private String extensionGeo;
    private Double montantOpe;


    private List<DepencesAddDTO> depencesAlls = new ArrayList<DepencesAddDTO>();
    private List<DepencesAddDTO> depencesAll = new ArrayList<DepencesAddDTO>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getNatureMarchandises() {
        return natureMarchandises;
    }

    public void setNatureMarchandises(String natureMarchandises) {
        this.natureMarchandises = natureMarchandises;
    }

    public String getRefchargement() {
        return refchargement;
    }

    public void setRefchargement(String refchargement) {
        this.refchargement = refchargement;
    }

    public String getDeviseOpe() {
        return deviseOpe;
    }

    public void setDeviseOpe(String deviseOpe) {
        this.deviseOpe = deviseOpe;
    }

    public String getModeEmbarquement() {
        return modeEmbarquement;
    }

    public void setModeEmbarquement(String modeEmbarquement) {
        this.modeEmbarquement = modeEmbarquement;
    }

    public String getExtensionGeo() {
        return extensionGeo;
    }

    public void setExtensionGeo(String extensionGeo) {
        this.extensionGeo = extensionGeo;
    }

    public Double getMontantOpe() {
        return montantOpe;
    }

    public void setMontantOpe(Double montantOpe) {
        this.montantOpe = montantOpe;
    }

    public List<DepencesAddDTO> getDepencesAlls() {
        return depencesAlls;
    }

    public void setDepencesAlls(List<DepencesAddDTO> depencesAlls) {
        this.depencesAlls = depencesAlls;
    }

    public List<DepencesAddDTO> getDepencesAll() {
        return depencesAll;
    }

    public void setDepencesAll(List<DepencesAddDTO> depencesAll) {
        this.depencesAll = depencesAll;
    }
}
