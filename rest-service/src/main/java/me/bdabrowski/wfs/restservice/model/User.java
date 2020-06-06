package me.bdabrowski.wfs.restservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@ToString
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

    @Column()
    private Long companyId = 0L;

    @OneToOne(cascade = CascadeType.ALL)
    Address address = new Address();

    public User(){};

    /*
            TEMPORARY CONSTROCTOR USED IN TEMPORARLDATA CLASS, WILL BE REMOVE IN PRODUCTIOn
     */
    public User(String email, String password, String firstName, String lastName, String userType, Long companyId) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
        this.companyId = companyId;
    }

    public void setAddress(Address address){
        this.address = address;
    }
}
