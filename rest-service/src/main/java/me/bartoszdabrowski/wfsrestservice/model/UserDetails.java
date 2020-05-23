package me.bartoszdabrowski.wfsrestservice.model;

import javax.persistence.*;

@Entity(name = "user_details")
public class UserDetails{

    @Id
    @Column(name = "_email")
    private String email;

    @Column(name = "_firstName")
    private String firstName;

    @Column(name = "_lastName")
    private String lastName;

    @Column(name = "userType")
    private String userType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
