package me.bartoszdabrowski.wfsrestservice.controller;

import me.bartoszdabrowski.wfsrestservice.dao.UserDao;
import me.bartoszdabrowski.wfsrestservice.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @PostMapping(value = "/users/createUser", consumes = "application/json", produces = "application/json")
    public int createUser(@RequestBody User user){
        return userDao.insertUser(user);
    }


    @GetMapping(value = "/users/{UUID}", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<User> getById(@PathVariable("UUID") String id){
        User user = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "UseController");
        try{
            user = userDao.selectUserById(id);
        } catch (Exception e){
            return ResponseEntity.accepted().headers(headers).body(user);
        }
        return ResponseEntity.ok().headers(headers).body(user);
    }

    //TODO NULL POINTER CHECK IN CASE OF .selectUserByEmail return null throws into 500 error page
    @GetMapping(value = "/users/{email}/{password}", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email,
                                           @PathVariable("password") String password){
        User user = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "UseController");
        try{
            user = userDao.selectUserByEmailAndPassword(email, password);
        } catch (Exception e){
        }

        String pass = user.getPassword();
        if(pass.equals(password)){
            return ResponseEntity.ok().headers(headers).body(user);
        }
        else{
            return ResponseEntity.status(404).headers(headers).body(user);
        }
    }


}
