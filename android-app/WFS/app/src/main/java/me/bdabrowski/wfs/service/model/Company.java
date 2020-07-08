package me.bdabrowski.wfs.service.model;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public class Company {

    private Long id;
    private Long ownerId;
    private String name;
    private List<JobOpening> jobOpenings;

    public Company() {

    }
    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JobOpening> getJobOpenings() {
        return jobOpenings;
    }

    public void setJobOpenings(List<JobOpening> jobOpenings) {
        this.jobOpenings = jobOpenings;
    }

}
