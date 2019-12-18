package com.wonders.annotation;

import org.springframework.stereotype.Component;

/**
 * 开启组件扫描
 * 通过注解
 * @author zj
 *
 */
@Component(value="users")
public class User {
	public void addUser(){
		System.out.println("user added...");
		
	}

}
