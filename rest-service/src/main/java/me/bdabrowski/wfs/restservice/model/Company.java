package me.bdabrowski.wfs.restservice.model;

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
    private Long id;

    @Column()
    private Long owner_id;

    @Column()
    private String name;

    /**
     * A List of JobOpenings created by company based on company_id
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<JobOpening> jobOpenings = new ArrayList<>();

    public Company() {
    }

    //Temporal constructor
    public Company(Long owner_id, String name) {
        this.owner_id = owner_id;
        this.name = name;
    }

    /**
     * Sets the
     *
     * @param jobOpenings
     */
    public void setJobOpenings(List<JobOpening> jobOpenings) {
        this.jobOpenings = jobOpenings;
    }

}
