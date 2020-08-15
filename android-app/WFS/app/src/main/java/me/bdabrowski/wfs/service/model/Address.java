package me.bdabrowski.wfs.service.model;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Model class used representing Address Entity returned from REST service in form of JSON
 * Address has relation OneToOne with Model class User
 */
public class Address {
    private String street;
    private String state;
    private String country;
    private String zipCode;
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isAddressIncomplete(){
        return Stream.of(street, city, zipCode, city).allMatch(Objects::isNull);
    }
}
