package me.bdabrowski.wfs.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
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

    @ManyToOne()
    @JsonIgnoreProperties({"jobOpenings","employees"})
    private Company company;

    private String position;
    private String shortDescription;
    private Date createdTime;

    public JobOpening() {
    }

    public JobOpening(String shortDescription, String position) {
        this.shortDescription = shortDescription;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof JobOpening))
            return false;
        return
                id != null &&
                        id.equals(((JobOpening) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }


}
