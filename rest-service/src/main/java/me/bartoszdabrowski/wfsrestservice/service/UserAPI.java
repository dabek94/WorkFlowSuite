package me.bartoszdabrowski.wfsrestservice.service;

import me.bartoszdabrowski.wfsrestservice.model.User;

import java.util.List;

public interface UserAPI {

    int insertUser(User user);

    User selectUser(String email);

    User selectUser(String email, String password);

    List<User> selectUsers(int companyId);

    int updateUser(User user);

    int deleteUser(User user);


}
