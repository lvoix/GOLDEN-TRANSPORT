package com.golden.transport.enumeration;


public enum OperationType {

    DIRECT("Direct"),
    INTERMEDAIRE("Intermedaire"),
    LOCATION("Location"),
    TRACTION("Traction"),
    R1("R1"),
    R2("R2"),
    OTHERS("Others");

    private final String typeOpe;

    OperationType(String type) {
        this.typeOpe = type;
    }

    public String getTypeOpe() {
        return typeOpe;
    }
}
