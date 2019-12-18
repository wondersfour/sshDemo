package com.wonders.springdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wonders.springdatajpa.entity.User;


/**
 * 使用springdata jpa 
 * 参考：https://www.cnblogs.com/oukele/p/10156585.html
 * @author zj
 *
 */
public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByNameAndPassword(String name,String password);
}
