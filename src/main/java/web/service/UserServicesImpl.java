package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserDao userDAO;

    @Transactional(readOnly = true)
    public List<User> index() {
        return userDAO.index();
    }

    @Transactional
    public User show(int id) {
        return userDAO.show(id);

    }
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }
    @Transactional
    public void update(int id, User updatedUser) {
        userDAO.update(id, updatedUser);

    }
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
