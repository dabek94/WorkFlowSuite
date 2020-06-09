package me.bdabrowski.wfs.restservice.controller;

import me.bdabrowski.wfs.restservice.model.Address;
import me.bdabrowski.wfs.restservice.model.User;
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

    @PostConstruct
    public void init(){
        for (User user :
             createUsers()) {
            user.setAddress(createAddresses());
            userRepository.save(user);
        }

    }
    private List<User> createUsers(){
        List<User> users = List.of(
                new User("employee@pl", "employee", "Andrzej", "Andrzejowski", "employee", 1L),
                new User("employer@pl", "employer", "Sebastian", "Sabastianski", "employer",1L)

        );
        return users;
    }
    private Address createAddresses(){
        Random random = new Random();
        int n = random.nextInt();
        return new Address("street" + n, "city"+n,"state" + n,"country" + n, "zip" + n);
    }
}
