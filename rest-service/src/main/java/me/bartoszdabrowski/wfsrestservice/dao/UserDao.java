package me.bartoszdabrowski.wfsrestservice.dao;

import me.bartoszdabrowski.wfsrestservice.model.User;
import me.bartoszdabrowski.wfsrestservice.model.UserDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    int insertUser(User user);

    User selectUser(String email);

    User selectUser(String email, String password);

    List<User> selectUsers(String companyId);

    int updateUserById(String id, User user);

    int deleteUserById(String id);


}
