package me.bdabrowski.wfs.service.model;

public class WorkDescription {
    private Company company;
    private String position;

    public WorkDescription() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
