package me.bartoszdabrowski.wfsrestservice.dao;

import me.bartoszdabrowski.wfsrestservice.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository("userDao")
@Transactional
public class UserDataAccessService implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int insertUser(User user) {
        entityManager.persist(user);
        return 1;
    }

    @Override
    public User selectUserByEmailAndPassword(@NotNull final String email, @NotNull final String password) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from user_core u where u.email = :email and u.password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List list = query.getResultList();
        return (User) list.get(0);
    }

    @Override
    public User selectUserById(String uuid) {
        return entityManager.find(User.class, uuid);
    }

    @Override
    public int deleteUserById(String id) {
        User user = selectUserById(id);
        if(entityManager.contains(user)){
            entityManager.remove(user);
            return 0;
        }
        else {
            entityManager.remove(entityManager.merge(user));
            return 1;
        }
    }

    @Override
    public int updateUserById(String id, User user) {
        return 0;
    }
}
