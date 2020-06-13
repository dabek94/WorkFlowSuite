package me.bdabrowski.wfs.restservice;

import me.bdabrowski.wfs.restservice.model.User;
import me.bdabrowski.wfs.restservice.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void SaveUserThenGetUserByEmailAndPasswordShouldHaveMatchingEmails(){
        User newUser = new User( "email",  "password",  "firstName",
                "lastName", "userType",  1L );
        userRepository.save(newUser);
    }


}
