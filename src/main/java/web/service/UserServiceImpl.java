package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User showUser(Integer id) {
        return userDAO.showUser(id);
    }

    @Override
    public void removeUserById(Integer id) {
        userDAO.removeUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

}
