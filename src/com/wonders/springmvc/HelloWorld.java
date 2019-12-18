package com.wonders.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imooc.dao.User;
import com.imooc.service.UserService;
import com.imooc.util.ApplicationCtx;

/**
 * springmvc  demo
 * @author zj
 * 
 * 想要整合百度uedit参考
 * https://blog.csdn.net/jinzhoujiannan/article/details/76440882
 *
 */
@Controller
public class HelloWorld {
	
	@RequestMapping("/helloworld.do")
	public String hello(){
	/*	ApplicationCtx applicationCtx = new ApplicationCtx();
		UserService userService = (UserService) applicationCtx.Getbeans("userService");
		userService.addUser(new User());
		applicationCtx.Getbeans("sessionFactory");*/
		return "success";
	}
	
	/*@RequestMapping("/helloworld.do")
	public String hello(){
		ApplicationCtx applicationCtx = new ApplicationCtx();
		UserService userService = (UserService) applicationCtx.Getbeans("userService");
		userService.addUser(new User());
		applicationCtx.Getbeans("sessionFactory");
		return "success";
	}*/

}
