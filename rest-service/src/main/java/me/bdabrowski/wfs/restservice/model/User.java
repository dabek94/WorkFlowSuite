package me.bdabrowski.wfs.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column()
    private String password;

    @Column()
    private String firstName = "null";

    @Column()
    private String lastName = "null";

    @Column()
    private String userType = "null";

    @ManyToOne()
    @JsonIgnoreProperties({"jobOpenings","employees"})
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    Address address = new Address();

    /*
            TEMPORARY CONSTROCTOR USED IN TEMPORARLDATA CLASS, WILL BE REMOVE IN PRODUCTION
     */
    public User(String email, String password, String firstName, String lastName, String userType) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }

    public void setAddress(Address address) {
        this.address = address;
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
