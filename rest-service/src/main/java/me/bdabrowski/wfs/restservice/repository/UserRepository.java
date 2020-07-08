package me.bdabrowski.wfs.restservice.repository;

import me.bdabrowski.wfs.restservice.model.Company;
import me.bdabrowski.wfs.restservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByEmailAndPassword(String email, String password);
    @Query("select u.firstName As first_name, u.lastName As lastName " +
            "from User u " +
            "where u.company.companyId=?1")
    Optional<List<User>> getUsersByCompanyId(Long companyId);

}
