package me.bdabrowski.wfs.service.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * User model class based on Restful service documentation
 */
public class User implements Serializable {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String userType;

    private Company company;

    private Address address;

    public User(){

    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isUserEmployed(){
        if(company == null){
            return false;
        }
        return true;
    }
    public boolean isUserAddressSetUp(){
        return this.address.isAddressIncomplete();
    }
}
