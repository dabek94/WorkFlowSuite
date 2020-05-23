package me.bartoszdabrowski.wfsrestservice.model;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;

@Entity(name= "user_core")
public class User {

    @Id
    @Basic(optional = false)
    @Column(name = "_email",unique=true, nullable = false)
    private String email;

    @JoinColumn(name = "_email", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private UserDetails userDetails;

    @JoinColumn(name = "_email", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private UserContact userContact;

    @JoinColumn(name = "_email", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private UserAuthentication userAuthentication;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public UserContact getUserContact() {
        return userContact;
    }

    public void setUserContact(UserContact userContact) {
        this.userContact = userContact;
    }

    public UserAuthentication getUserAuthentication() {
        return userAuthentication;
    }

    public void setUserAuthentication(UserAuthentication userAuthentication) {
        this.userAuthentication = userAuthentication;
    }
}
