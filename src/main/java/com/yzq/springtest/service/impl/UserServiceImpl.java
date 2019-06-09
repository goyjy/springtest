package com.yzq.springtest.service.impl;

import com.yzq.springtest.dao.UserDao;
import com.yzq.springtest.dao.UserNameDao;
import com.yzq.springtest.entity.User;
import com.yzq.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserNameDao userNameDao;
    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User update(User user) {
        return userDao.save(user);
    }

    @Override
    public void delete(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findOne(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findByUsernameLike(String username) {
        return userNameDao.findByUsernameLike("%"+username+"%");
    }
}
