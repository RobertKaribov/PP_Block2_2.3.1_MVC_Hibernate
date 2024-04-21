package web.services;

import web.models.User;

import java.util.List;

public interface UserServices {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);
}
