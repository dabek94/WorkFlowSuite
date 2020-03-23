package me.bartoszdabrowski.wfsrestservice.dao;

import me.bartoszdabrowski.wfsrestservice.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    int insertPerson(User user);

    Optional<User> selectUserById(int userId);

}
