package me.bartoszdabrowski.wfsrestservice.model;

import javax.persistence.*;

@Entity(name= "user_core")
public class User {

    @Id
    @Basic(optional = false)
    @Column(name = "_email",unique=true, nullable = false)
    private String email;

    @Column(name = "_password")
    private String password;

    @JoinColumn(name = "_email", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private UserDetails userDetails;

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

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
