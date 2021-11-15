package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUser(Integer id);

    void editUser(User user);

    User getUserById(Integer id);

    List<User> getAllUsers();
}
