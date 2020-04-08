package me.bartoszdabrowski.wfsrestservice.model;

import javax.persistence.*;

@Entity(name = "user_details")
public class UserDetails{

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "isEmployer")
    private boolean isEmployer;

    @OneToOne(optional = false)
    @JoinColumn(name = "email", nullable = false)
    private User user;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isEmployer() {
        return isEmployer;
    }

    public void setEmployer(boolean employer) {
        isEmployer = employer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
