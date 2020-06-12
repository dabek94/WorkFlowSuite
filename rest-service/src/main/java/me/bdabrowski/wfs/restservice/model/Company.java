package me.bdabrowski.wfs.restservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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

    public Company(){};

    //Temporal constructor
    public Company(Long owner_id, String name) {
        this.owner_id = owner_id;
        this.name = name;
    }

}