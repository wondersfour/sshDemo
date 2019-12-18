package com.imooc.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring工具类
 * @author zj
 *
 */
public class ApplicationContextUtil {
	
	public static ApplicationContext getApplicationContext(){
		ApplicationContext content = new ClassPathXmlApplicationContext("applicationContext.xml");
		return content;
	}
}
