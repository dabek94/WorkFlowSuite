package me.bdabrowski.wfs.restservice;

import me.bdabrowski.wfs.restservice.model.Address;
import me.bdabrowski.wfs.restservice.model.User;
import me.bdabrowski.wfs.restservice.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private static User user;

    @Before
    public void userSetUp(){
        user = new User( "test@pl",  "s3cret",  "John",
                "Smith", "employee");
    }

    @Test
    public void saveUserThenGetUserByEmailAndPasswordShouldHaveMatchingEmails(){
        userRepository.save(user);
        Optional<User> optionalUser = userRepository.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        User dataUser = new User();
        if(optionalUser.isPresent()){
            dataUser = optionalUser.get();
         }
        assertEquals(user,dataUser);
    }

    @Test
    public void saveUserWithAddressThenGetUserByIdReturnedUserShouldHaveAnAddress(){
        Address address = new Address("Simple Street", "Testville", "TY",
                                     "Test Islands", "135-35");
        user.setAddress(address);
        userRepository.save(user);
        Optional<User> optionalUser = userRepository.findById(1L);
        if(optionalUser.isPresent()){
            assertEquals(optionalUser.get().getAddress(), user.getAddress());
        }
        assertEquals(user.getAddress(), address);
    }


    @Test
    public void deleteUserShouldRemoveUserAndAddressEntity(){
        Address address = new Address("Simple Street", "Testville", "TY",
                "Test Islands", "135-35");
        user.setAddress(address);
        userRepository.save(user);

        userRepository.delete(user);

    }
}
