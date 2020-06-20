package com.golden.transport.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Address implements Serializable {


    @Column(name = "CITY", length = 255)
    private String city;
    @Column(name = "AREA", length = 255)
    private String area;
    @Column(name = "COUNTRY", length = 255)
    private String country;
    @Column(name = "ZIPCODE", length = 255)
    private String zipCode;
    @Column(name = "STREET1", length = 255)
    private String street1;
    @Column(name = "STREET2", length = 255)
    private String street2;

    @Column(name = "NOMCLIENT", length = 255)
    private String nomClient;

    @Column(name = "TYPESTATION", length = 255)
    private String typeStation;

    @Column(name = "ORDERE")
    private Integer ordere;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getTypeStation() {
        return typeStation;
    }

    public void setTypeStation(String typeStation) {
        this.typeStation = typeStation;
    }

    public Integer getOrdere() {
        return ordere;
    }

    public void setOrdere(Integer ordere) {
        this.ordere = ordere;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                '}';
    }
}
