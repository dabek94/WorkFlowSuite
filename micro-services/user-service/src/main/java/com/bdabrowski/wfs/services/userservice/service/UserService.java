package com.bdabrowski.wfs.services.userservice.service;

import com.bdabrowski.wfs.services.userservice.model.User;
import com.bdabrowski.wfs.services.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        log.info("Inside of saveUser of UserService");
        return userRepository.save(user);
    }

    public User findUserByUserId(Long id) {
        log.info("Inside of findUserByUserId of UserService");
        return userRepository.findById(id).orElse(new User());
    }

    public List<User> findUsersByCompanyId(Long id) {
        return userRepository.findAllByCompanyId(id);
    }
}
