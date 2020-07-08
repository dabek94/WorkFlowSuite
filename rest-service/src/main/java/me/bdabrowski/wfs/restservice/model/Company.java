package me.bdabrowski.wfs.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents Company entity
 */
@Entity
@Data
@Getter
@Setter
@ToString
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long companyId;

    @Column()
    private Long owner_id;

    @Column()
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnoreProperties("company")
    private List<JobOpening> jobOpenings = new ArrayList<>();

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnoreProperties("company")
    private List<User> employees = new ArrayList<>();

    public Company() {
    }

    //Temporal constructor
    public Company(Long owner_id, String name) {
        this.owner_id = owner_id;
        this.name = name;
    }

    public void addJobOpening(JobOpening jobOpening){
        jobOpenings.add(jobOpening);
        jobOpening.setCompany(this);
    }
    public void removeJobOpening(JobOpening jobOpening){
        jobOpenings.remove(jobOpening);
        jobOpening.setCompany(null);
    }

    public void addEmployee(User user){
        employees.add(user);
        user.setCompany(this);
    }
    public void removeEmployee(User user){
        employees.remove(user);
        user.setCompany(null);
    }

}
