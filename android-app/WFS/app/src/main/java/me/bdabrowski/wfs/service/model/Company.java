package me.bdabrowski.wfs.service.model;

import java.util.List;
import java.util.UUID;

public class Company {

    private Long id;
    private Long ownerId;
    private String name;
    private List<JobOpenings> jobOpenings;

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


    public List<JobOpenings> getJobOpenings() {
        return jobOpenings;
    }

    public void setJobOpenings(List<JobOpenings> jobOpenings) {
        this.jobOpenings = jobOpenings;
    }

    public JobOpenings getFirst(){
        return this.jobOpenings.get(0);
    }

    public class JobOpenings{

        private String shortDescription;
        private String position;
        public JobOpenings(){}

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
}
