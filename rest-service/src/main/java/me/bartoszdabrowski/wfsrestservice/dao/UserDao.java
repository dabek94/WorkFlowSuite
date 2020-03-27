package me.bartoszdabrowski.wfsrestservice.dao;

import me.bartoszdabrowski.wfsrestservice.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    int insertPerson(User user);

    User selectUserById(int userId);

    User selectUserByEmail(String email, String password);

    int deleteUserById(int id);

    int updateUserById(int id, User user);

}
