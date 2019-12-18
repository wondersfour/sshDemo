package com.wonders.test;

import org.junit.Test;

import com.imooc.util.ApplicationContextUtil;
import com.wonders.annotation.User;

public class AnnotationTest {
	
	@Test
	public void testUser(){
		User user = (User) ApplicationContextUtil.getApplicationContext().getBean("users");
		System.out.println(user);
		user.addUser();
	}
}
