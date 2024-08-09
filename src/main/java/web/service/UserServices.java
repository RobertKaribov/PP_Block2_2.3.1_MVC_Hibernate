package web.service;

import web.model.User;

import java.util.List;

public interface UserServices {
    List<User> getAllUsers();
    User getUserById(int id);
    void saveUser(User user);
    void updateUser(int id, User updatedUser);
    void deleteUser(int id);
}
