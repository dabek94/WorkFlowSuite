package me.bdabrowski.wfs.service.model;

public class JobOpening{

    private String shortDescription;
    private String position;
    public JobOpening(){}

    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
