package me.bdabrowski.wfs.restservice.controller;

import me.bdabrowski.wfs.restservice.model.Address;
import me.bdabrowski.wfs.restservice.model.Company;
import me.bdabrowski.wfs.restservice.model.JobOpening;
import me.bdabrowski.wfs.restservice.model.User;
import me.bdabrowski.wfs.restservice.repository.CompanyRepository;
import me.bdabrowski.wfs.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Component
public class TemporalData {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @PostConstruct
    public void init() {
        for (Company company :
                createCompanies()) {
            createJobOpenings().forEach(jobOpening -> company.addJobOpening(jobOpening));
            createUsers().forEach(user -> {user.setAddress(createAddresses()); company.addEmployee(user);});
            companyRepository.save(company);
        }
    }

    private List<User> createUsers() {
        List<User> users = List.of(
                new User("email1@pl", "test", "Andrzej", "Andrzejowski", "employee"),
                new User("email2@pl", "test", "Sebastian", "Sabastianski", "employer")
        );
        return users;
    }

    private Address createAddresses() {
        Random random = new Random();
        int n = random.nextInt();
        return new Address("street" + n, "city" + n, "state" + n, "country" + n, "zip" + n);
    }

    private List<Company> createCompanies() {
        List<Company> companies = List.of(
                new Company(3L, "Wsiz")
        );
        return companies;
    }

    private List<JobOpening> createJobOpenings() {
        Random random = new Random();
        List<JobOpening> openings = List.of(
                new JobOpening( "Programista Java" , "Programista"),
                new JobOpening( "Programista C#" , "Programista"),
                new JobOpening( "Programista C++", "Programista"),
                new JobOpening( "Menadzer Hotelu", "Menadzer"),
                new JobOpening( "Kasjer", "Kasjer"),
                new JobOpening( "Prawnik", "Prawnik"),
                new JobOpening( "Stazysta w biurze", "Stazysta"),
                new JobOpening( "Kasjer", "Kasjer"),
                new JobOpening( "Pracownik magazynu", "magazyn")
        );
        return openings;
    }
}
