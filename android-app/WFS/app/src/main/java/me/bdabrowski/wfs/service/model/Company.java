package me.bdabrowski.wfs.service.model;

import java.util.UUID;

public class Company {

    private int id;
    private String name;

    public Company() {


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
