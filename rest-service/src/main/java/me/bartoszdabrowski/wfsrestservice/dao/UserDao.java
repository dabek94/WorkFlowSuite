package me.bartoszdabrowski.wfsrestservice.dao;

import me.bartoszdabrowski.wfsrestservice.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    int insertUser(User user);

    User selectUserById(String userUUID);

    User selectUserByEmailAndPassword(String email, String password);

    int deleteUserById(String id);

    int updateUserById(String id, User user);

}
