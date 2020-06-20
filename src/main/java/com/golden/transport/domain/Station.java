package com.golden.transport.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Station.
 */
@Entity
@Table(name = "station")
public class Station implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE", length = 255)
    private String code;

    @Column(name = "REF", length = 255)
    private String ref;

    @Column(name = "NAME", length = 255)
    private String name;

    @Column(name = "COORDX", length = 255)
    private String coordX;

    @Column(name = "COORDY", length = 255)
    private String coordY;

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

    @Column(name = "TYPE_STATION", length = 255)
    private String typeStation;

    @Column(name = "ORDERE")
    private Integer ordere;

    @ManyToOne
    @JoinColumn(name = "OPERATION_ID")
    private Operation operations ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }

    public Operation getOperations() {
        return operations;
    }

    public void setOperations(Operation operations) {
        this.operations = operations;
    }

    public String getTypeStation() {
        return typeStation;
    }

    public void setTypeStation(String typeStation) {
        this.typeStation = typeStation;
    }

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

    public Integer getOrdere() {
        return ordere;
    }

    public void setOrdere(Integer ordere) {
        this.ordere = ordere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Station)) {
            return false;
        }
        return id != null && id.equals(((Station) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Station{" +
            "id=" + getId() +
            "}";
    }
}
