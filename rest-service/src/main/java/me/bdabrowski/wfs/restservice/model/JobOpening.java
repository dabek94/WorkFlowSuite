package me.bdabrowski.wfs.restservice.model;

import lombok.*;

import javax.persistence.*;

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


    public JobOpening() {
    }

    public JobOpening(Long companyId, String shortDescription, String position){
        this.companyId = companyId;
        this.shortDescription = shortDescription;
        this.position = position;
    }

}
