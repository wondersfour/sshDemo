package com.imooc.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;

import com.imooc.dao.User;
import com.imooc.dao.UserDao;
import com.imooc.util.BaseDaoImpl;

public class UserDaoImpl /*extends BaseDaoImpl*/ implements UserDao {


	public void add(User user) {
		//System.out.println(sessionFactory.getCurrentSession()+"========getSession==============");
		System.out.println("添加用户了12345...");
		/*Serializable id =addObject(user);
		System.out.println(id+"=======数据添加成功============");*/
	}

}
