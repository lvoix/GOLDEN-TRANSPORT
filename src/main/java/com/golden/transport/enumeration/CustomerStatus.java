package com.golden.transport.enumeration;

/**
 * Created by Master@3I on 15/12/2016.
 */
public enum CustomerStatus {

    ENABLE("enable"), DISABLE("disable");
    private final String type;

    CustomerStatus(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
