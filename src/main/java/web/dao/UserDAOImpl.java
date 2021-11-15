package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User showUser(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUserById(Integer id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        User user1 = entityManager.find(User.class, user.getId());
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        user1.setAge(user.getAge());
        user1.setEmail(user.getEmail());
    }

}
