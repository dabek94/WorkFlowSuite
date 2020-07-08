package me.bdabrowski.wfs.restservice.controller;

import javassist.NotFoundException;
import me.bdabrowski.wfs.restservice.model.Address;
import me.bdabrowski.wfs.restservice.model.User;
import me.bdabrowski.wfs.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
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

    @Autowired
    UserRepository userRepository;



    @GetMapping("{companyId}")
    public ResponseEntity<List<User>> selectUsersByCompanyId(@PathVariable(value = "companyId") Long companyId) {
        return userRepository.getUsersByCompanyId(companyId)
                .map(users -> ResponseEntity.ok().body(users))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("duplicate/{email}")
    public ResponseEntity<Boolean> doesUserWithGivenEmailExist(@PathVariable(value = "email") String email){
        return userRepository.getUserByEmail(email)
                .map(user -> ResponseEntity.ok().body(true))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{email}/{password}")
    public ResponseEntity<User> selectByEmailAndPassword(@PathVariable(value = "email") String email,
                                                         @PathVariable(value = "password") String password) {
        return userRepository
                .getUserByEmailAndPassword(email, password)
                .map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }
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
