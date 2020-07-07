package me.bdabrowski.wfs.restservice.controller;

import me.bdabrowski.wfs.restservice.model.Address;
import me.bdabrowski.wfs.restservice.model.User;
import me.bdabrowski.wfs.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * A controller class for host:port/users endpoint
 */
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    /**
     * Instance of UserRepository interface assigned by Spring Context Dependency Injection
     */
    @Autowired
    UserRepository userRepository;

    /**
     * POST request listener to endpoint host:port/users/{email}/{password}
     *
     * @param email    given user email
     * @param password given user password
     *                 JSON representation of user if user with given param email and password exists in database
     *                 or 302 status code if user does not exist
     */
    @PostMapping("/{email}/{password}")
    public ResponseEntity<User> selectByEmailAndPassword(@PathVariable(value = "email") String email,
                                                         @PathVariable(value = "password") String password) {
        return userRepository
                .getByEmailAndPassword(email, password)
                .map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * GET request listener to endpoint host:port/users/{companyId} that searches for all users with matching company_id
     *
     * @param companyId company id in which employees work
     * @return JSON Array representation of type USER if any is matching otherwise returns 302 with empty list
     */

    @GetMapping("{companyId}")
    public ResponseEntity<List<User>> selectUsersByCompanyId(@PathVariable(value = "companyId") Long companyId) {
        return userRepository.getUsersByCompanyId(companyId)
                .map(users -> ResponseEntity.ok().body(users))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST request listener to endpoint host:port/users used to create new User
     *
     * @param user User values matching the entity scheme, given in the request body as JSON
     * @return JSON representation of user if adding company to database was successful,
     * otherwise returns 417 status code
     */

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User newUser = userRepository.save(user);
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }

    }
    //THIS REQUIRES NOT NULL IN FORM

    /**
     * PUT request listener to endpoint host:port/update/email/{id}  responsible for updating the specific User
     * based on given id
     *
     * @param user New User values matching the entity scheme, given in the request body as JSON
     * @param id   id of the desired User
     * @return JSON representation of user if updating user in database was successful, otherwise
     * returns 417 status code
     */
    @PutMapping("/update/email/{id}")
    public ResponseEntity<User> updateEmail(@RequestBody User user, @PathVariable("id") Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User _user = existingUser.get();
            _user.setEmail(user.getEmail());
            userRepository.save(_user);
            return new ResponseEntity<>(_user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * PUT request listener to endpoint
     * @par user
     * @param id
     * @return
     */
    @PutMapping("/update/password/{id}")
    public ResponseEntity<User> updatePassword(@RequestBody User user,
                                               @PathVariable("id") Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User _user = existingUser.get();
            _user.setPassword(user.getPassword());
            userRepository.save(_user);
            return new ResponseEntity<>(_user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/address/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address,
                                                 @PathVariable("id") Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User _user = existingUser.get();
            Address _address = _user.getAddress();
            _address.setStreet(address.getStreet());
            _address.setCity(address.getCity());
            _address.setState(address.getState());
            _address.setZipCode(address.getZipCode());
            _address.setCountry(address.getCountry());
            _user.setAddress(_address);
            userRepository.save(_user);
            return new ResponseEntity<>(_user.getAddress(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().body(user);
        }).orElse(ResponseEntity.notFound().build());
    }
}
