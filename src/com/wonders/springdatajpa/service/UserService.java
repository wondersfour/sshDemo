package com.wonders.springdatajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wonders.springdatajpa.dao.UserDao;
import com.wonders.springdatajpa.entity.User;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findNameAndPassword(String name,String password){
        return userDao.findByNameAndPassword(name, password);
    }
    
    public List<User> list(){
        List<User> list = userDao.findAll();
        return list;
    }
}
