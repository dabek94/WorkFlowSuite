package me.bdabrowski.wfs.restservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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

    private String position;
    private String shortDescription;
    private Date createdTime;


    public JobOpening() {
    }

    public JobOpening(String shortDescription, String position) {
        this.shortDescription = shortDescription;
        this.position = position;
    }


}
