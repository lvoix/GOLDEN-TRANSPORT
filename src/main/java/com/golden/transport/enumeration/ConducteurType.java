package com.golden.transport.enumeration;

/**
 * Created by BARGUACH on 23/03/2020.
 */
public enum ConducteurType {

    INTGRER("Integrer"),
    RAPID("Rapid"),
    ANALYSTE("Analyste"),
    DISTRIBUTOR("Distributor"),
    PROVIDER("Provider"),
    OTHERS("Others");
    private final String type;

    ConducteurType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
