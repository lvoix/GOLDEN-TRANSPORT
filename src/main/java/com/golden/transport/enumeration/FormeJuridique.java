package com.golden.transport.enumeration;


public enum FormeJuridique {

    SARL("SARL"), SA("SA"), SAS("SAS");
    private final String type;

    FormeJuridique(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
