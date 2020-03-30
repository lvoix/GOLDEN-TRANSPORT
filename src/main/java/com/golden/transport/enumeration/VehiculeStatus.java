package com.golden.transport.enumeration;


public enum VehiculeStatus {

    ENABLE("enable"), DISABLE("disable");
    private final String type;

    VehiculeStatus(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
