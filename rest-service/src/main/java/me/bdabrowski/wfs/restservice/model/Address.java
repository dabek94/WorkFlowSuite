package me.bdabrowski.wfs.restservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents address information's for User and Company Entity
 */
@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String country;
    private String ZipCode;


    public Address() {
    }

    ;

    /*
            TEMPORARY CONSTROCTOR USED IN TEMPORARLDATA CLASS, WILL BE REMOVE IN PRODUCTIOn
     */
    public Address(String street, String city, String state, String country, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.ZipCode = zipCode;
    }
}
