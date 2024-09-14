package com.example.officeemployee.model;

import javax.persistence.*;

@Embeddable
public class Address {
    private String street;
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Address() {}

    public Address(String street, String zipCode, City city) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
