package com.example.service;

import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Wrap operations inside @Transactional so
// Spring handles database transactions.
@Service
@Transactional
public class UserServiceImpl implements UserService {

private final UserDao userDao;
@Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers(){
    return  userDao.getAllUsers();
}

@Override
    @Transactional(readOnly = true)
    public  User getUserById(Long id){
    return userDao.getUserById(id);
}
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
