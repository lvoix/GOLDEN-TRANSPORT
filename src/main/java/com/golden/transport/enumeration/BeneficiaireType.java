package com.golden.transport.enumeration;

/**
 * Created by Temri Mustapha on 05/12/2016.
 */
public enum BeneficiaireType {

    REVENDEUR("Revendeur"), INTEGRATOR("Integrator"), ANALYSTE("Analyste"), CLIENT("Client"), DISTRIBUTOR("Distributor"),
    PARTNER("Partner"), PROVIDER("Provider"), OTHERS("Others");
    private final String type;

    BeneficiaireType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
