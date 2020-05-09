package me.bartoszdabrowski.wfsrestservice.controller;

import me.bartoszdabrowski.wfsrestservice.dao.UserDao;
import me.bartoszdabrowski.wfsrestservice.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
    public int createUser(@RequestBody User user) {
            return userDao.insertUser(user);

    }

    @GetMapping(value = "/users/{email}")
    @ResponseBody
    public ResponseEntity<User> getById(@PathVariable("email") String email){
        User user = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "UseController");
        try{
            user = userDao.selectUser(email);
        } catch (Exception e){
            return ResponseEntity.accepted().headers(headers).body(user);
        }
        return ResponseEntity.ok().headers(headers).body(user);
    }

    //Is this good path clean code wise?
    @PostMapping(value = "/users/{email}/{password}")
    @ResponseBody
    public ResponseEntity<User> getUser(@PathVariable("email") String email,
                                        @PathVariable("password") String password){
        User user = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "UseController");
        try{
            user = userDao.selectUser(email);
            if(user.getPassword().equals(password)){
                return ResponseEntity.ok().headers(headers).body(user);
            }
        } catch (Exception e){
            return ResponseEntity.accepted().headers(headers).body(user);
        }
        return ResponseEntity.badRequest().headers(headers).body(null);
    }

    //getUserByCompanyId : List<Users>
   /* @GetMapping(value = "/users/{companyId}")
    @ResponseBody
    public ResponseEntity<List<User>> getUsersByCompany(@PathVariable("companyId") String companyId){
        List<User> users = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "UseController");


    }*/
    //updateUser : boolean

    //deleteUser : boolean






}
