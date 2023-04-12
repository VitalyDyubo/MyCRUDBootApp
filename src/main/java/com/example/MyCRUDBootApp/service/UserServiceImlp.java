package com.example.MyCRUDBootApp.service;

import com.example.MyCRUDBootApp.dao.UserDao;
import com.example.MyCRUDBootApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImlp implements UserService {

    private UserDao userDao;

    public UserServiceImlp(@Autowired UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Transactional(readOnly = true)
    @Override
    public User show(long id) {
        return userDao.show(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);

    }

    @Transactional
    @Override
    public void update(long id, User updateUser) {
        userDao.update(id, updateUser);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }
}
