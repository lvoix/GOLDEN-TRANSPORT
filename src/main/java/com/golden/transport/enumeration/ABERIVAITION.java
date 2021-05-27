package com.golden.transport.enumeration;


public enum ABERIVAITION {

    GW("GW"), TF("TF"), AB("AB"), SA("SA");
    private final String type;

    ABERIVAITION(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
