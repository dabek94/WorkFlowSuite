package me.bdabrowski.wfs.restservice.repository;

import me.bdabrowski.wfs.restservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getByEmailAndPassword(String email, String password);

    @Query("select u.firstName as first_name, u.lastName as lastName, u.address.id " +
            "from User u " +
            "where u.companyId=?1")
    Optional<List<User>> getUsersByCompanyId(Long companyId);
}
