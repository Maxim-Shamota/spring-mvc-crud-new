package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void saveUser(User user);

    User showUser(Integer id);

    void removeUserById(Integer id);

    void updateUser(User user);
}