package com.golden.transport.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class operationDirectionDTO  implements Serializable {

    private Long id;
    private List<StationDTO> adressesChargement = new ArrayList<StationDTO>();
    private List<StationDTO> adressesDechargement = new ArrayList<StationDTO>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<StationDTO> getAdressesChargement() {
        return adressesChargement;
    }

    public void setAdressesChargement(List<StationDTO> adressesChargement) {
        this.adressesChargement = adressesChargement;
    }

    public List<StationDTO> getAdressesDechargement() {
        return adressesDechargement;
    }

    public void setAdressesDechargement(List<StationDTO> adressesDechargement) {
        this.adressesDechargement = adressesDechargement;
    }
}
