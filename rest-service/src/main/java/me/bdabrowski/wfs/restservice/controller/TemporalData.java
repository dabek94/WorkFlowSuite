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
                new User("email1@pl", "password1", "andrzej", "nazwisko1", "employee", 1L),
                new User("email1@p2", "password2", "andrzej", "nazwisko2", "employer",1L),
                new User("email1@p3", "password3", "andrzej", "nazwisko3", "employee",1L),
                new User("email1@p4", "password4", "andrzej", "nazwisko4", "employee",2L),
                new User("email1@p5", "password5", "andrzej", "nazwisko5", "employee",3L),
                new User("email1@p6", "password6", "andrzej", "nazwisko6", "employee",3L),
                new User()
        );
        return users;
    }
    private Address createAddresses(){
        Random random = new Random();
        int n = random.nextInt();
        return new Address("street" + n, "state" + n,"country" + n, "zip" + n);
    }
}
