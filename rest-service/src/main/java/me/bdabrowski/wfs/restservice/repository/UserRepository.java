package me.bdabrowski.wfs.restservice.repository;

import me.bdabrowski.wfs.restservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


/**
 * A repository API for User Entity.
 * CRUD operations nn Spring Data JPARepository with custom queries.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Query for user authorization
     * @param email given user email
     * @param password given user password
     * @return User if database contains user with matching email and password
     */
    Optional<User> getByEmailAndPassword(String email, String password);

    /**
     * Query for employee list
     * @param companyId company id in which employees work
     * @return List of employees working in the given company
     */
    @Query("select u.firstName As first_name, u.lastName As lastName " +
            "from User u " +
            "where u.companyId=?1")
    Optional<List<User>> getUsersByCompanyId(Long companyId);

}
