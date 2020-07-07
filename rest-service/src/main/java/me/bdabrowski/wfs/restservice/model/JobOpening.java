package me.bdabrowski.wfs.restservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Represents the available job positions that company is currently seeking
 */
@Entity
@Data
@Getter
@Setter
@ToString
public class JobOpening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long companyId;
    private String position;
    private String shortDescription;
    private Date createdTime;


    public JobOpening() {
    }

    public JobOpening(Long companyId, String shortDescription, String position) {
        this.companyId = companyId;
        this.shortDescription = shortDescription;
        this.position = position;
    }


}
