package com.golden.transport.enumeration;


public enum TypeDocument {

    START("START"), CIN("CIN"), PASSEPORT("PASSEPORT"), PERMIS("PERMIS");
    private final String type;

    TypeDocument(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
