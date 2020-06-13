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
        for (User user :
                createUsers()) {
            user.setAddress(createAddresses());
            userRepository.save(user);
        }
        for (Company company :
                createCompanies()) {
            company.setJobOpenings(createJobOpenings());
            companyRepository.save(company);
        }


    }

    private List<User> createUsers() {
        List<User> users = List.of(
                new User("employee@pl", "employee", "Andrzej", "Andrzejowski", "employee", 5L),
                new User("employer@pl", "employer", "Sebastian", "Sabastianski", "employer", 5L)

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
                new JobOpening(5L, "shortDescription" + random.nextInt(), "PostionA"),
                new JobOpening(5L, "shortDescription" + random.nextInt(), "PostionB"),
                new JobOpening(5L, "shortDescription" + random.nextInt(), "PostionC"),
                new JobOpening(5L, "shortDescription" + random.nextInt(), "PostionD"),
                new JobOpening(5L, "shortDescription" + random.nextInt(), "PostionE"),
                new JobOpening(5L, "shortDescription" + random.nextInt(), "PostionF"),
                new JobOpening(5L, "shortDescription" + random.nextInt(), "PostionG"),
                new JobOpening(5L, "shortDescription" + random.nextInt(), "PostionH"),
                new JobOpening(5L, "shortDescription" + random.nextInt(), "PostionI")

                );
        return openings;
    }
}
