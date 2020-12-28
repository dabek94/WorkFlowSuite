package com.bdabrowski.wfs.services.userservice.controller;

import com.bdabrowski.wfs.services.userservice.model.User;
import com.bdabrowski.wfs.services.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id){
        log.info("Inside findUserById of userController");
        return userService.findUserByUserId(id);
    }
    @GetMapping("/employees/{id}")
    public List<User> findUsersByCompanyId(@PathVariable("id") Long id){
        log.info("Inside findUsersByCompanyId");
        return userService.findUsersByCompanyId(id);
    }



}
