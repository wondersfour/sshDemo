package com.imooc.test;

import org.junit.Test;

import com.imooc.dao.User;
import com.imooc.domain.Demo1;
import com.imooc.ioc.PropertyDemo;
import com.imooc.service.UserService;
import com.imooc.util.ApplicationContextUtil;

/**
 * 编写测试类进行测试，通过配置文件创建类对象
 * @author zj
 *
 */
public class TestIoc {
	
	
	@Test
	public void testUser() {
		User user = (User)ApplicationContextUtil.getApplicationContext().getBean("user");
		user.add();
		System.out.println(user);
	}
	
	@Test
	public void testDemo1() {
		Demo1 demo1 = (Demo1)ApplicationContextUtil.getApplicationContext().getBean("demo1");
		demo1.say();
		//System.out.println(user);
	}
	@Test
	public void testServiceIoc() {
		UserService userService = (UserService)ApplicationContextUtil.getApplicationContext().getBean("userService");
		userService.addUser(new User());
		//System.out.println(user);
	}
	
	@Test
	public void testPropertyDemo() {
		PropertyDemo PropertyDemo = (PropertyDemo)ApplicationContextUtil.getApplicationContext().getBean("propertyDemo");
		System.out.println(PropertyDemo);
	}

}
