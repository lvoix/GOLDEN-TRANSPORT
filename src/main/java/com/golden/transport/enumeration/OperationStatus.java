package com.golden.transport.enumeration;


public enum OperationStatus {

    ENABLE("enable"), DISABLE("disable");
    private final String type;

    OperationStatus(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
