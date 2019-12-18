package com.wonders.springdatajpa;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wonders.springdatajpa.entity.User;
import com.wonders.springdatajpa.service.UserService;
 
import java.util.List;

/**
 * 测试配置是否成功
 * @author zj
 *
 */
public class SpringDataJpaTest {
	
	
	public static void main(String[] args) {
		  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
	        UserService service = context.getBean(UserService.class);
	        
	        User user = service.findNameAndPassword("oukele","oukele");
	        System.out.println(user.getName());
	         
	        List<User> list = service.list();
	        for (User user1 : list) {
	            System.out.println(user1.getName()+" - "+user1.getPassword());
	        }
	}
}
