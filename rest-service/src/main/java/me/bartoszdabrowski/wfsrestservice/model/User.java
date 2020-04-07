package me.bartoszdabrowski.wfsrestservice.model;

import javax.persistence.*;

@Entity(name= "user_core")
public class User {

    @Id
    @Column(name = "_email")
    private String email;

    @Column(name = "_password")
    private String password;

    @Column(name = "_uuid")
    private String UUID;

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

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}
