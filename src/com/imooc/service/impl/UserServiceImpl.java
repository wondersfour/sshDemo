package com.imooc.service.impl;

import com.imooc.dao.User;
import com.imooc.dao.UserDao;
import com.imooc.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public void addUser(User user) {
		this.userDao.add(user);
	}
	
	

}
